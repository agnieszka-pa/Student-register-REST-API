package com.infoshareacademy.register.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Student {

    private long id;

    private String name;

    private String surname;

    private LocalDate dateOfBirth;

    private String course;

    public Student() {
        this.id = new Random().nextLong(1000L);
    }

    public Student(String name, String surname, LocalDate dateOfBirth, String course) {
        this();
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(dateOfBirth, student.dateOfBirth) && course == student.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, dateOfBirth, course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }
}
