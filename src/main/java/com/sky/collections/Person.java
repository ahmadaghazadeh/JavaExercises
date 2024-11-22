package com.sky.collections;

import java.util.HashSet;
import java.util.Set;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private Set<Integer> phones=new HashSet<>();

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phones=" + phones +
                '}';
    }

    public Person(String name, int age, Integer phone){
        this.name=name;
        this.age=age;
        this.phones.add(phone);
    }

    public void addPhone(Integer phone) {
        this.phones.add(phone);
    }
    public void addPhones(Set<Integer> phones) {
        this.phones.addAll(phones);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Integer> getPhones() {
        return phones;
    }

    public void setPhones(Set<Integer> phones) {
        this.phones = phones;
    }

    @Override
    public int compareTo(Person o) {
        return o.getName().compareTo(this.name);
    }
}
