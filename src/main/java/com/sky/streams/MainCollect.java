package com.sky.streams;

import com.sky.finalSealed.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class MainCollect {
    public static void main(String[] args) {
        List<Person> people = getPerson(10);

        people.forEach(System.out::println);
    }

    public static List<Person> getPerson(int number){
        return Stream.iterate(0, i-> i<=number, i-> i+1)
                .map((i)-> new Person(getRandomName(),getRandomBirthDate(18, 60),null))
                .toList();
    }

    public static String getRandomName() {
        String[] firstNames = {"John", "Emma", "Oliver", "Sophia", "Liam", "Ava", "Noah", "Isabella", "Ethan", "Mia"};
        String[] lastNames = {"Smith", "Johnson", "Brown", "Williams", "Jones", "Garcia", "Miller", "Davis", "Martinez", "Hernandez"};

        Random random = new Random();

        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];

        return firstName + " " + lastName;
    }

    public static String getRandomBirthDate(int minAge, int maxAge) {
        // Calculate the date range
        LocalDate today = LocalDate.now();
        LocalDate minDate = today.minusYears(maxAge); // Earliest possible birthdate
        LocalDate maxDate = today.minusYears(minAge); // Latest possible birthdate

        // Generate a random date between minDate and maxDate
        long randomEpochDay = ThreadLocalRandom.current().nextLong(minDate.toEpochDay(), maxDate.toEpochDay());
        LocalDate randomDate = LocalDate.ofEpochDay(randomEpochDay);

        // Format the date (optional)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return randomDate.format(formatter);
    }
}
