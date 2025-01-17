package web.app.api;

import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class StudentServiceTest {

    StudentService studentService = new StudentService();

    @Test(description = "Tests getting all students")
    public void testGetStudents() {
        Response response = studentService.getStudents();
        response.then().assertThat().statusCode(200);
        response.then().log().body(); //just in one
    }

    @Test(description = "Tests getting a student by ID")
    public void testGetStudentWithId() {
        studentService.getStudentById(1).then().assertThat()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("firstName", equalTo("James"))
                .body("lastName", equalTo("Smith"))
                .body("email", equalTo("james_smith@anywhere.school"));
    }

    @Test(description = "Tests creating a student")
    public void testCreateStudent() {
        Student body = new Student("David", "Tester", "tester@mail.com");
        studentService.createStudent(body).then().assertThat().
                statusCode(200)
                .body("firstName", equalTo("David"))
                .body("lastName", equalTo("Tester"))
                .body("email", equalTo("tester@mail.com"));
    }

    @Test(description = "Tests updating a student")
    public void testUpdateStudent() {
        int id = 1;
        Student body = new Student("John", "Doe", "hs@mail.com");
        studentService.updateStudent(id, body)
                .then().assertThat().statusCode(200)
                .body("firstName", equalTo("John"))
                .body("lastName", equalTo("Doe"))
                .body("email", equalTo("hs@mail.com"));
    }

    @Test(description = "Tests deleting a student")
    public void testDeleteStudent() {
        int id = 2;
        studentService.deleteStudent(id).then().assertThat().statusCode(200);
    }
}