package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private WebDriver driver;
    // WebElement representing the first name input field in the shipping address form.
    @FindBy(xpath = "//*[@id=\"firstNameInput\"]")
    private WebElement firstNameShippingAddress;

    // WebElement representing the last name input field in the shipping address form.
    @FindBy(xpath = "//*[@id=\"lastNameInput\"]")
    private WebElement lastNameShippingAddress;

    // WebElement representing the address input field in the shipping address form.
    @FindBy(xpath = "//*[@id=\"addressLine1Input\"]")
    private WebElement addressShippingAddress;

    // WebElement representing the state input field in the shipping address form.
    @FindBy(xpath = "//*[@id=\"provinceInput\"]")
    private WebElement stateShippingAddress;

    // WebElement representing the postal code input field in the shipping address form.
    @FindBy(xpath = "//*[@id=\"postCodeInput\"]")
    private WebElement postalCodeShippingAddress;

    // WebElement representing the total checkout price.
    @FindBy(xpath = "//*[@id='checkout-app']/div/div/aside/article/section[2]/div/div/span[2]/span")
    private WebElement totalCheckoutPrice;

    // WebElement representing the submit button.
    @FindBy(xpath = "//*[@id=\"checkout-shipping-continue\"]")
    private WebElement submitButton;

    // WebElement representing the confirmation message.
    @FindBy(xpath = "//*[@id=\"confirmation-message\"]")
    private WebElement confirmationMessage;

    // WebElement representing the total price.
    @FindBy(xpath = "//*[@id='__next']/div/div/div[2]/div[2]/div[3]/div[2]/p")
    private WebElement totalPrice;

    // Constructs a new CheckoutPage object.
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Types the given first name into the shipping address form.
    public void typeFirstNameShippingAddress(String firstName) {
        firstNameShippingAddress.sendKeys(firstName);
    }

    // Types the given last name into the shipping address form.
    public void typeLastNameShippingAddress(String lastName) {
        lastNameShippingAddress.sendKeys(lastName);
    }

    // Types the given address into the shipping address form.
    public void typeAddressShippingAddress(String address) {
        addressShippingAddress.sendKeys(address);
    }

    // Types the given state into the shipping address form.
    public void typeStateShippingAddress(String state) {
        stateShippingAddress.sendKeys(state);
    }

    // Types the given postal code into the shipping address form.
    public void typePostalCodeShippingAddress(String postalCode) {
        postalCodeShippingAddress.sendKeys(postalCode);
    }

    // Returns the total checkout price.
    public String getTotalCheckoutPrice() {
        return totalCheckoutPrice.getText();
    }

    // Clicks on the submit button.
    public void clickSubmitButton() {
        submitButton.click();
    }

    // Returns the confirmation message.
    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    // Returns the total price.
    public String getTotalPrice() {
        return totalPrice.getText();
    }

}