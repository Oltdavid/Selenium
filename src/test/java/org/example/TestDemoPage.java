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

    public WebDriver driver;
    private LoginPage loginPage;



    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://dev//files//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.clickSignInButton();
    }


    @Test(priority = 1)
    public void testPageTitle() {
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("StackDemo"));
        loginPage.clickUsernameDropdown();
        loginPage.pressEnter();
    }

    @Test(priority = 2)
    public void testLoginWithoutUsernameAndPassword() {
        loginPage.clickLoginButton();
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Invalid Username");
    }

    @Test(priority = 3)
    public void testLoginWithInvalidPassword() {
        loginPage.clickUsernameDropdown();
        loginPage.pressEnter();
        loginPage.clickLoginButton();
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Invalid Password");
    }

    @Test(priority = 4)
    public void testLoginWithInvalidUsername() {
        loginPage.clickPasswordDropdown();
        loginPage.pressEnter();
        loginPage.clickLoginButton();
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Invalid Username");
    }
    @Test(priority = 5)
    public void testLoginWithUser1() {
        loginPage.clickUsernameDropdown();
        loginPage.Select_User1_demouser();
        loginPage.clickPasswordDropdown();
        loginPage.clickPasswordValid();
        loginPage.clickLoginButton();
        boolean isLogoutButtonDisplayed = loginPage.isLogoutButtonDisplayed();
        Assert.assertTrue(isLogoutButtonDisplayed, "The logout button is not displayed");
        String expectedUsername = "demouser";
        String actualUsername = loginPage.getCurrentUsername();
        Assert.assertEquals(expectedUsername, actualUsername, "The username is not as expected");

    }
    @Test(priority = 6)
    public void testLoginWithUser2() {
        loginPage.clickUsernameDropdown();
        loginPage.Select_User2_image_not_loading_use();
        loginPage.clickPasswordDropdown();
        loginPage.clickPasswordValid();
        loginPage.clickLoginButton();
        boolean isLogoutButtonDisplayed = loginPage.isLogoutButtonDisplayed();
        Assert.assertTrue(isLogoutButtonDisplayed, "The logout button is not displayed");
        String expectedUsername = "image_not_loading_user";
        String actualUsername = loginPage.getCurrentUsername();
        Assert.assertEquals(expectedUsername, actualUsername, "The username is not as expected");
    }

    @Test(priority = 7)
    public void testLoginWithUser3() {
        loginPage.clickUsernameDropdown();
        loginPage.Select_User3_existing_orders_user();
        loginPage.clickPasswordDropdown();
        loginPage.clickPasswordValid();
        loginPage.clickLoginButton();
        boolean isLogoutButtonDisplayed = loginPage.isLogoutButtonDisplayed();
        Assert.assertTrue(isLogoutButtonDisplayed, "The logout button is not displayed");
        String expectedUsername = "existing_orders_user";
        String actualUsername = loginPage.getCurrentUsername();
        Assert.assertEquals(expectedUsername, actualUsername, "The username is not as expected");

    }

    @Test(priority = 8)
    public void testLoginWithUser4() {
        loginPage.clickUsernameDropdown();
        loginPage.Select_User4_fav_user();
        loginPage.clickPasswordDropdown();
        loginPage.clickPasswordValid();
        loginPage.clickLoginButton();
        boolean isLogoutButtonDisplayed = loginPage.isLogoutButtonDisplayed();
        Assert.assertTrue(isLogoutButtonDisplayed, "The logout button is not displayed");
        String expectedUsername = "fav_user";
        String actualUsername = loginPage.getCurrentUsername();
        Assert.assertEquals(expectedUsername, actualUsername, "The username is not as expected");

    }

    @Test(priority = 9)
    public void testLoginWithUser5() {
        loginPage.clickUsernameDropdown();
        loginPage.Select_User5_existing_orders_user();
        loginPage.clickPasswordDropdown();
        loginPage.clickPasswordValid();
        loginPage.clickLoginButton();
        String expectedErrorMessage = "Your account has been locked1.";
        String actualErrorMessage = loginPage.getCurrentErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "The error message is not as expected");

    }


     @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
