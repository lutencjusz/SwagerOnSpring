package io.reflectoring.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

}
