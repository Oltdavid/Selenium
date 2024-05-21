package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"firstNameInput\"]")
    private WebElement firstNameShippingAddress;

    @FindBy(xpath = "//*[@id=\"lastNameInput\"]")
    private WebElement lastNameShippingAddress;

    @FindBy(xpath = "//*[@id=\"addressLine1Input\"]")
    private WebElement addressShippingAddress;

    @FindBy(xpath = "//*[@id=\"provinceInput\"]")
    private WebElement stateShippingAddress;

    @FindBy(xpath = "//*[@id=\"postCodeInput\"]")
    private WebElement postalCodeShippingAddress;

    @FindBy(xpath = "//*[@id='checkout-app']/div/div/aside/article/section[2]/div/div/span[2]/span")
    private WebElement totalCheckoutPrice;

    @FindBy(xpath = "//*[@id=\"checkout-shipping-continue\"]")
    private WebElement submitButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeFirstNameShippingAddress(String firstName) {
        firstNameShippingAddress.sendKeys(firstName);
    }

    public void typeLastNameShippingAddress(String lastName) {
        lastNameShippingAddress.sendKeys(lastName);
    }

    public void typeAddressShippingAddress(String address) {
        addressShippingAddress.sendKeys(address);
    }

    public void typeStateShippingAddress(String state) {
        stateShippingAddress.sendKeys(state);
    }

    public void typePostalCodeShippingAddress(String postalCode) {
        postalCodeShippingAddress.sendKeys(postalCode);
    }

    public String getTotalCheckoutPrice() {
        return totalCheckoutPrice.getText();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}