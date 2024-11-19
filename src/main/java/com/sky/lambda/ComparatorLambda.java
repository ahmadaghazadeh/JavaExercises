package com.sky.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {
    public static void main(String[] args) {

        record Person(String firstName, String lastName){};

        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Peter","Pan"),
                new Person("Peter","Pumpkin"),
                new Person("Minnie","Mouse"),
                new Person("Mickey","Mouse")
        ));

        persons.sort((o1, o2) -> o1.firstName.compareTo(o2.firstName));
        persons.sort(Comparator.comparing(s-> s.lastName));
        persons.sort(Comparator.comparing(Person::lastName));
        persons.forEach(System.out::println);

        persons.sort(Comparator.comparing(Person::lastName).thenComparing(Person::firstName));
        persons.forEach(System.out::println);

        persons.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName)
                .reversed());
        persons.forEach(System.out::println);

    }
}
