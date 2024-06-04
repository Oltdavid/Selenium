@UITest
Feature: Test Demo Page

  Scenario: Login with invalid password
    Given I have opened the browser and navigated to the StackDemo login page

    When I click on the username dropdown
    And I press Enter
    And I click on the Login button
    Then I should see the error message "Invalid Password"


  Scenario: Login with valid username and password
    Given I have opened the browser and navigated to the StackDemo login page

    When I click on the username dropdown
    And I press Enter
    And I click on the password dropdown
    And I press Enter
    And I click on the Login button
    Then the Logout button should be displayed


  Scenario Outline: Login with "<user>"
    Given I have opened the browser and navigated to the StackDemo login page
    When I click on the username dropdown
    When I select the username "<user>"
    And I click on the password dropdown
    And I select the valid password
    And I click on the Login button
    Then The "<expected_username>" should be displayed

    Examples:
      | user                              | expected_username             |
      | User1_demouser                    | demouser                     |
      | User2_image_not_loading_user      | image_not_loading_user        |
      | User3_existing_orders_user        | existing_orders_user          |
      | User4_fav_user                    | fav_user                      |


