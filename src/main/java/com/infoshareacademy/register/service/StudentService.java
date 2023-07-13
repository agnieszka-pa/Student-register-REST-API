package com.infoshareacademy.register.service;
import com.infoshareacademy.register.entity.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>(List.of(new Student("Agnieszka", "Kowalska", LocalDate.of(1997, 8, 16), "JJDZR10"),
                new Student("Arkadiusz", "Miłowicz", LocalDate.of(1998, 2, 20), "JJDZR09"),
                new Student("Krystian", "Rodowicz", LocalDate.of(1999, 11, 26), "JJDZR09"),
                new Student("Weronika", "Konkol", LocalDate.of(1997, 4, 17), "JJDZR10"),
                new Student("Martyna", "Pawelec", LocalDate.of(2000, 7, 14), "JJDZR11"),
                new Student("Nikodem", "Cichy", LocalDate.of(2001, 9, 9), "JJDZR11"),
                new Student("Paweł", "Krasiński", LocalDate.of(1999, 3, 10), "JJDZR10"),
                new Student("Adrianna", "Wala", LocalDate.of(2001, 10, 29), "JJDZR11"),
                new Student("Julia", "Zaręba", LocalDate.of(2000, 12, 5), "JJDZR09")));

    }

    public List<Student> getStudents() {
        return students;
    }


    public Student getStudent(long id) {
        return getStudentById(id)
                .orElseThrow(() -> new RuntimeException(("Not found student with given ID")));
    }


    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public Optional<Student> getStudentById(long id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();

    }

    public void editStudent(long id, Student student){
        findStudentById(id)
                .ifPresent(studentToEdit -> {
                    studentToEdit.setName(student.getName());
                    studentToEdit.setSurname(student.getSurname());
                    studentToEdit.setDateOfBirth(student.getDateOfBirth());
                    studentToEdit.setCourse(student.getCourse());
                });
    }

    private Optional<Student> findStudentById(long id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    public void deleteStudent(long id) {
        findStudentById(id)
                .ifPresent(student -> students.remove(student));
    }

}