package com.sky.collections;

import java.util.*;

public class Maps {

    public static void main(String[] args) {

        var p1=new Person("Ahmad",42,914);
        var p2=new Person("Arad",7,914);
        var p3=new Person("Abbas",40,914);
        var p4=new Person("Bahram",25,914);
        var p5=new Person("Amir",39,914);
        var p11=new Person("Ahmad",44,914);

        Map<String, Person> map=new HashMap<>();
        System.out.println(map.put(p1.getName(),p1));
        System.out.println(map.put(p2.getName(),p2));
        System.out.println(map.put(p3.getName(),p3));
        System.out.println(map.put(p4.getName(),p4));
        System.out.println(map.put(p5.getName(),p5));
        System.out.println(map.put(p11.getName(),p11));
        System.out.println(map);

        System.out.println("-".repeat(90));
        System.out.println(map.get(p1.getName()));

        System.out.println("-".repeat(90));
        System.out.println(map.get("Reza"));
        System.out.println(map.getOrDefault("Reza",p1));

        var newList=new ArrayList<Person>();
        var newP1=new Person("Ahmad",42,914);
        newP1.addPhone(5);
        newP1.addPhone(55);
        newP1.addPhone(565);
        newList.add(newP1);

        for (Person person : newList) {
            Person duplicated=map.get(person.getName());
            if(duplicated!=null){
                duplicated.addPhones(person.getPhones());
                map.put(duplicated.getName(),duplicated);
            }
        }
        System.out.println("-".repeat(90));
        System.out.println(map);



        System.out.println("-".repeat(90));
        System.out.println("-".repeat(90));
        var np1=new Person("Ahmad",42,914);
        var np2=new Person("Arad",7,914);
        var np3=new Person("Abbas",40,914);
        var np4=new Person("Bahram",25,914);
        var np5=new Person("Amir",39,914);
        var np11=new Person("Ahmad",44,914);

        Map<String, Person> nmap=new HashMap<>();
        nmap.putIfAbsent(np1.getName(),np1);
        nmap.putIfAbsent(np2.getName(),np2);
        nmap.putIfAbsent(np3.getName(),np3);
        nmap.putIfAbsent(np4.getName(),np4);
        nmap.putIfAbsent(np5.getName(),np5);
        nmap.putIfAbsent(np11.getName(),np11);
        nmap.forEach((k,v)-> System.out.println("Key: "+k+" Value: "+v));

        for (String name : new String[]{"Ahmad 1","Ali2","Farhad"}) {
            nmap.compute(name,(k,v)-> new Person(name,0,0));
        }
        nmap.forEach((k,v)-> System.out.println("Key: "+k+" Value: "+v));


        System.out.println("-".repeat(90));
        nmap.clear();
        nmap.putIfAbsent(np1.getName(),np1);
        for (String name : new String[]{"Ahmad","Ali2","Farhad"}) {
            nmap.computeIfAbsent(name,(k)-> new Person(name,0,0));
        }
        nmap.forEach((k,v)-> System.out.println("Key: "+k+" Value: "+v));


        System.out.println("-".repeat(90));
        nmap.clear();
        nmap.putIfAbsent(np1.getName(),np1);
        for (String name : new String[]{"Ahmad","Ali2","Farhad"}) {
            nmap.computeIfPresent(name,(k,v)-> new Person(name,1,12));
        }
        nmap.forEach((k,v)-> System.out.println("Key: "+k+" Value: "+v));
    }
}
