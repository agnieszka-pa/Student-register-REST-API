package com.infoshareacademy.register.Entity;

import java.util.Objects;
import java.util.Random;

public class Student {

    private long id;

    private String name;

    private String surname;

    private StudentDateOfBirth studentDateOfBirth;

    private Course course;

    public Student() {
        this.id = new Random().nextLong(1000L);
    }


    public Student(String name, String surname, Course course) {
        this.id = new Random().nextLong(1000L);
        this.name = name;
        this.surname = surname;
        this.course = course;
    }
    public Student(String name, String surname, StudentDateOfBirth studentDateOfBirth, Course course) {
        this.id = new Random().nextLong(1000L);
        this.name = name;
        this.surname = surname;
        this.studentDateOfBirth = studentDateOfBirth;
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

    public StudentDateOfBirth getStudentDateOfBirth() {
        return studentDateOfBirth;
    }

    public void setStudentDateOfBirth(StudentDateOfBirth studentDateOfBirth) {
        this.studentDateOfBirth = studentDateOfBirth;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(studentDateOfBirth, student.studentDateOfBirth) && course == student.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, studentDateOfBirth, course);
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
