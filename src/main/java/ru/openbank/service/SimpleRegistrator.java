package ru.openbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.openbank.model.Person;
import ru.openbank.model.Status;
import ru.openbank.service.behavior.Registrator;

/**
 * Created by Елена on 06.11.2019.
 */
@Service
public class SimpleRegistrator implements Registrator {
    @Autowired
    private SimpleDataSaver dataSaver;

    public void createPerson(Person person) {
        person.setStatus(Status.FREE);
        dataSaver.create(person);
    }

    public boolean authenticate(String mail, String hashPwd) {
        Person person = dataSaver.get(mail);
        if (person == null || person.getPassword() == null)
            return false;
        if (hashPwd == null)
            return false;
        return (person.getPassword().equals(hashPwd));
    }
}
