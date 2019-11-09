package ru.openbank.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Елена on 04.11.2019.
 */

@Getter
@Setter
public class Person {
    String name;
    String sex;
    String job;
    Set<Option> options = new HashSet<>();
    String area;
    String mail;
    Status status;
    Integer password;
    String phone;
    Date startDate;

}
