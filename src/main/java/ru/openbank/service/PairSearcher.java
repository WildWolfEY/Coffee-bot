package ru.openbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.openbank.model.Person;
import ru.openbank.model.Status;
import ru.openbank.service.behavior.Saver;
import ru.openbank.service.behavior.Searcher;
import ru.openbank.service.behavior.Sender;

import java.util.Optional;

/**
 * Created by ����� on 04.11.2019.
 */
@Component
public class PairSearcher implements Searcher {

    @Autowired
    private Saver saver;

    public Person searchPair(Person customer) {
        Optional<Person> partner = saver.getAll().values().stream()
                .filter(x->x.getStatus().equals(Status.FREE) && x.getArea().equals(customer.getArea()))
                .findAny();
        return partner.orElse(null);
    }


}
