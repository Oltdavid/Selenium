package org.example;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

// refact=> "//*[@id=\"signin\"]");



public class DemoPage {

    private WebDriver driver;
    private Actions actions;
    public DemoPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void openPage() {
        driver.get("https://www.bstackdemo.com/");
    }

    private By signInButton = By.xpath("//*[@id=\"signin\"]");
    private By loginButton = By.xpath("//*[@id=\"login-btn\"]");
    private By usernameDropdown = By.xpath("//*[@id=\"username\"]/div/div[1]/div[1]");

    private By passwordDropdown = By.xpath("//*[@id=\"password\"]/div/div[1]/div[1]");

    private By demoUser = By.xpath("//*[@id=\"username\"]/div/div[1]/div[1]");
    private By logoutButton = By.xpath("//*[@id=\"logout\"]");


    public void clickOnSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void clickLogInButton() {
        driver.findElement(loginButton).click();
    }

    public void clickUsernameDropdown() {
        driver.findElement(usernameDropdown).click();
    }

    public void clickPasswordDropdown() {
        driver.findElement(passwordDropdown).click();
    }

    public void selectUser() {
        driver.findElement(usernameDropdown).sendKeys("demouser");
    }

    public String getErrorMessage() {
        return driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/form/div[2]/h3")).getText();
    }

    public void pressEnter() {
        actions.sendKeys(Keys.RETURN).perform();
    }

    public boolean isLogoutButtonDisplayed() {
        WebElement logoutButtonElement = driver.findElement(logoutButton);
        return logoutButtonElement.isDisplayed();
    }


    public String getTitle() {
        return driver.getTitle();
    }

}