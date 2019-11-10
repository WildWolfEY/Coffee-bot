package ru.openbank.service.behavior;

import ru.openbank.model.Person;

import java.util.Map;

/**
 * Created by Елена on 06.11.2019.
 */
public interface Saver {
    void create(Person person);
    void delete(Person person);
    void update(Person person);
    Person get(String mail);
    Map<String, Person> getAll();
}
