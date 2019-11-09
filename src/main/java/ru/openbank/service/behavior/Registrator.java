package ru.openbank.service.behavior;

import ru.openbank.model.Person;

/**
 * Created by Елена on 06.11.2019.
 */
public interface Registrator {
    void createPerson(Person person);
    boolean authenticate(String nail, Integer hashPwd);
}
