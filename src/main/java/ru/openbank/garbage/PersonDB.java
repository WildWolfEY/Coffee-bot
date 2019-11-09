package ru.openbank.garbage;

import lombok.Getter;
import ru.openbank.model.Option;
import ru.openbank.model.Person;
import ru.openbank.model.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Елена on 04.11.2019.
 */

public class PersonDB{
    public List<Person> db = new ArrayList();
    public PersonDB()
    {
        Person person1 = new Person();
        person1.setName("Вася");
        person1.setArea("Екатеринбург");
        person1.setJob("Программист");
        person1.setMail("vasya@mail.ru");
        person1.setSex("M");
        person1.setStatus(Status.BISY);
        person1.getOptions().add(Option.ABOUTALL);
        person1.getOptions().add(Option.TALKIG);


        Person person2 = new Person();
        person2.setName("Петя");
        person2.setArea("Екатеринбург");
        person2.setJob("Программист");
        person2.setMail("petya@mail.ru");
        person2.setSex("M");
        person2.setStatus(Status.FREE);
        person2.getOptions().add(Option.ABOUTWORK);
        person2.getOptions().add(Option.TALKIG);
        person2.getOptions().add(Option.LISTENING);


        Person person3 = new Person();
        person3.setName("Маша");
        person3.setArea("Москва");
        person3.setJob("Тестировщик");
        person3.setMail("manya@mail.ru");
        person3.setSex("F");
        person3.setStatus(Status.FREE);
        person3.getOptions().add(Option.ABOUTALL);
        person3.getOptions().add(Option.ABOUTWORK);
        person3.getOptions().add(Option.LISTENING);


        Person person4 = new Person();
        person4.setName("Зина");
        person4.setArea("Москва");
        person4.setJob("Руководитель проектов");
        person4.setMail("zina@mail.ru");
        person4.setSex("F");
        person4.setStatus(Status.FREE);
        person4.getOptions().add(Option.ABOUTWORK);
        person4.getOptions().add(Option.TALKIG);
        person4.getOptions().add(Option.LISTENING);


        Person person5 = new Person();
        person5.setName("Дима");
        person5.setArea("Москва");
        person5.setJob("Программист");
        person5.setMail("dima@mail.ru");
        person5.setSex("М");
        person5.setStatus(Status.BISY);
        person5.getOptions().add(Option.ABOUTALL);
        person5.getOptions().add(Option.TALKIG);


        Person person6 = new Person();
        person6.setName("Саша");
        person6.setArea("Москва");
        person6.setJob("Тестировщик");
        person6.setMail("sanya@mail.ru");
        person6.setSex("М");
        person6.setStatus(Status.FREE);
        person6.getOptions().add(Option.ABOUTALL);
        person6.getOptions().add(Option.TALKIG);
        person6.getOptions().add(Option.LISTENING);


        db.add(person1);
        db.add(person2);
        db.add(person3);
        db.add(person4);
        db.add(person5);
        db.add(person6);
    }
}
