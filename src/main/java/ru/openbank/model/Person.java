package ru.openbank.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Елена on 04.11.2019.
 */

@Getter
@Setter
@JsonAutoDetect
public class Person {
    String name;
    String sex;
    String job;
    Set<Option> options = new HashSet<>();
    String area;
    String mail;
    Status status;
    String password;
    Date startDate;
    Person partner;

    boolean admin;

    private String token;

    public Person() {
        setToken();
    }

    public void setToken() {
        token = UUID.randomUUID().toString();
    }

    public void deleteToken() {
        token = "";
    }
}
