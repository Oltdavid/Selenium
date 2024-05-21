package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DemoPage {

    private WebDriver driver;
    private Actions actions;

    @FindBy(xpath = "//*[@id='signin']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id='login-btn']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='logout']")
    private WebElement logoutButton;




    @FindBy(xpath = "//*[@id='username']/div/div[1]/div[1]")
    private WebElement usernameDropdown;


    @FindBy(xpath = "//*[@id='password']/div/div[1]/div[1]")
    private WebElement passwordDropdown;


    @FindBy(xpath = "//*[@id=\"react-select-3-option-0-0\"]")
    private WebElement SelectPassword;

    @FindBy(xpath = "//*[@id=\"react-select-3-option-0-0\"]")
    private WebElement PasswordValid;

    @FindBy(xpath = "//*[@id='username']/div/div[1]/div[1]")
    private WebElement demoUser;



    @FindBy(xpath = "//*[@id=\"react-select-2-option-0-0\"]")
    private WebElement User1_demouser;

    @FindBy(xpath = "//*[@id=\"react-select-2-option-0-1\"]")
    private WebElement User2_image_not_loading_user;

    @FindBy(xpath = "//*[@id=\"react-select-2-option-0-2\"]")
    private WebElement User3_existing_orders_user;

    @FindBy(xpath = "//*[@id=\"react-select-2-option-0-3\"]")
    private WebElement User4_fav_user;

    @FindBy(xpath = "//*[@id=\"react-select-2-option-0-4\"]")
    private WebElement User5_locked_user;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[1]/div/div/div[2]/span")
    private WebElement currentUsername;


    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/form/div[2]/h3")
    private WebElement errorMessage;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/main/div[1]/div[4]/label/span")
    private WebElement phoneVendorOnePlus;

    @FindBy(xpath = "//*[@id=\"23\"]/div[4]")
    private WebElement addToCartOnePlus7Button;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div/div[4]/p")
    private WebElement cartPrice;


    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[3]/div[3]")
    private WebElement checkOutButton;

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

    @FindBy(xpath = "//*[@id=\"confirmation-message\"]")
    private WebElement confirmationMessage;

    @FindBy(xpath = "//*[@id='__next']/div/div/div[2]/div[2]/div[3]/div[2]/p")
    private WebElement totalPrice;




    public String getTotalPrice() {
        return totalPrice.getText();
    }


    public DemoPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void openPage() {
        driver.get("https://www.bstackdemo.com/");
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public void clickUsernameDropdown() {
        usernameDropdown.click();
    }

    public void clickAddToCartButtonOnePlus7T() {
        addToCartOnePlus7Button.click();
    }

    public String getCartPrice() {
        return cartPrice.getText();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public void clickOnePlusPhoneVendor() {
        phoneVendorOnePlus.click();
    }


    public void clickPasswordDropdown() {
        passwordDropdown.click();
    }

    public void clickPasswordValid() {
        SelectPassword.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }


    public void clickCheckoutButton() {
        checkOutButton.click();
    }

    public void Select_User1_demouser() {
        User1_demouser.click();
    }

    public void Select_User2_image_not_loading_use() {
        User2_image_not_loading_user.click();
    }

    public void Select_User3_existing_orders_user() {
        User3_existing_orders_user.click();
    }

    public void Select_User4_fav_user() {
        User4_fav_user.click();
    }

    public void Select_User5_existing_orders_user() {
        User5_locked_user.click();
    }


    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void pressEnter() {
        actions.sendKeys(Keys.RETURN).perform();
    }

    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isDisplayed();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUsername() {
        return currentUsername.getText();
    }

    public String getCurrentErrorMessage() {
        return errorMessage.getText();
    }

    public void selectUsername(String username) {
        usernameDropdown.click();
        driver.findElement(By.xpath(String.format("//*[@id=\"react-select-2-option-0-%s\"]", username))).click();
    }

    public void selectPassword(String password) {
        passwordDropdown.click();
        driver.findElement(By.xpath(String.format("//*[@id=\"react-select-3-option-0-%s\"]", password))).click();
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
}


