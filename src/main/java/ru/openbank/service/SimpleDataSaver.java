package ru.openbank.service;

import org.springframework.stereotype.Service;
import ru.openbank.model.Person;
import ru.openbank.service.behavior.Saver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Елена on 09.11.2019.
 */
@Service
public class SimpleDataSaver implements Saver {

    private Map<String, Person> cache = new HashMap<>();

    @Override
    public void create(Person person) {
        cache.put(person.getMail(), person);
    }

    @Override
    public void delete(Person person) {
        cache.remove(person.getMail());
    }

    @Override
    public void update(Person person) {
        cache.put(person.getMail(), person);
    }

    @Override
    public Person get(String mail) {
        return cache.get(mail);
    }

    @Override
    public Map<String, Person> getAll() {
        return cache;
    }

    public void clear() {
        cache.clear();
    }
}
