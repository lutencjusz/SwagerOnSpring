package io.reflectoring.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService = new StudentService();


    @Operation(summary = "Metoda zwraca wszystkich studentów", description = "Metoda zwraca wszystkich studentów znajdujących się w bazie danych")
    @Tag(name = "get", description = "Metoda zwraca studenta/studentów")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Set<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @Operation(summary = "Metoda zwraca wybranego studenta", description = "Metoda zwraca zidentyfikowanego po imieniu studenta")
    @Tag(name = "get", description = "Metoda zwraca studenta/studentów")
    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    Student getStudent(
            @Parameter(description = "Podaj imię studenta", required = true, example = "Alice")
            @PathVariable String name) {
        return studentService.getStudent(name);
    }
}
