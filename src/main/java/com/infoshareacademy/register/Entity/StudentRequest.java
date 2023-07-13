package com.infoshareacademy.register.Entity;


import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class StudentRequest {

    private String name;

    private String surname;

    private StudentDateOfBirth studentDateOfBirth;

    private Course course;

    public StudentRequest(String name, String surname, StudentDateOfBirth studentDateOfBirth, Course course) {
        this.name = name;
        this.surname = surname;
        this.studentDateOfBirth = studentDateOfBirth;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public StudentDateOfBirth getStudentDateOfBirth() {
        return studentDateOfBirth;
    }

    public Course getCourse() {
        return course;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentRequest that = (StudentRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(studentDateOfBirth, that.studentDateOfBirth) && course == that.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, studentDateOfBirth, course);
    }

    @Override
    public String toString() {
        return "StudentRequest{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studentDateOfBirth=" + studentDateOfBirth +
                ", course=" + course +
                '}';
    }
}