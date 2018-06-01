package com.spring.restws.model.v2;

public class Person {
    private Name name;

    public Person() {
    }

    public Person(Name name) {
        super();
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
