package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<Scenario> currentScenario = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static Scenario getScenario() {
        return currentScenario.get();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        currentScenario.set(scenario);
    }

    @After
    public void afterScenario() {
        if (driver.get() != null) {
            driver.get().quit();
        }
        currentScenario.remove();
    }

    @Before("@UITest")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        driver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get().manage().deleteAllCookies();
        driver.get().manage().window().maximize();
    }

    @After("@UITest")
    public void tearDown() {
        if (getScenario().isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.BYTES);
            getScenario().attach(screenshot, "image/png", "Screenshot on Failure");
        }
        driver.get().quit();
    }
}