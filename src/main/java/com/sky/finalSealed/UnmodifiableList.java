package com.sky.finalSealed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableList {
    public static void main(String[] args) {

        StringBuilder bobsNotes = new StringBuilder();
        StringBuilder billNotes = new StringBuilder("Bill Struggles with generics");

        Student bob=new Student("Bob",bobsNotes);
        Student bill=new Student("Bill",billNotes);

        List<Student> students = new ArrayList<>(List.of(bob,bill));
        List<Student> studentsAssign = new ArrayList<>(students);
        List<Student> studentListCopyOf = List.copyOf(students);
        List<Student> studentunmodifiableList= Collections.unmodifiableList(students);

        studentsAssign.add(new Student("Bonnie",new StringBuilder()));
        bobsNotes.append("Bob was one of my first students");
        students.add(new Student("XXXXXXX",new StringBuilder()));

        //studentListCopyOf.add(new Student("Bonnie",new StringBuilder())); Unsupported Operation
        //studentunmodifiableList.add(new Student("Bonnie",new StringBuilder())); Unsupported Operation


        System.out.println("new ArrayList<>(List.of(bob,bill))"+"-".repeat(50));
        students.forEach(System.out::println);

        System.out.println(" new ArrayList<>(students)"+"-".repeat(50));
        studentsAssign.forEach(System.out::println);


        System.out.println("List.copyOf(students)"+"-".repeat(50));
        studentListCopyOf.forEach(System.out::println);

        System.out.println("Collections.unmodifiableList(students)"+"-".repeat(50));
        studentunmodifiableList.forEach(System.out::println);

    }
}
