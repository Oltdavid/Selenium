package org.example;

import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDemoPage {

    private WebDriver driver;
    private DemoPage demoPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://dev//files//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        demoPage = new DemoPage(driver);
        demoPage.openPage();
        demoPage.clickOnSignInButton();
    }

    @Test(priority = 1)
    public void testPageTitle() {
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("StackDemo"));
        demoPage.clickUsernameDropdown();
        demoPage.pressEnter();
    }

    @Test(priority = 2)
    public void testLoginWithoutUsernameAndPassword() {
        demoPage.clickLoginButton();
        String errorMessage = demoPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Invalid Username");
    }

    @Test(priority = 3)
    public void testLoginWithInvalidPassword() {
        demoPage.clickUsernameDropdown();
        demoPage.pressEnter();
        demoPage.clickLoginButton();
        String errorMessage = demoPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Invalid Passworda");
    }

    @Test(priority = 4)
    public void testLoginWithInvalidUsername() {
        demoPage.clickPasswordDropdown();
        demoPage.pressEnter();
        demoPage.clickLoginButton();
        String errorMessage = demoPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Invalid Username");
    }
//sel
    @Test(priority = 5)
    public void testLoginWithValidUsernamePassword() {
        demoPage.clickUsernameDropdown();
        demoPage.pressEnter();
        demoPage.clickPasswordDropdown();
        demoPage.pressEnter();
        demoPage.clickLoginButton();
        boolean isLogoutButtonDisplayed = demoPage.isLogoutButtonDisplayed();
        Assert.assertTrue(isLogoutButtonDisplayed, "The logout button is not displayed");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}