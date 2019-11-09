package ru.openbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Елена on 09.11.2019.
 */
@Controller
public class ViewController {
    @RequestMapping(value = "/entrance", method = RequestMethod.GET)
    public String entrance(){
        return "entrance";
    }
    @RequestMapping(value = "/room", method = RequestMethod.GET)
    public String room(){
        return "coffee-room";
    }
}
