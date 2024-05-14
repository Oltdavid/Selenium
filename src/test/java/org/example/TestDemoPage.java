package org.example;

import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDemoPage {

    public WebDriver driver;
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
        Assert.assertEquals(errorMessage, "Invalid Password");
    }

    @Test(priority = 4)
    public void testLoginWithInvalidUsername() {
        demoPage.clickPasswordDropdown();
        demoPage.pressEnter();
        demoPage.clickLoginButton();
        String errorMessage = demoPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Invalid Username");
    }
    @Test(priority = 5)
    public void testLoginWithUser1() {
        demoPage.clickUsernameDropdown();
        demoPage.Select_User1_demouser();
        demoPage.clickPasswordDropdown();
        demoPage.clickPasswordValid();
        demoPage.clickLoginButton();
        boolean isLogoutButtonDisplayed = demoPage.isLogoutButtonDisplayed();
        Assert.assertTrue(isLogoutButtonDisplayed, "The logout button is not displayed");
        String expectedUsername = "demouser";
        String actualUsername = demoPage.getCurrentUsername();
        Assert.assertEquals(expectedUsername, actualUsername, "The username is not as expected");

    }
    @Test(priority = 6)
    public void testLoginWithUser2() {
        demoPage.clickUsernameDropdown();
        demoPage.Select_User2_image_not_loading_use();
        demoPage.clickPasswordDropdown();
        demoPage.clickPasswordValid();
        demoPage.clickLoginButton();
        boolean isLogoutButtonDisplayed = demoPage.isLogoutButtonDisplayed();
        Assert.assertTrue(isLogoutButtonDisplayed, "The logout button is not displayed");
        String expectedUsername = "image_not_loading_user";
        String actualUsername = demoPage.getCurrentUsername();
        Assert.assertEquals(expectedUsername, actualUsername, "The username is not as expected");
    }

    @Test(priority = 7)
    public void testLoginWithUser3() {
        demoPage.clickUsernameDropdown();
        demoPage.Select_User3_existing_orders_user();
        demoPage.clickPasswordDropdown();
        demoPage.clickPasswordValid();
        demoPage.clickLoginButton();
        boolean isLogoutButtonDisplayed = demoPage.isLogoutButtonDisplayed();
        Assert.assertTrue(isLogoutButtonDisplayed, "The logout button is not displayed");
        String expectedUsername = "existing_orders_user";
        String actualUsername = demoPage.getCurrentUsername();
        Assert.assertEquals(expectedUsername, actualUsername, "The username is not as expected");

    }

    @Test(priority = 8)
    public void testLoginWithUser4() {
        demoPage.clickUsernameDropdown();
        demoPage.Select_User4_fav_user();
        demoPage.clickPasswordDropdown();
        demoPage.clickPasswordValid();
        demoPage.clickLoginButton();
        boolean isLogoutButtonDisplayed = demoPage.isLogoutButtonDisplayed();
        Assert.assertTrue(isLogoutButtonDisplayed, "The logout button is not displayed");
        String expectedUsername = "fav_user";
        String actualUsername = demoPage.getCurrentUsername();
        Assert.assertEquals(expectedUsername, actualUsername, "The username is not as expected");

    }

    @Test(priority = 9)
    public void testLoginWithUser5() {
        demoPage.clickUsernameDropdown();
        demoPage.Select_User5_existing_orders_user();
        demoPage.clickPasswordDropdown();
        demoPage.clickPasswordValid();
        demoPage.clickLoginButton();
        String expectedErrorMessage = "Your account has been locked.";
        String actualErrorMessage = demoPage.getCurrentErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "The error message is not as expected");

    }


   /*  @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
}
