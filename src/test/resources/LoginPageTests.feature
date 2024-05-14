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
    When I login with username "<user>" and password "<password>"
    Then The "<expected_username>" should be displayed

    Examples:
      | user                        | password       | expected_username             |
      | "User1_demouser"            | "testingisfun99" | "demouser"                   |
      | "User2_image_not_loading_user" | "testingisfun99" | "image_not_loading_user"     |
      | "User3_existing_orders_user"   | "testingisfun99" | "existing_orders_user"       |
      | "User4_fav_user"               | "testingisfun99" | "fav_user"                   |
      | "User5_existing_orders_user"   | "testingisfun99" | "Your account has been locked." |

