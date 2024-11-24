package com.sky.finalSealed;

public class Student {
    private final String firstName;
    private final StringBuilder notes;

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", notes=" + notes +
                '}';
    }

    public Student(String firstName, StringBuilder notes) {
        this.firstName = firstName;
        this.notes = notes;
    }

    public StringBuilder getNotes() {
        return notes;
    }

    public String getFirstName() {
        return firstName;
    }
}
