package com.sky.collections;

import java.util.*;

public class OrderedSets  {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<Person>();
        set.add(new Person("Ahmad",42));
        set.add(new Person("Abbas",41));
        set.add(new Person("Ali",52));
        set.add(new Person("Arad",7));

        Comparator<Person> comparator = Comparator.comparing(s-> s.age);
        NavigableSet<Person> sortedSet = new TreeSet<>(comparator);
        sortedSet.addAll(set);
        sortedSet.forEach(System.out::println);
        System.out.println("--------------------");
        System.out.println("First "+sortedSet.first());
        System.out.println("Last "+sortedSet.last());
        System.out.println("lower   "+sortedSet.lower(new Person("Ali",52)));
        System.out.println("floor   "+sortedSet.floor(new Person("Ali",52)));
        System.out.println("ceiling "+sortedSet.ceiling(new Person("Ali",52)));
        System.out.println("higher  "+sortedSet.higher(new Person("Ali",52)));
        System.out.println("--------------------");

        NavigableSet<Person> navigableSet = sortedSet.descendingSet();
        navigableSet.forEach(System.out::println);

        System.out.println("--------------------");
        System.out.println("Removed last item "+sortedSet.pollLast());
        System.out.println("--------------------");
        sortedSet.forEach(System.out::println);

        System.out.println("--------------------");
        System.out.println("Removed first item "+sortedSet.pollFirst());
        System.out.println("--------------------");
        sortedSet.forEach(System.out::println);

        sortedSet.addAll(set);
        System.out.println("--------Head---------");
        var headSet=sortedSet.headSet(new Person("Abbas",41),true);
        headSet.forEach(System.out::println);

        System.out.println("--------Tail--------");
        var tailSet=sortedSet.tailSet(new Person("Abbas",41),false);
        tailSet.forEach(System.out::println);

        System.out.println("--------Tail--------");
        var subSet=sortedSet.subSet(new Person("Arad",7),false,new Person("Abbas",41),false);
        subSet.forEach(System.out::println);


        NavigableSet<Person> sorted1 = new TreeSet<>(set);
        sorted1.forEach(System.out::println);
    }

    record Person(String name, int age) implements Comparable<Person> {
        @Override
        public int compareTo(Person o) {
            return this.age - o.age;
        }
    }
}
