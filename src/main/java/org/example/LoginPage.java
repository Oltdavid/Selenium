package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    // WebElement representing the sign in button.
    @FindBy(xpath = "//*[@id='signin']")
    private WebElement signInButton;

    // WebElement representing the login button.
    @FindBy(xpath = "//*[@id='login-btn']")
    private WebElement loginButton;

    // WebElement representing the logout button.
    @FindBy(xpath = "//*[@id='logout']")
    private WebElement logoutButton;

    // WebElement representing the username dropdown menu.
    @FindBy(xpath = "//*[@id='username']/div/div[1]/div[1]")
    private WebElement usernameDropdown;

    // WebElement representing the password dropdown menu.
    @FindBy(xpath = "//*[@id='password']/div/div[1]/div[1]")
    private WebElement passwordDropdown;

    // WebElement representing the valid password option.
    @FindBy(xpath = "//*[@id=\"react-select-3-option-0-0\"]")
    private WebElement SelectPassword;

    // WebElement representing the valid password option.
    @FindBy(xpath = "//*[@id=\"react-select-3-option-0-0\"]")
    private WebElement PasswordValid;

    // WebElement representing the demo user option.
    @FindBy(xpath = "//*[@id='username']/div/div[1]/div[1]")
    private WebElement demoUser;

    // WebElement representing the first demo user option.
    @FindBy(xpath = "//*[@id=\"react-select-2-option-0-0\"]")
    private WebElement User1_demouser;

    // WebElement representing the second demo user option.
    @FindBy(xpath = "//*[@id=\"react-select-2-option-0-1\"]")
    private WebElement User2_image_not_loading_user;

    // WebElement representing the third demo user option.
    @FindBy(xpath = "//*[@id=\"react-select-2-option-0-2\"]")
    private WebElement User3_existing_orders_user;

    // WebElement representing the fourth demo user option.
    @FindBy(xpath = "//*[@id=\"react-select-2-option-0-3\"]")
    private WebElement User4_fav_user;

    // WebElement representing the fifth demo user option.
    @FindBy(xpath = "//*[@id=\"react-select-2-option-0-4\"]")
    private WebElement User5_locked_user;

    // WebElement representing the currently logged in username.
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[1]/div/div/div[2]/span")
    private WebElement currentUsername;

    // WebElement representing the error message.
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/form/div[2]/h3")
    private WebElement errorMessage;

    // Constructs a new LoginPage object.
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    // Opens the login page.
    public void openPage() {
        driver.get("https://www.bstackdemo.com/");
    }

    // Clicks on the password dropdown menu.
    public void clickPasswordDropdown() {
        passwordDropdown.click();
    }

    // Clicks on the valid password option.
    public void clickPasswordValid() {
        SelectPassword.click();
    }

    // Opens the login page.
    public void openLoginPage() {
        driver.get("https://www.bstackdemo.com/");
    }

    // Clicks on the sign in button.
    public void clickSignInButton() {
        signInButton.click();
    }

    // Clicks on the login button.
    public void clickLoginButton() {
        loginButton.click();
    }

    // Enters the given username.
    public void enterUsername(String username) {
        usernameDropdown.sendKeys(username);
    }

    // Enters the given password.
    public void enterPassword(String password) {
        passwordDropdown.sendKeys(password);
    }

    // Logs in with the given username and password.
    public void login(String username, String password) {
        this.enterUsername(username);
        this.enterPassword(password);
        this.clickLoginButton();
    }

    // Clicks on the logout button.
    public void clickLogoutButton() {
        logoutButton.click();
    }

    // Clicks on the username dropdown menu.
    public void clickUsernameDropdown() {
        usernameDropdown.click();
    }

    // Selects the first demo user.
    public void Select_User1_demouser() {
        User1_demouser.click();
    }

    // Selects the second demo user.
    public void Select_User2_image_not_loading_use() {
        User2_image_not_loading_user.click();
    }

    // Selects the third demo user.
    public void Select_User3_existing_orders_user() {
        User3_existing_orders_user.click();
    }

    // Selects the fourth demo user.
    public void Select_User4_fav_user() {
        User4_fav_user.click();
    }

    // Selects the fifth demo user.
    public void Select_User5_existing_orders_user() {
        User5_locked_user.click();
    }

    // Returns the error message text.
    public String getErrorMessage() {
        return errorMessage.getText();
    }

    // Checks if the logout button is displayed.
    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isDisplayed();
    }

    // Returns the title of the page.
    public String getTitle() {
        return driver.getTitle();
    }

    // Returns the current username.
    public String getCurrentUsername() {
        return currentUsername.getText();
    }

    // Returns the current error message.
    public String getCurrentErrorMessage() {
        return errorMessage.getText();
    }

    // Selects the given username from the dropdown menu.
    public void selectUsername(String username) {
        usernameDropdown.click();
        driver.findElement(By.xpath(String.format("//*[@id=\"react-select-2-option-0-%s\"]", username))).click();
    }

    // Selects the given password from the dropdown menu.
    public void selectPassword(String password) {
        passwordDropdown.click();
        driver.findElement(By.xpath(String.format("//*[@id=\"react-select-3-option-0-%s\"]", password))).click();
    }

}
