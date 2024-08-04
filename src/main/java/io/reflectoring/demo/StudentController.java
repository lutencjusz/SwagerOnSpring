package io.reflectoring.demo;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService = new StudentService();

    @Tag(name = "GET", description = "Metoda zwraca wszystkich studentów")
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Set<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @Tag(name = "GET", description = "Metoda zwraca wszystkich studentów")
    @RequestMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    Student getStudent(@PathVariable("name") String name) {
        return studentService.getStudent(name);
    }
}
