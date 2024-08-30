package org.example;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources",
        glue = {"web.app.api", "org.example"},
        tags = "@UITest or @APITest",
        plugin = {
                "pretty",
                "html:target/CucumberTestReport.html",
                "json:target/cucumber-reports/CucumberTestReport.json", // JSON riport gen
                "junit:target/cucumber-reports/cucumber.xml"
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