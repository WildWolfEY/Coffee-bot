package ru.openbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.openbank.model.Person;
import ru.openbank.service.behavior.Registrator;
import ru.openbank.service.behavior.Saver;

/**
 * Created by ����� on 06.11.2019.
 */
@Service
public class SimpleRegistrator implements Registrator {
    @Autowired
    private Saver dataSaver;
    public void createPerson(Person person) {
        dataSaver.create(person);
    }

    public boolean authenticate(String mail, Integer hashPwd) {
        Person person = dataSaver.get(mail);
        if (person == null || person.getPassword()== null)
            return false;
        if (hashPwd == null)
            return false;
        return (person.getPassword().equals(hashPwd));
    }
}
