package com.infoshareacademy.register.controller;
import com.infoshareacademy.register.entity.Student;
import com.infoshareacademy.register.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/api/v1/students")
    public List<Student> getStudents(@RequestParam(required = false) String name,
                                             @RequestParam(required = false) String surname,
                                             @RequestParam(required = false) String course) {
        return studentService.getStudents().stream()
                .filter(student ->
                        (name == null || student.getName().equalsIgnoreCase(name)) &&
                                (surname == null || student.getSurname().equalsIgnoreCase(surname)) &&
                                (course == null || student.getCourse().equalsIgnoreCase(course))
                )
                .collect(Collectors.toList());
    }

    @GetMapping("/api/v1/students/count")
    public int getStudentsCount(@RequestParam(required = false) String course) {
        List<Student> students = getStudents(null, null, course);
        return students.size();
    }

    @PostMapping("/api/v1/students")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Student> createStudents(@RequestBody List<Student> students) {
        List<Student> responses = new ArrayList<>();

        for (Student student : students) {
            Student added = studentService.addStudent(student);
            responses.add(added);
        }

        return responses;
    }
    @GetMapping("/api/v1/students/{id}")
    public Student getStudent(@PathVariable long id) {
        return studentService.getStudent(id);
    }
    @GetMapping("/api/v1/students/average-age")
    public double getAverageAge() {
        List<Student> students = getStudents(null, null, null);
        LocalDate today = LocalDate.now();

        int totalAge = students.stream()
                .filter(student -> student.getDateOfBirth() != null)
                .mapToInt(student -> {
                    LocalDate dateOfBirth = student.getDateOfBirth();
                    return Period.between(dateOfBirth, today).getYears();
                })
                .sum();

        int studentCount = students.size();
        if (studentCount > 0) {
            return (double) totalAge / studentCount;
        } else {
            return 0.0;
        }
    }
    @PutMapping("/api/v1/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editStudent(@PathVariable long id, @RequestBody Student student) {
        studentService.editStudent(id, student);
    }
    @DeleteMapping("/api/v1/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
    }
}