package io.reflectoring.demo;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest
class SwaggerTestApplicationTests {

    @Test
    void testGetAllStudents() {
        given()
                .when()
                .get("/students")
                .then()
                .statusCode(200)
                .body("size()", greaterThanOrEqualTo(3))
                .body("name", hasItem("Alice"));
    }

    @Test
    void testGetStudent() {
        given()
                .when()
                .get("/students/Alice")
                .then()
                .statusCode(200)
                .body("name", is("Alice"))
                .body("age", is(20));
    }

    @Test
    void testAddStudent() {
        String name = RandomStringUtils.randomAlphabetic(5);
        int age = new Random().nextInt(50) + 18;
        String grade = "D";
        given()
                .contentType("application/json")
                .body("{\"name\": \"" + name + "\", \"age\": " + age + ", \"grade\": \"D\"}")
                .when()
                .post("/students")
                .then()
                .statusCode(200)
                .body("name", is(name))
                .body("age", is(age));
    }

}
