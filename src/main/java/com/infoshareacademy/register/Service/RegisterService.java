package com.infoshareacademy.register.Service;
import com.infoshareacademy.register.Entity.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class RegisterService {

    private List<Student> students;

    public RegisterService() {
        this.students = new ArrayList<>(List.of(new Student("Agnieszka", "Kowalska", new StudentDateOfBirth(1997, 8, 16), Course.JJDZR10),
                new Student("Arkadiusz", "Miłowicz", new StudentDateOfBirth(1998, 2, 20), Course.JJDZR09),
                new Student("Krystian", "Rodowicz", new StudentDateOfBirth(1999, 11, 26), Course.JJDZR09),
                new Student("Weronika", "Konkol", new StudentDateOfBirth(1997, 4, 17), Course.JJDZR10),
                new Student("Martyna", "Pawelec", new StudentDateOfBirth(2000, 7, 14), Course.JJDZR11),
                new Student("Nikodem", "Cichy", new StudentDateOfBirth(2001, 9, 9), Course.JJDZR11),
                new Student("Paweł", "Krasiński", new StudentDateOfBirth(1999, 3, 10), Course.JJDZR10),
                new Student("Adrianna", "Wala", new StudentDateOfBirth(2001, 10, 29), Course.JJDZR11),
                new Student("Julia", "Zaręba", new StudentDateOfBirth(2000, 12, 5), Course.JJDZR09)));

    }

    public List<StudentResponse> getStudents() {
        return students.stream()
                .map(this::createStudentResponse)
                .toList();
    }


    public Student getStudent(long id) {
        return getStudentById(id)
                .orElseThrow(() -> new RuntimeException(("Not found student with given ID")));
    }


    public StudentResponse addStudent(StudentRequest studentRequest) {
        Student student = new Student(studentRequest.getName(), studentRequest.getSurname(), studentRequest.getCourse());
        Optional.ofNullable(studentRequest.getStudentDateOfBirth())
                .ifPresent(studentDateOfBirth -> student.setStudentDateOfBirth(new StudentDateOfBirth(studentDateOfBirth.getDateOfBirth())));
        students.add(student);
        return createStudentResponse(student);
    }
    private StudentResponse createStudentResponse (Student student) {
        if (student.getStudentDateOfBirth() == null) {
            return new StudentResponse(student.getId(), student.getName(), student.getSurname(), student.getCourse());
        }
        return new StudentResponse(student.getId(), student.getName(), student.getSurname(), new StudentDateOfBirthResponse(student.getStudentDateOfBirth().getDateOfBirth()), student.getCourse());
    }

    public Optional<Student> getStudentById(long id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();

    }

    public void editStudent(long id, StudentRequest studentRequest){
        findStudentById(id)
                .ifPresent(studentToEdit -> {
                    studentToEdit.setName(studentRequest.getName());
                    studentToEdit.setSurname(studentRequest.getSurname());
                    studentToEdit.setStudentDateOfBirth(studentRequest.getStudentDateOfBirth());
                    studentToEdit.setCourse(studentRequest.getCourse());
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