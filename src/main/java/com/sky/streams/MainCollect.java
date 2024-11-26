package com.sky.streams;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class MainCollect {
    public static void main(String[] args) {
//        List<Person> people = getPerson(10000000);
//
//       people.stream().
//               collect(Collectors.groupingBy(Person::getName))
//               .entrySet()
//               .stream()
//               .sorted(Comparator.comparing(x-> x.getValue().size()))
//               .forEach((key1) -> System.out.println(key1.getKey() + " " + key1.getValue().size()));


      List<Person> people = getPerson(5000);

       var peopleStream=people.stream().
               collect(groupingBy(Person::getAge));

       peopleStream.forEach((k,v)->System.out.println(k+" "+v));

       System.out.println("-".repeat(50));

        var peopleStreamCount=people.stream().
                collect(groupingBy(Person::getAge,counting()));

        peopleStreamCount.forEach((k,v)->System.out.println(k+" "+v));

        System.out.println("-".repeat(50));

        var peopleStreamFirstName=people.stream().
                collect(groupingBy(s-> s.getName().split(" ")[0],counting()));

        peopleStreamFirstName.forEach((k,v)->System.out.println(k+" "+v));

        System.out.println("-".repeat(50));


        var youngerSet=people.stream().
                collect(groupingBy(Person::getAge,filtering(x-> x.getAge() <=20, toList())));

        youngerSet.forEach((k,v)->System.out.println(k+" "+v));

        System.out.println("-".repeat(50));

        var firstNameEthan=people.stream().
                collect(partitioningBy(s-> s.getName().startsWith("Ethan")));

        System.out.println("Start with Ethan: "+firstNameEthan.get(true).size());
        System.out.println("Other: "+firstNameEthan.get(false).size());
        System.out.println("All: "+(firstNameEthan.get(true).size()+firstNameEthan.get(false).size()));

        System.out.println("-".repeat(50));



        var firstNameEthanCount=people.stream().
                collect(partitioningBy(s-> s.getName().startsWith("Ethan"),counting()));

        System.out.println("Start with Ethan: "+firstNameEthanCount.get(true));
        System.out.println("Other: "+firstNameEthanCount.get(false));
        System.out.println("All: "+(firstNameEthanCount.get(true)+firstNameEthanCount.get(false)));

        System.out.println("-".repeat(50));

        var groupingByFirstNameAndAge= people.
                stream().
                collect(groupingBy(x-> x.getName().split(" ")[0],
                        groupingBy(Person::getAge,counting())));

        groupingByFirstNameAndAge.forEach((k,v)->{
            System.out.println(k);
            v.forEach((k1,v1)->System.out.println("age= "+k1+" count= "+v1));
        });


        System.out.println("-".repeat(50));

        var peopleStreamSum=people.stream().
                collect(groupingBy(Person::getAge))
                .values()
                .stream()
                .map(personList -> personList.stream().filter(f -> f.getName().startsWith("A"))
                        .count())
                .mapToLong(x-> x)
                .sum();

        System.out.println(peopleStreamSum);
        System.out.println("-".repeat(50));


        var peopleStreamSum2=people.stream().
                collect(groupingBy(Person::getAge))
                .entrySet()
                .stream()
                .flatMap(x->x.getValue().stream())
                .filter(x-> x.getName().startsWith("A"))
                .count();

        System.out.println(peopleStreamSum2);
        System.out.println("-".repeat(50));


        System.out.println("-".repeat(50));

        var percentageNameAverageAge= people.
                stream().
                collect(groupingBy(x-> x.getName().split(" ")[0],
                        averagingDouble(Person::getAge)));

        percentageNameAverageAge.forEach((k,v)->{
            System.out.println(k+ " average = "+v );
        });

        System.out.println("-".repeat(50));

        var percentageNameSummarizing= people.
                stream().
                collect(groupingBy(x-> x.getName().split(" ")[0],
                        summarizingDouble(Person::getAge)));

        percentageNameSummarizing.forEach((k,v)->{
            System.out.println(k+ "  "+v );
        });


    }

    public static List<Person> getPerson(int number){
        var random= new Random();
//        return Stream.iterate(0, i-> i<=number, i-> i+1)
//                .map((i)-> new Person(getRandomName(),random.nextInt(1,60)))
//                .toList();

        return IntStream.rangeClosed(1,number)
                .mapToObj((i)-> new Person(getRandomName(),random.nextInt(18,25)))
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

    private record StatisticsPerson(int age, int countOfAge){}


}
