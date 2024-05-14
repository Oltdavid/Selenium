package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.Assert.assertTrue;

    public class StepDefinitionsDemoPage {
        private DemoPage demoPage;

        public StepDefinitionsDemoPage() {
            demoPage = new DemoPage(Hooks.driver);
        }

    @Given("I have opened the browser and navigated to the StackDemo login page")
    public void i_have_opened_the_browser_and_navigated_to_the_StackDemo_login_page() {
       // demoPage = new DemoPage(Hooks.driver);
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

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        demoPage.openPage();
        demoPage.clickOnSignInButton();
    }

        @When("I login with username {string} and password {string}")
        public void i_login_with_username_and_password(String username, String password) {
            demoPage.selectUsername(username);
            demoPage.selectPassword(password);
            demoPage.clickLoginButton();
        }

        @Then("The {string} should be displayed")
        public void the_expected_username_should_be_displayed(String expectedUsername) {
            String actualUsername = demoPage.getCurrentUsername();
            assertTrue(actualUsername.contains(expectedUsername));
        }

        @When("I click on the OnePlus phone Vendor button")
        public void i_click_on_the_one_plus_phone_vendor_button(){
            demoPage.clickOnePlusPhoneVendor();
        }

        @When("I click on the add to cart button")
        public void i_click_on_the_add_to_cart_button() {
            demoPage.clickAddToCartButtonOnePlus7T();
        }

        @When("I click on the checkout button")
        public void i_click_on_the_checkout_button() {
            demoPage.clickCheckoutButton();
        }


        @Then("The price in the cart should be {string}")
        public void the_price_in_the_cart_should_be(String expectedPrice) {
            String actualPrice = demoPage.getCartPrice();
            assertTrue(actualPrice.contains(expectedPrice));
        }

        @When("I fill out the shipping address with {string} {string} {string} {string} {string}")
        public void i_fill_out_the_shipping_address_with(String firstName, String lastName, String address, String state, String postalCode) {
            demoPage.typeFirstNameShippingAddress(firstName);
            demoPage.typeLastNameShippingAddress(lastName);
            demoPage.typeAddressShippingAddress(address);
            demoPage.typeStateShippingAddress(state);
            demoPage.typePostalCodeShippingAddress(postalCode);
        }


}


