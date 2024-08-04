package io.reflectoring.demo;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {
    @NonNull
    @Size(min = 2, max = 20)
    private String name;

    @NonNull
    @Size(min = 18, max = 68)
    private int age;

    @NonNull
    @Size(min = 1, max = 1)
    private String grade;

    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
