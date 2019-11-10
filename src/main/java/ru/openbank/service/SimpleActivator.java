package ru.openbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.openbank.model.Option;
import ru.openbank.model.Person;
import ru.openbank.model.Status;
import ru.openbank.service.behavior.Activator;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Елена on 06.11.2019.
 */
@Service
public class SimpleActivator implements Activator {
    @Autowired
    private PairSearcher searcher;
    @Autowired
    private SimpleDataSaver saver;
    @Autowired
    private MailSender sender;

    public Person activateSearcher(Person customer) {
        customer = saver.get(customer.getMail());
        Person partner = searcher.searchPair(customer);

        if (partner != null) {
            partner.setStatus(Status.BISY);
            customer.setStatus(Status.BISY);
            partner.setPartner(customer);
            customer.setPartner(partner);
            partner.setStartDate(new Date());
            customer.setStartDate(new Date());
            saver.update(partner);
            saver.update(customer);
            notifyPair(customer, partner);
            return partner;
        }
        return null;
    }

    public void cancelMeeting(Person customer) {
        customer = saver.get(customer.getMail());
        Person partner = customer.getPartner();
        if (partner != null) {
            partner.setStatus(Status.FREE);
            partner.setStartDate(null);
            partner.setPartner(null);
            saver.update(partner);
            notifyPartner(customer, partner);
        }
        customer.setStatus(Status.FREE);
        customer.setPartner(null);
        customer.setStartDate(null);
        saver.update(customer);
    }

    public void updatePerson(Person person) {
        saver.update(person);
    }

    public void notifyPair(Person customer, Person partner) {
        sender.send(customer.getMail(), createMessageInvitationBody(customer, partner));
        sender.send(partner.getMail(), createMessageInvitationBody(partner, customer));
    }

    public void notifyPartner(Person customer, Person partner) {
        sender.send(partner.getMail(), createMessageCancelBody(partner, customer));
    }

    private String createMessageInvitationBody(Person customer, Person partner) {
        String dear = customer.getSex().equals("F") ? "Дорогая " : "Дорогой ";
        String about = partner.getOptions().contains(Option.ABOUTWORK) ? " пообщаться на деловые темы " : " пообщаться ";
        String deal = "";
        if (partner.getOptions().contains(Option.LISTENING) && partner.getOptions().contains(Option.TALKIG))
            deal = "Ваш собеседник любит послушать и поговорить.";
        else if (partner.getOptions().contains(Option.LISTENING))
            deal = "Ваш собеседник больше предпочитает быть слушателем.";
        else if (partner.getOptions().contains(Option.TALKIG))
            deal = "Ваш собеседник очень любит поговорить.";

        String msg = "Добрый день!\n" + dear + customer.getName() +
                ", вас приглашает на встречу " + partner.getName() + about + "за чашечкой ароматного кофе.\n" +
                deal + "\n" +
                "Предлагаем вам договориться о встрече с вашим собеседником на удобное для вас время.\n\n" +
                "Контакты для связи: \n" +
                "Mail: " + partner.getMail() + "\n";


        msg = msg + "\n\n" + "Кофебот желает вам приятного кофепития ;)";

        return msg;
    }

    private String createMessageCancelBody(Person customer, Person partner) {
        String dear = customer.getSex().equals("F") ? "Дорогая " : "Дорогой ";
        String msg = dear + customer.getName() +
                "\nПользователь " + partner.getName() + " отменил (завершил) вашу встречу.\n";
        msg = msg + "\n\n" + "С уважением, ваш Кофебот";
        return msg;
    }

    @Scheduled(fixedDelay = 7 * 24 * 60 * 60 * 1000)
    public void resetBisyStatus() {
        List<Person> bisy = getExpiredPersons();
        for (Person bisyPerson : bisy) {
            bisyPerson.setStartDate(null);
            bisyPerson.setStatus(Status.BISY);
        }
    }

    @Scheduled(fixedDelay = 5 * 60 * 1000)
    public void formPairForWaiting() {
        List<Person> waiting = getWaitingPersons();
        for (Person waitingPerson : waiting) {
            activateSearcher(waitingPerson);
        }
    }

    public List<Person> getExpiredPersons() {
        List<Person> expiredPersons = saver.getAll().values().stream()
                .filter(x -> x.getStatus().equals(Status.BISY) && daysBetween(x.getStartDate(), new Date()) > 0)
                .collect(Collectors.toList());
        return expiredPersons;
    }

    public List<Person> getWaitingPersons() {
        List<Person> waitingPersons = saver.getAll().values().stream()
                .filter(x -> x.getStatus().equals(Status.WAITING))
                .collect(Collectors.toList());
        return waitingPersons;
    }

    private int daysBetween(Date d1, Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
}
