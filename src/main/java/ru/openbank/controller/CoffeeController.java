package ru.openbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.openbank.model.Person;
import ru.openbank.model.Status;
import ru.openbank.service.SimpleActivator;
import ru.openbank.service.SimpleDataSaver;
import ru.openbank.service.SimpleRegistrator;

/**
 * Created by Елена on 07.11.2019.
 */

@RestController
public class CoffeeController {
    @Autowired
    SimpleActivator activator;
    @Autowired
    SimpleRegistrator registrator;
    //FIXME Для тестирование
    @Autowired
    SimpleDataSaver saver;

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchPair(@RequestBody Person person) {
        if (isAutorized(person.getMail(), person.getToken())) {
            try {
                Person partner = activator.activateSearcher(person);
                if (partner != null) {
                    Person returnPerson = new Person();
                    returnPerson.setName(partner.getName());
                    return new ResponseEntity(returnPerson, HttpStatus.OK);
                } else {
                    Person pers = saver.get(person.getMail());
                    pers.setStatus(Status.WAITING);
                    saver.update(pers);
                    return new ResponseEntity(null, HttpStatus.OK);
                }
            } catch (Exception err) {
                return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else
            return new ResponseEntity(null, HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/registrate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registrate(@RequestBody Person person) {
        try {
            person.setPassword(String.valueOf(person.getPassword().hashCode()));
            registrator.createPerson(person);
            return new ResponseEntity(null, HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/autenticate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> autenticate(@RequestBody Person person) {
        try {
            boolean isValid = registrator.authenticate(person.getMail(), String.valueOf(person.getPassword().hashCode()));
            if (isValid) {
                person = saver.get(person.getMail());
                Person returnPerson = new Person();
                returnPerson.setToken(String.valueOf(person.getToken().hashCode()));
                returnPerson.setMail(person.getMail());
                return new ResponseEntity(returnPerson, HttpStatus.OK);
            } else
                return new ResponseEntity(null, HttpStatus.UNAUTHORIZED);
        } catch (Exception err) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/get-status", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> status(@RequestBody Person person) {
        try {
            person = saver.get(person.getMail());
            if (person != null)
                return new ResponseEntity(person.getStatus(), HttpStatus.OK);
            else
                return new ResponseEntity(null, HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean isAutorized(String mail, String token) {
        return token.equals(String.valueOf(saver.get(mail).getToken().hashCode()));
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cancelMeeting(@RequestBody Person person) {
        try {
            person = saver.get(person.getMail());
            activator.cancelMeeting(person);
            return new ResponseEntity(null, HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/exit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> exit(@RequestBody Person person) {
        try {
            ResponseEntity<?> cancelEntity = cancelMeeting(person);
            if (cancelEntity.getStatusCode().equals(HttpStatus.OK)) {

                person = saver.get(person.getMail());
                person.setStatus(Status.DISABLED);
                activator.updatePerson(person);
                return new ResponseEntity(null, HttpStatus.OK);
            } else
                return cancelEntity;

        } catch (Exception err) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/back", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> entrance(@RequestBody Person person) {
        try {
            person = saver.get(person.getMail());
            person.setStatus(Status.FREE);
            activator.updatePerson(person);
            return new ResponseEntity(null, HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/log-out", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> logOut(@RequestBody Person person) {
        try {
            saver.get(person.getMail()).deleteToken();
            return new ResponseEntity(null, HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
