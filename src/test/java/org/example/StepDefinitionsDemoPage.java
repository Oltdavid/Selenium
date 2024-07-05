package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;


import static org.testng.Assert.assertTrue;

public class StepDefinitionsDemoPage {

    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    public StepDefinitionsDemoPage() {
        loginPage = new LoginPage(Hooks.getDriver());
        productPage = new ProductPage(Hooks.getDriver());
        cartPage = new CartPage(Hooks.getDriver());
        checkoutPage = new CheckoutPage(Hooks.getDriver());
    }

    @Step("Open the browser and navigate to the StackDemo login page")
    @Given("I have opened the browser and navigated to the StackDemo login page")
    public void i_have_opened_the_browser_and_navigated_to_the_StackDemo_login_page() {
        loginPage.openLoginPage();
        loginPage.clickSignInButton();
    }

    @Step("Click on the username dropdown")
    @When("I click on the username dropdown")
    public void i_click_on_the_username_dropdown() {
        loginPage.clickUsernameDropdown();
    }

    @Step("Press Enter")
    @When("I press Enter")
    public void i_press_Enter() {
        loginPage.pressEnter();
    }

    @Step("Click on the Login button")
    @When("I click on the Login button")
    public void i_click_on_the_Login_button() {
        loginPage.clickLoginButton();
    }

    @Step("Check if the error message is {expectedErrorMessage}")
    @Then("I should see the error message {string}")
    public void i_should_see_the_error_message(String expectedErrorMessage) {
        String errorMessage = loginPage.getErrorMessage();
        assertTrue(errorMessage.contains(expectedErrorMessage));
    }

    @Step("Click on the password dropdown")
    @When("I click on the password dropdown")
    public void i_click_on_the_password_dropdown() {
        loginPage.clickPasswordDropdown();
    }

    @Step("Check if the Logout button is displayed")
    @Then("the Logout button should be displayed")
    public void the_Logout_button_should_be_displayed() {
        assertTrue(loginPage.isLogoutButtonDisplayed());
    }

    @Step("Open the login page")
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage.openLoginPage();
        loginPage.clickSignInButton();
    }

    @Step("Login with username {username} and password {password}")
    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        loginPage.selectUsername(username);
        loginPage.selectPassword(password);
        loginPage.clickLoginButton();
    }

    @Step("Check if the expected username {expectedUsername} is displayed")
    @Then("The {string} should be displayed")
    public void the_expected_username_should_be_displayed(String expectedUsername) {
        String actualUsername = loginPage.getCurrentUsername();
        assertTrue(actualUsername.contains(expectedUsername));
    }

    @Step("Click on the OnePlus phone Vendor button")
    @When("I click on the OnePlus phone Vendor button")
    public void i_click_on_the_one_plus_phone_vendor_button() {
        productPage.clickOnePlusPhoneVendor();
    }

    @Step("Click on the add to cart button")
    @When("I click on the add to cart button")
    public void i_click_on_the_add_to_cart_button() {
        productPage.clickAddToCartButtonOnePlus7T();
    }

    @Step("Click on the add to cart button")
    @When("I click on the the iPhone12 to add to cart button")
    public void i_click_on_the_iphone12_to_add_to_cart_button() {
        productPage.clickAddToCartButton_the_iPhone12();
    }

    @Step("Click on the checkout button")
    @When("I click on the checkout button")
    public void i_click_on_the_checkout_button() {
        cartPage.clickCheckoutButton();
    }

    @Step("Check if the price in the cart is {expectedPrice}")
    @Then("The price in the cart should be {string}")
    public void the_price_in_the_cart_should_be(String expectedPrice) {
        String actualPrice = cartPage.getCartPrice();
        assertTrue(actualPrice.contains(expectedPrice));
    }

    @Step("Fill out the shipping address with {firstName} {lastName} {address} {state} {postalCode}")
    @When("I fill out the shipping address with {string} {string} {string} {string} {string}")
    public void i_fill_out_the_shipping_address_with(String firstName, String lastName, String address, String state, String postalCode) {
        checkoutPage.typeFirstNameShippingAddress(firstName);
        checkoutPage.typeLastNameShippingAddress(lastName);
        checkoutPage.typeAddressShippingAddress(address);
        checkoutPage.typeStateShippingAddress(state);
        checkoutPage.typePostalCodeShippingAddress(postalCode);
    }

    @Step("Check if the total checkout price is {expectedPrice}")
    @Then("The total checkout price should be {string}")
    public void the_total_checkout_price_should_be(String expectedPrice) {
        String actualPrice = checkoutPage.getTotalCheckoutPrice();
        assertTrue(actualPrice.contains(expectedPrice));
    }

    @Step("Click on the submit button")
    @Then("I click on the submit button")
    public void i_click_on_the_submit_button() {
        checkoutPage.clickSubmitButton();
    }

    @Step("Check if the confirmation message is {expectedMessage}")
    @Then("The confirmation message should be {string}")
    public void the_total_confirmation_message_should_be(String expectedMessage) {
        String actualMessage = checkoutPage.getConfirmationMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Step("Check if the total price is {expectedPrice}")
    @Then("The total price should be {string}")
    public void the_total_price_should_be(String expectedPrice) {
        String actualPrice = checkoutPage.getTotalPrice();
        assertTrue(actualPrice.contains(expectedPrice));
    }

    @Step("Select the username {user}")
    @When("I select the username {string}")
    public void i_select_the_username(String user) {
        switch(user) {
            case "User1_demouser":
                loginPage.Select_User1_demouser();
                break;
            case "User2_image_not_loading_user":
                loginPage.Select_User2_image_not_loading_use();
                break;
            case "User3_existing_orders_user":
                loginPage.Select_User3_existing_orders_user();
                break;
            case "User4_fav_user":
                loginPage.Select_User4_fav_user();
                break;
            case "User5_existing_orders_user":
                loginPage.Select_User5_existing_orders_user();
                break;
            default:
                throw new IllegalArgumentException("Invalid user: " + user);
        }
    }

    @Step("Select the valid password")
    @When("I select the valid password")
    public void i_select_the_valid_password() {
        loginPage.clickPasswordValid();
    }

    @Step("Click on the Apple phone Vendor button")
    @When("I click on the Apple phone Vendor button")
    public void i_click_on_the_apple_phone_vendor_button() {
        productPage.clickAppleVendor();
    }

}