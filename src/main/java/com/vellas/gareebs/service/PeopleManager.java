package com.vellas.gareebs.service;

import com.vellas.gareebs.service.Person;

import java.util.List;

public interface PeopleManager {
    void add(Person p);

    void deprecate(Person p);

    List<Person> getPeople();
}
