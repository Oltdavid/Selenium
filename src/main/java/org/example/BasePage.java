package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    protected Actions actions;

    // Constructs a new BasePage object
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    // Returns the WebDriver
    public WebDriver getDriver() {
        return driver;
    }

    // Opens the page with the given URL
    public void openPage(String url) {
        driver.get(url);
    }

    // Returns the title of the current page
    public String getTitle() {
        return driver.getTitle();
    }

    // Simulates pressing the Enter key
    public void pressEnter() {
        actions.sendKeys(Keys.RETURN).perform();
    }
}