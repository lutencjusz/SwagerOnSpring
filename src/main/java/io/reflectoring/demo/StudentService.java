package io.reflectoring.demo;


import java.util.HashSet;
import java.util.Set;

public class StudentService {

    Set<Student> students = new HashSet<>(){{
        add(new Student("Alice", 20, "A"));
        add(new Student("Bob", 21, "B"));
        add(new Student("Charlie", 22, "C"));
    }};

    public StudentService() {}

    public Set<Student> getAllStudents() {
        return students;
    }
    public Student getStudent(String name) {
        return students.stream()
                .filter(student -> student.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
