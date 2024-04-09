package org.example;

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

    @FindBy(xpath = "//*[@id='username']/div/div[1]/div[1]")
    private WebElement usernameDropdown;

    @FindBy(xpath = "//*[@id='password']/div/div[1]/div[1]")
    private WebElement passwordDropdown;

    @FindBy(xpath = "//*[@id='username']/div/div[1]/div[1]")
    private WebElement demoUser;

    @FindBy(xpath = "//*[@id='logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id='__next']/div[2]/div/form/div[2]/h3")
    private WebElement errorMessage;

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

    public void clickUsernameDropdown() {
        usernameDropdown.click();
    }

    public void clickPasswordDropdown() {
        passwordDropdown.click();
    }

    public void selectUser() {
        usernameDropdown.sendKeys("demouser");
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

}