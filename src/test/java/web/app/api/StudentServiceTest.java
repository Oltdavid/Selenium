package web.app.api;

import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;


public class StudentServiceTest {

    StudentService studentService = new StudentService();

    // Tests getting all students.
    @Test
    public void testGetStudents() {
        studentService.getStudents().then().assertThat().statusCode(200);
        studentService.getStudents().then().log().body();
    }

    // Tests getting a student by ID.
    @Test
    public void testGetStudentWithId() {
        studentService.getStudentById(1).then().assertThat().
                statusCode(200).
                body("id", equalTo(1)).
                body("firstName", equalTo("James")).
                body("lastName", equalTo("Smith")).
                body("email", equalTo("james_smith@anywhere.school"));
    }

    // Tests creating a student.
    @Test
    public void testCreateStudent() {
        Student body = new Student("David", "Tester", "tester@mail.com");
        studentService.createStudent(body).then().assertThat().
                statusCode(200).
                body("firstName", equalTo("David")).
                body("lastName", equalTo("Tester")).
                body("email", equalTo("tester@mail.com"));
    }

    // Tests updating a student.
    @Test
    public void testUpdateStudent() {
        int id = 1;
        Student body = new Student("John", "Doe", "hs@mail.com");
        studentService.updateStudent(id, body).then().assertThat().statusCode(200).
                body("firstName", equalTo("John")).
                body("lastName", equalTo("Doe")).
                body("email", equalTo("hs@mail.com"));
    }

    // Tests deleting a student.
    @Test
    public void testDeleteStudent() {
        int id = 2;
        studentService.deleteStudent(id).then().assertThat().statusCode(200);
    }
}