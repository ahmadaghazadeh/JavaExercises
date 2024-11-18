package com.sky.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda1 {

    record Person(String firstName, String lastName) {}
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Ahmad","Aghazadeh"),
                new Person("Ali","Bagheri"),
                new Person("Arad","Aghazadeh"),
                new Person("Ali","Aghazadeh")

        ));

        persons.sort(Comparator.comparing(p -> p.lastName));

        persons.sort((p1, p2) -> p1.lastName.compareTo(p2.lastName));

        System.out.println(persons);
    }
}

