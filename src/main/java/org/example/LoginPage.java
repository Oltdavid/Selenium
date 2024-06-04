package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get("https://www.bstackdemo.com/");
    }

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


    //  WebElements ...

    public void clickPasswordDropdown() {
        passwordDropdown.click();
    }

    public void clickPasswordValid() {
        SelectPassword.click();
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



    public void clickLogoutButton() {
        logoutButton.click();
    }

    public void clickUsernameDropdown() {
        usernameDropdown.click();
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


}