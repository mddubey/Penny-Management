package com.vellas.gareebs.model;


import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity
public class Person {
    public Person(String name, String emailId, boolean active) {
        this.name = name;
        this.emailId = emailId;
        this.active = active;
    }

    private String name;
    private String emailId;
    private boolean active = true;
}
