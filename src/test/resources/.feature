Feature: Test Demo Page

  Scenario: Login with invalid password
    Given I have opened the browser and navigated to the StackDemo login page

    When I click on the username dropdown
    And I press Enter
    And I click on the Login button
    Then I should see the error message "Invalid Password"

