package ru.openbank.garbage;

import lombok.Getter;
import ru.openbank.model.Option;
import ru.openbank.model.Person;
import ru.openbank.model.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ����� on 04.11.2019.
 */

public class PersonDB{
    public List<Person> db = new ArrayList();
    public PersonDB()
    {
        Person person1 = new Person();
        person1.setName("����");
        person1.setArea("������������");
        person1.setJob("�����������");
        person1.setMail("vasya@mail.ru");
        person1.setSex("M");
        person1.setStatus(Status.BISY);
        person1.getOptions().add(Option.ABOUTALL);
        person1.getOptions().add(Option.TALKIG);


        Person person2 = new Person();
        person2.setName("����");
        person2.setArea("������������");
        person2.setJob("�����������");
        person2.setMail("petya@mail.ru");
        person2.setSex("M");
        person2.setStatus(Status.FREE);
        person2.getOptions().add(Option.ABOUTWORK);
        person2.getOptions().add(Option.TALKIG);
        person2.getOptions().add(Option.LISTENING);


        Person person3 = new Person();
        person3.setName("����");
        person3.setArea("������");
        person3.setJob("�����������");
        person3.setMail("manya@mail.ru");
        person3.setSex("F");
        person3.setStatus(Status.FREE);
        person3.getOptions().add(Option.ABOUTALL);
        person3.getOptions().add(Option.ABOUTWORK);
        person3.getOptions().add(Option.LISTENING);


        Person person4 = new Person();
        person4.setName("����");
        person4.setArea("������");
        person4.setJob("������������ ��������");
        person4.setMail("zina@mail.ru");
        person4.setSex("F");
        person4.setStatus(Status.FREE);
        person4.getOptions().add(Option.ABOUTWORK);
        person4.getOptions().add(Option.TALKIG);
        person4.getOptions().add(Option.LISTENING);


        Person person5 = new Person();
        person5.setName("����");
        person5.setArea("������");
        person5.setJob("�����������");
        person5.setMail("dima@mail.ru");
        person5.setSex("�");
        person5.setStatus(Status.BISY);
        person5.getOptions().add(Option.ABOUTALL);
        person5.getOptions().add(Option.TALKIG);


        Person person6 = new Person();
        person6.setName("����");
        person6.setArea("������");
        person6.setJob("�����������");
        person6.setMail("sanya@mail.ru");
        person6.setSex("�");
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
