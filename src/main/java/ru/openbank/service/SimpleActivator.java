package ru.openbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.openbank.model.Option;
import ru.openbank.model.Person;
import ru.openbank.model.Status;
import ru.openbank.service.behavior.Activator;
import ru.openbank.service.behavior.Sender;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ����� on 06.11.2019.
 */
@Service
public class SimpleActivator implements Activator{
    @Autowired
    private PairSearcher searcher;
    @Autowired
    private DataSaver saver;
    @Autowired
    private Sender sender;

    public void activateSearcher(Person customer) {
        Person partner = searcher.searchPair(customer);
        if (partner!=null) {
            partner.setStatus(Status.BISY);
            customer.setStatus(Status.BISY);
            saver.update(partner);
        }
        else
        {
            customer.setStatus(Status.FREE);
        }
        saver.update(customer);

        notifyPair(customer, partner);
    }

    public void updatePerson(Person person) {
        saver.update(person);
    }

    public void notifyPair(Person customer, Person partner) {
        sender.send(customer.getMail(), createMessageInvitationBody(customer, partner));
        sender.send(partner.getMail(), createMessageInvitationBody(partner, customer));
    }

    public List<Person> all()
    {
        return saver.getAll().values().stream().collect(Collectors.toList());
    }

    private String createMessageInvitationBody(Person customer, Person partner)
    {
        String dear = customer.getSex().equals("F")?"������� ":"������� ";
        //String invitation = partner.getSex().equals("F")?" ���������� ":" ��������� "
        String about = partner.getOptions().contains(Option.ABOUTWORK)?" ���������� �� ������� ���� " : " ���������� ";
        String deal = "";
        if ( partner.getOptions().contains(Option.LISTENING) && partner.getOptions().contains(Option.TALKIG))
            deal = "��� ���������� ����� ��������� � ����������.";
        else if (partner.getOptions().contains(Option.LISTENING))
            deal = "��� ���������� ������ ������������ ���� ����������.";
        else if(partner.getOptions().contains(Option.TALKIG))
            deal = "��� ���������� ����� ����� ����������.";

        String msg = "������ ����!\n"+dear+customer.getName()+
                ", ��� ���������� �� ������� "+partner.getName()+about+" �� �������� ���������� ����.\n"+
                deal+"\n"+
                "���������� ��� ����������� � 13:00, ��� ������������ � ����� ������������ �� ������, ������� ��� ��� �����.\n\n"+
                "�������� ��� �����: \n"+
                "Mail: "+partner.getMail()+"\n";
        if (partner.getPhone()!=null)
            msg=msg+"���. "+partner.getPhone();

        msg=msg+"\n\n"+"������� ������ ��� ��������� ��������� ;)";

        return msg;
    }

    private String createMessageCancelBody(Person customer, Person partner)
    {
        String dear = customer.getSex().equals("F")?"������� ":"������� ";
        //String invitation = partner.getSex().equals("F")?" ���������� ":" ��������� "
        String about = partner.getOptions().contains(Option.ABOUTWORK)?" ���������� �� ������� ���� " : " ���������� ";
        String msg = dear+customer.getName()+
                ", � ���������, "+partner.getName()+about+" ������� ���� �������.\n"+
                "�� �����������, � ��������� ����� �� ����� ��� ������ �����������!\n";

        msg=msg+"\n\n"+"� ���������, ��� �������";
        return msg;
    }
    @Scheduled(fixedDelay = 20000)
    public void revision() {
        for (Person expiredPerson : getExpiredPersons())
        {
            expiredPerson.setStatus(Status.FREE);
            saver.update(expiredPerson);
        }
        Map<Person, Person> pairMap = getFreePersons();
        for (Map.Entry<Person, Person> entry : pairMap.entrySet())
        {
            entry.getKey().setStatus(Status.BISY);
            entry.getValue().setStatus(Status.BISY);
            saver.update(entry.getKey());
            saver.update(entry.getValue());
            notifyPair(entry.getKey(), entry.getValue());
        }

    }

    public Map<Person,Person> getFreePersons()
    {
        List<Person> freePersons = saver.getAll().values().stream().filter(x->x.getStatus().equals(Status.FREE)).collect(Collectors.toList());
        Map<Person, Person> pairMap = new HashMap<>();
        Person person1=null;
        Person person2=null;
        for(Person person : freePersons)
        {
            person1=person1==null?person:person1;
            person2=person2==null && person1!=null?person:person2;
            if (person1!=null && person2!=null)
            {
                pairMap.put(person1, person2);
                person1 = null;
                person2 = null;
            }
        }
        return pairMap;
    }

    public List<Person> getExpiredPersons()
    {
        List<Person> expiredPersons = saver.getAll().values().stream()
                .filter(x -> x.getStatus().equals(Status.BISY) && daysBetween(x.getStartDate(), new Date()) > 0)
                .collect(Collectors.toList());
        return expiredPersons;
    }

    private int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
}
