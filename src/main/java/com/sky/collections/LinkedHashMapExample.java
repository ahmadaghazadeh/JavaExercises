package com.sky.collections;

import java.util.*;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        var p1=new Person("Ahmad",42,914);
        var p2=new Person("Arad",7,914);
        var p3=new Person("Abbas",42,914);
        var p4=new Person("Bahram",7,914);
        var p5=new Person("Amir",39,914);
        var p6=new Person("Ahmad1",44,914);
        var p7=new Person("Ahmad2",7,914);
        var p8=new Person("Ahmad3",39,914);
        var p9=new Person("Ahmad4",40,914);
        var p10=new Person("Ahmad5",44,914);

        var persons=List.of(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10);

        var personsLinked=new LinkedHashMap<String,Person>();
        persons.forEach(p-> personsLinked.compute(p.getName(),(s, person) -> p));
        personsLinked.forEach((s, person) -> System.out.println(s + " " + person));

        System.out.println("-".repeat(100));

        var treeMap=new TreeMap<String,Person>();
        persons.forEach(p-> treeMap.compute(p.getName(),(s, person) -> p));
        treeMap.forEach((s, person) -> System.out.println(s + " " + person));

        NavigableMap<Integer,List<Person>> agedPersons=new TreeMap<>();
        for (Person person : persons) {
            agedPersons.compute(person.getAge(),((integer, listPerson) -> {
                List<Person> list = (listPerson == null) ? new ArrayList<>() : listPerson;
                list.add(person);
                return list;
            }));
        }

        System.out.println("-".repeat(100));
        agedPersons.forEach((key, value) -> System.out.println(key + " " + value));

        System.out.println("-".repeat(100));
        var yangAged=agedPersons.headMap(40);
        yangAged.forEach((key, value) -> System.out.println(key + " " + value));

        System.out.println("-".repeat(100));
        var middleAged=agedPersons.tailMap(40);
        middleAged.forEach((key, value) -> System.out.println(key + " " + value));

        Map<String,Integer> ageCounts=new TreeMap<>();
        agedPersons.forEach((key, value) -> {
            for (Person person : value) {
                ageCounts.merge(""+person.getAge(),1,(prev,current)-> {
                    return prev + current;
                });
            }
        });
        System.out.println("-".repeat(100));
        System.out.println("AgeCounts: "+ ageCounts);

        System.out.println("-".repeat(100));
        var lastAged=agedPersons.lastEntry();
        System.out.println( "age : "+lastAged.getKey() +" Max size:  "+ lastAged.getValue().size());

        System.out.println("-".repeat(100));
        int size=agedPersons.size();
        for (int i = 0; i < size; i++) {
            System.out.println(agedPersons.pollFirstEntry() +" current size: "+agedPersons.size());
        }
        System.out.println("=".repeat(100));
        System.out.println(agedPersons);
    }
}

