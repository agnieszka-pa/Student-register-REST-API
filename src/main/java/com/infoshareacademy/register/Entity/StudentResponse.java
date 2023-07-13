package com.infoshareacademy.register.Entity;

import java.util.Objects;

public class StudentResponse {

    private final long id;

    private final String name;

    private final String surname;

    private final StudentDateOfBirthResponse studentDateOfBirth;

    private final Course course;


    public StudentResponse(long id, String name, String surname, StudentDateOfBirthResponse studentDateOfBirth, Course course) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.studentDateOfBirth = studentDateOfBirth;
        this.course = course;
    }
    public StudentResponse(long id, String name, String surname, Course course) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.studentDateOfBirth = null;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public StudentDateOfBirthResponse getStudentDateOfBirth() {
        return studentDateOfBirth;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentResponse that = (StudentResponse) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(studentDateOfBirth, that.studentDateOfBirth) && course == that.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, studentDateOfBirth, course);
    }

    @Override
    public String toString() {
        return "StudentResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studentDateOfBirth=" + studentDateOfBirth +
                ", course=" + course +
                '}';
    }
}