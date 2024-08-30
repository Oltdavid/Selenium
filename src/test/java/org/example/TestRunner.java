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
                "html:target/cucumber-reports/cucumber-html-report",
                "json:target/cucumber-reports/cucumber.json", // open JSON riport
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