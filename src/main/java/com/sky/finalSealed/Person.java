package com.sky.finalSealed;

import java.util.Arrays;
import java.util.List;

public class Person {
    private String name;
    private String dob;
    private Person[] kids;
    private final StringBuilder notes;

    public Person() {
        this.notes = new StringBuilder();
    }

    public Person(String name, String dob, StringBuilder notes) {
        this.name = name;
        this.dob = dob;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Person[] getKids() {
        return kids;
    }

    public void setKids(Person[] kids) {
        this.kids = kids;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' ;
    }
}
