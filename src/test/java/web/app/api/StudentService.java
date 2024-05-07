package web.app.api;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class StudentService {
    private static final String BASE_URL = "http://localhost:8080/students";

    public Response getStudents() {
        return given().when().get(BASE_URL);
    }
    public Response getStudentById(int id) {
        return given().queryParam("id", id).when().get(BASE_URL);
    }

    public Response createStudent(Student body) {
        return given().header("Content-Type", "application/json").body(body).when().post(BASE_URL);
    }

    public Response updateStudent(int id, Student body) {
        return given().header("Content-Type", "application/json").body(body).when().put(BASE_URL + "/{id}", id);
    }

    public Response deleteStudent(int id) {
        return given().when().delete(BASE_URL + "/{id}", id);
    }
}