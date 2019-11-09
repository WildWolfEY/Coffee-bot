package ru.openbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.openbank.model.Option;
import ru.openbank.model.Person;
import ru.openbank.service.behavior.Activator;

/**
 * Created by Елена on 04.11.2019.
 */
public class Main {
    @Autowired
    static SimpleActivator acti;
    static public void main(String[] args)
    {
//        MailSender inv = new MailSender();
//        inv.send("leptidia@gmail.com", );

        Activator activator = new SimpleActivator();
        Person person5 = new Person();


        person5.setName("Лена");
        person5.setArea("Екатеринбург");
        person5.setJob("Программист");
        person5.setMail("lens@mail.ru");
        person5.setSex("F");

        person5.getOptions().add(Option.ABOUTALL);
        person5.getOptions().add(Option.TALKIG);

        activator.activateSearcher(person5);
    }
}
