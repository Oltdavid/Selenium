package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue = {"web.app.api", "org.example"},
        tags = "@UITest"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}