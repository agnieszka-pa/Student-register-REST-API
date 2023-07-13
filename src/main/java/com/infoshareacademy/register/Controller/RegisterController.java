package com.infoshareacademy.register.Controller;
import com.infoshareacademy.register.Entity.Student;
import com.infoshareacademy.register.Entity.StudentRequest;
import com.infoshareacademy.register.Entity.StudentResponse;
import com.infoshareacademy.register.Service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/api/v1/students")
    public List<StudentResponse> getStudents(@RequestParam(required = false) String name,
                                             @RequestParam(required = false) String surname,
                                             @RequestParam(required = false) String course) {
        return registerService.getStudents().stream()
                .filter(student ->
                        (name == null || student.getName().equalsIgnoreCase(name)) &&
                                (surname == null || student.getSurname().equalsIgnoreCase(surname)) &&
                                (course == null || student.getCourse().toString().equalsIgnoreCase(course))
                )
                .collect(Collectors.toList());
    }

    @GetMapping("/api/v1/students/count")
    public int getStudentsCount(@RequestParam(required = false) String course) {
        List<StudentResponse> students = getStudents(null, null, course);
        return students.size();
    }

    @PostMapping("/api/v1/students")
    @ResponseStatus(HttpStatus.CREATED)
    public List<StudentResponse> createStudents(@RequestBody List<StudentRequest> studentRequests) {
        List<StudentResponse> responses = new ArrayList<>();

        for (StudentRequest studentRequest : studentRequests) {
            StudentResponse response = registerService.addStudent(studentRequest);
            responses.add(response);
        }

        return responses;
    }
    @GetMapping("/api/v1/students/{id}")
    public Student getStudent(@PathVariable long id) {
        return registerService.getStudent(id);
    }
    @GetMapping("/api/v1/students/average-age")
    public double getAverageAge() {
        List<StudentResponse> students = getStudents(null, null, null);
        LocalDate today = LocalDate.now();

        int totalAge = students.stream()
                .filter(student -> student.getStudentDateOfBirth() != null)
                .mapToInt(student -> {
                    LocalDate dateOfBirth = student.getStudentDateOfBirth().getDateOfBirth();
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
    public void editStudent(@PathVariable long id, @RequestBody StudentRequest studentRequest) {
        registerService.editStudent(id, studentRequest);
    }
    @DeleteMapping("/api/v1/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable long id) {
        registerService.deleteStudent(id);
    }
}