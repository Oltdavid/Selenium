package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;

public class StepDefinitionsDemoPage {

    private DemoPage demoPage;

    @Given("I have opened the browser and navigated to the StackDemo login page")
    public void i_have_opened_the_browser_and_navigated_to_the_StackDemo_login_page() {
        demoPage = new DemoPage(Hooks.driver);
        demoPage.openPage();
        demoPage.clickOnSignInButton();
    }

    @When("I click on the username dropdown")
    public void i_click_on_the_username_dropdown() {
        demoPage.clickUsernameDropdown();
    }

    @When("I press Enter")
    public void i_press_Enter() {
        demoPage.pressEnter();
    }

    @When("I click on the Login button")
    public void i_click_on_the_Login_button() {
        demoPage.clickLoginButton();
    }

    @Then("I should see the error message {string}")
    public void i_should_see_the_error_message(String expectedErrorMessage) {
        String errorMessage = demoPage.getErrorMessage();
        assertTrue(errorMessage.contains(expectedErrorMessage));
    }

    @When("I click on the password dropdown")
    public void i_click_on_the_password_dropdown() {
        demoPage.clickPasswordDropdown();;
    }

    @Then("the Logout button should be displayed")
    public void the_Logout_button_should_be_displayed() {
        assertTrue(demoPage.isLogoutButtonDisplayed());
    }


}