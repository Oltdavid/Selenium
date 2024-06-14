package org.example;



import java.util.concurrent.TimeUnit;

import org.apache.http.client.params.ClientPNames;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;

public class Hooks {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public byte[] saveScreenshot() {
        try {
            return ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            throw new RuntimeException("Failed to take screenshot", e);
        }
    }

    @Before("@UITest")
    public void setUp() {
        RestAssured.config = RestAssured.config().httpClient(
                HttpClientConfig.httpClientConfig().setParam(ClientPNames.CONN_MANAGER_TIMEOUT, 1000L));

        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        driver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get().manage().deleteAllCookies();
        driver.get().manage().window().maximize();
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

        if (driver.get() != null) {
            driver.get().quit();
        }
    }
}