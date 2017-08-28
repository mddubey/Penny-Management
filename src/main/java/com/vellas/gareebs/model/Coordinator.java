package com.vellas.gareebs.model;


import com.vellas.gareebs.exceptions.PersonNotFoundException;
import com.vellas.gareebs.service.PeopleManager;
import com.vellas.gareebs.service.Person;

import java.util.ArrayList;
import java.util.List;

public class Coordinator implements PeopleManager {
    List<Person> people = new ArrayList<>();

    @Override
    public void add(Person p) {
        people.add(p);
    }

    @Override
    public void deprecate(Person p) {
        p.deactivate();
    }

    @Override
    public List<Person> getPeople() {
        return people;
    }

    public Person findPerson(String s) {
        for (Person p : people) {
            if (p.is(s)) {
                return p;
            }
        }
        throw new PersonNotFoundException("Wrong Name entered");
    }
}
