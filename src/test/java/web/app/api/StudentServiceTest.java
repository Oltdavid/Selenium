package web.app.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


//https://elearn.epam.com/courses/course-v1:RD_CEE+ATBiJ+0722/courseware/e7361a6aab9c4bdd8a2d6fc04870337a/e5d9b0da041b47eea8dc5ef87a885d35/?child=first
public class StudentServiceTest {
    StudentService studentService = new StudentService();

    @Test
    public void testGetStudents(){
        studentService.getStudents().then().assertThat().statusCode(200);
        studentService.getStudents().then().log().body();
    }

    @Test
    public void testGetStudentWithId(){
        studentService.getStudentById(1).then().assertThat().
                statusCode(200).
                body("id",equalTo(1)).
                body("firstName", equalTo("James")).
                body("lastName", equalTo("Smith")).
                body("email", equalTo("james_smith@anywhere.school"));
    }

    @Test
    public void testCreateStudent(){
        Student body = new Student("David", "Tester", "tester@mail.com");
        studentService.createStudent(body).then().assertThat().
                statusCode(200).
                body("firstName", equalTo("David")).
                body("lastName", equalTo("Tester")).
                body("email", equalTo("tester@mail.com"));
    }

    @Test
    public void testUpdateStudent(){
        int id = 1;
        Student body = new Student("John", "Doe","hs@mail.com");
        studentService.updateStudent(id, body).then().assertThat().statusCode(200).
                body("firstName", equalTo("John")).
                body("lastName", equalTo("Doe")).
                body("email", equalTo("hs@mail.com"));
    }

    @Test
    public void testDeleteStudent(){
        int id = 2;
        studentService.deleteStudent(id).then().assertThat().statusCode(200);
    }

}