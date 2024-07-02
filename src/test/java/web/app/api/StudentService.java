package web.app.api;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import io.qameta.allure.restassured.AllureRestAssured;

public class StudentService {
    private static final String BASE_URL = "http://localhost:8080/students";

    public Response getStudents() {
        return given().filter(new AllureRestAssured()).when().get(BASE_URL);
    }
    public Response getStudentById(int id) {
        return given().filter(new AllureRestAssured()).queryParam("id", id).when().get(BASE_URL);
    }

    public Response createStudent(Student body) {
        return given().filter(new AllureRestAssured()).header("Content-Type", "application/json").body(body).when().post(BASE_URL);
    }

    public Response updateStudent(int id, Student body) {
        return given().filter(new AllureRestAssured()).header("Content-Type", "application/json").body(body).when().put(BASE_URL + "/{id}", id);
    }

    public Response deleteStudent(int id) {
        return given().filter(new AllureRestAssured()).when().delete(BASE_URL + "/{id}", id);
    }
}

