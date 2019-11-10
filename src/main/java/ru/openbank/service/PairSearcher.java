package ru.openbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.openbank.model.Person;
import ru.openbank.model.Status;
import ru.openbank.service.behavior.Searcher;

import java.util.Optional;

/**
 * Created by Елена on 04.11.2019.
 */
@Component
public class PairSearcher implements Searcher {

    @Autowired
    private SimpleDataSaver saver;

    public Person searchPair(Person customer) {
        Optional<Person> partner = saver.getAll().values().stream()
                .filter(x -> x != null
                        && !x.getMail().equals(customer.getMail())
                        && (x.getStatus().equals(Status.FREE) || (x.getStatus().equals(Status.WAITING)))
                        && x.getArea().equals(customer.getArea()))
                .findAny();

        return partner.orElse(null);
    }


}
