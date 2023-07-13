package com.infoshareacademy.register.Entity;
import java.time.LocalDate;

public class StudentDateOfBirth {
    private LocalDate dateOfBirth;


    public StudentDateOfBirth(int year, int month, int day) {

        dateOfBirth = LocalDate.of(year, month, day);
    }

    public StudentDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
