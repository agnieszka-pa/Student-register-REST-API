package com.infoshareacademy.register.Entity;

import java.time.LocalDate;
import java.util.Objects;

public class StudentDateOfBirthResponse {
    private final LocalDate dateOfBirth;


    public StudentDateOfBirthResponse(int year, int month, int day) {

        dateOfBirth = LocalDate.of(year, month, day);
    }

    public StudentDateOfBirthResponse(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDateOfBirthResponse that = (StudentDateOfBirthResponse) o;
        return Objects.equals(dateOfBirth, that.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfBirth);
    }

    @Override
    public String toString() {
        return "StudentDateOfBirthResponse{" +
                "dateOfBirth=" + dateOfBirth +
                '}';
    }
}