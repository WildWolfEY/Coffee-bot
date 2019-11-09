package ru.openbank.service.behavior;

import ru.openbank.model.Person;

/**
 * Created by Елена on 04.11.2019.
 */
public interface Searcher {
    Person searchPair(Person customer);
}
