package ru.openbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.openbank.model.Person;
import ru.openbank.service.DataSaver;
import ru.openbank.service.SimpleActivator;
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
    DataSaver saver;

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchPair(@RequestBody Person person){
        try {
            activator.activateSearcher(person);
            return new ResponseEntity(null, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/get-all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchAll(){
        try {
            return new ResponseEntity(activator.all(), HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPersin(@RequestParam String mail){
        try {
            return new ResponseEntity(saver.get(mail), HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/registrate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registrate(@RequestBody Person person){
        try {
            registrator.createPerson(person);
            return new ResponseEntity(null, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/autenticate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity autenticate(@RequestParam String mail, @RequestParam Integer hash){
        try {
            boolean isValid = registrator.authenticate(mail, hash);
            if (isValid)
                return new ResponseEntity(null, HttpStatus.OK);
            else
                return new ResponseEntity(null, HttpStatus.UNAUTHORIZED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
