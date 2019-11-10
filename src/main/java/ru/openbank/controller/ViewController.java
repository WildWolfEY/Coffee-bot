package ru.openbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.openbank.service.SimpleRegistrator;

/**
 * Created by Елена on 09.11.2019.
 */
@Controller
public class ViewController {
    @Autowired
    SimpleRegistrator registrator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String room() {
        return "coffee-room";
    }

    @RequestMapping(value = "/entrance", method = RequestMethod.GET)
    public String entrance() {
        return "entrance";
    }
}
