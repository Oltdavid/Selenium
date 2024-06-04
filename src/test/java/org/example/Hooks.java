package org.example;

import static org.testng.AssertJUnit.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;

public class Hooks {
    public static WebDriver driver;

    public byte[] saveScreenshot() {
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            throw new RuntimeException("Failed to take screenshot", e);
        }
    }

    @Before("@UITest")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }



    @After("@UITest")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                Thread.sleep(2000);  // wait 2 sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png", saveScreenshot());
        }

        if (driver != null) {
            driver.quit();
        }
    }
}