package ru.openbank.service.behavior;

import ru.openbank.model.Person;

import java.io.File;

/**
 * Created by Елена on 04.11.2019.
 */
public interface Sender {
    void send(String recipient, String text);
}
