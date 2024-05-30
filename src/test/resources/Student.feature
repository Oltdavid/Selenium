@APITest
Feature: API testing for Student Service

  @GetAll
  Scenario: Get all students
    Given the Student API is set up
    When the user fetches all students
    Then the status code should be 200

  @GetById
  Scenario: Get a student by id
    Given the Student API is set up
    When the user fetches a student with id 1
    Then the status code should be 200
    And the student data should be valid with first name as "James", last name as "Smith", email as "james_smith@anywhere.school"

  @CreateStudent
  Scenario: Create a student
    Given the Student API is set up
    When the user creates a student with first name as "David", last name as "Tester", email as "tester@mail.com"
    Then the status code should be 200

  @UpdateStudent
  Scenario: Update a student
    Given the Student API is set up
    When the user updates a student with id 1 and first name as "John", last name as "Doe", email as "hs1@mail.com"
    Then the status code should be 200
  @DeleteStudent
  Scenario: Delete a student
    Given the Student API is set up
    When the user deletes a student with id 4
    Then the status code should be 200