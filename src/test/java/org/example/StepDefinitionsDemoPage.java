package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitionsDemoPage {

    private DemoPage demoPage;
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://dev//files//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        demoPage = new DemoPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I have opened the browser and navigated to the StackDemo login page")
    public void i_have_opened_the_browser_and_navigated_to_the_StackDemo_login_page() {
        demoPage.openPage();
        demoPage.clickOnSignInButton();
    }

    @When("I click on the username dropdown")
    public void i_click_on_the_username_dropdown() {
        demoPage.clickUsernameDropdown();
    }

    @When("I press Enter")
    public void i_press_Enter() {
        demoPage.pressEnter();
    }

    @When("I click on the Login button")
    public void i_click_on_the_Login_button() {
        demoPage.clickLoginButton();
    }

    @Then("I should see the error message {string}")
    public void i_should_see_the_error_message(String expectedErrorMessage) {
        String errorMessage = demoPage.getErrorMessage();
        assertTrue(errorMessage.contains(expectedErrorMessage));
    }


}