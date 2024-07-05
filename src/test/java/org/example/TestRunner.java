package org.example;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        // Path to the feature files.
        features = "src/test/resources",
        // Package where the step definitions are located.
        glue = {"web.app.api", "org.example"},
        // Tags to determine which scenarios to run.
        tags = "@UITest or @APITest",
        // Plugin to generate Allure reports.
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

    // Overrides the default data provider to enable parallel test execution.
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}