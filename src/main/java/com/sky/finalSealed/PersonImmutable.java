package com.sky.finalSealed;

import java.util.Arrays;

public class PersonImmutable {
    private final String name;
    private final String dob;
    private final PersonImmutable[] kids;

    public PersonImmutable(String name, String dob, PersonImmutable[] kids) {
        this.name = name;
        this.dob = dob;
        this.kids= kids==null? null: Arrays.copyOf(kids, kids.length)  ;
    }

    public String getName() {
        return name;
    }


    public String getDob() {
        return dob;
    }


    public PersonImmutable[] getKids(){
            return kids==null? null: Arrays.copyOf(kids, kids.length)  ;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", kids=" + Arrays.toString(kids) +
                '}';
    }
}
