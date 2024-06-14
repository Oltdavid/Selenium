package org.example;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import web.app.api.Student;
import web.app.api.StudentService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;


public class StudentStepDefs {
    private StudentService studentService;
    private Response response;

    @Given("^the Student API is set up$")
    public void studentApiSetup() {
        studentService = new StudentService();
    }

    @When("^the user fetches all students$")
    public void userFetchesAllStudents() {
        response = studentService.getStudents();
        assertNotNull(response);

        response.then().log().body();
    }

    @When("^the user fetches a student with id (\\d+)$")
    public void user_fetches_a_student_with_id(int id) {
        response = studentService.getStudentById(id);
        assertNotNull(response);
    }

    @When("^the user creates a student with first name as \"([^\"]*)\", last name as \"([^\"]*)\", email as \"([^\"]*)\"$")
    public void user_creates_a_student_with_first_name_as_last_name_as_email_as(String firstName, String lastName, String email) throws Throwable {
        Student body = new Student(firstName, lastName, email);
        response = studentService.createStudent(body);
        assertNotNull(response);
    }

    @When("^the user updates a student with id (\\d+) and first name as \"([^\"]*)\", last name as \"([^\"]*)\", email as \"([^\"]*)\"$")
    public void user_updates_a_student_with_id_and_first_name_as_last_name_as_email_as(int id, String firstName, String lastName, String email) throws Throwable {
        Student body = new Student(firstName, lastName, email);
        response = studentService.updateStudent(id, body);
        assertNotNull(response);
    }

    @When("^the user deletes a student with id (\\d+)$")
    public void user_deletes_a_student(int id) {
        response = studentService.deleteStudent(id);
        assertNotNull(response);
    }

    @Then("^the status code should be (\\d+)$")
    public void verifyStatusCode(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("^the student data should be valid with first name as \"([^\"]*)\", last name as \"([^\"]*)\", email as \"([^\"]*)\"$")
    public void the_student_data_should_be_valid_with_first_name_as_last_name_as_email_as(String firstName, String lastName, String email) throws Throwable {
        assertEquals(response.jsonPath().getString("firstName"), firstName);
        assertEquals(response.jsonPath().getString("lastName"), lastName);
        assertEquals(response.jsonPath().getString("email"), email);
    }
}