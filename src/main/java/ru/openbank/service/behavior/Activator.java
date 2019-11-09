package ru.openbank.service.behavior;

import ru.openbank.model.Person;

/**
 * Created by Елена on 06.11.2019.
 */
public interface Activator {
    void activateSearcher(Person person);
    void updatePerson(Person person);
    void notifyPair(Person customer, Person partner);
    void revision();
}

