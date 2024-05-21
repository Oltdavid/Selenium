package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='signin']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id='login-btn']")
    private WebElement loginButton;

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


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {
        driver.get("https://www.bstackdemo.com/");
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void enterUsername(String username) {
        usernameDropdown.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordDropdown.sendKeys(password);
    }

    public void login(String username, String password) {
        this.enterUsername(username);
        this.enterPassword(password);
        this.clickLoginButton();
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }



}