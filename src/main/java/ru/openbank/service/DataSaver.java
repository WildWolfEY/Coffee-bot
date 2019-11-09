package ru.openbank.service;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.openbank.config.IgniteConfig;
import ru.openbank.garbage.PersonDB;
import ru.openbank.model.Person;
import ru.openbank.service.behavior.Saver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Елена on 06.11.2019.
 */
@Service
public class DataSaver implements Saver {
    @Autowired
    IgniteConfig config;
    @Autowired
    @Qualifier("cacheName")
    String cacheName;

    Ignite ignite;
    IgniteCache<String, Person> cache;


    public void create(Person person) {
        cache.put(person.getMail() ,person);
    }

    public void delete(Person person) {
        cache.clear(person.getMail());
    }

    public void update(Person person) {
        cache.put(person.getMail() ,person);
    }

    public Person get(String mail) {
        Person person= cache.get(mail);
        return person;
    }

    public Map<String, Person> getAll() {
        PersonDB db = new PersonDB();
        Map<String, Person> map = new HashMap<>();    // db.db.stream().collect(Collectors.toMap(Person::getMail, person -> person));
        Iterator iterator = cache.iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Person> entry = (Map.Entry<String, Person>)iterator.next();
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    @PostConstruct
    public void start() throws UnknownHostException {
        startNode();
        createCache();
    }

    public void startNode() throws UnknownHostException {
        ignite = Ignition.getOrStart(config.getConfig());
        ignite.cluster().active(true);
    }
    public void createCache()
    {
        cache = ignite.getOrCreateCache(cacheName);
    }
    @PreDestroy
    public void stopNode()
    {
        Ignition.stop(true);
    }

    public void clear() {
        cache.clear();
    }
}
