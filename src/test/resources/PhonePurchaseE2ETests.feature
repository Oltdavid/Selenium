Feature: Phone Purchase E2E Tests

  Scenario: Login with valid username and password
    Given I have opened the browser and navigated to the StackDemo login page

    When I click on the username dropdown
    And I press Enter
    And I click on the password dropdown
    And I press Enter
    And I click on the Login button
    And I click on the OnePlus phone Vendor button
    And I click on the add to cart button
    And I click on the checkout button
    And I fill out the shipping address with "John" "Doe" "123 Main St" "California" "12345"


