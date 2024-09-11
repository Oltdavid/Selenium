package org.example;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class ApiHooks {

    public static class RequestLoggingFilter implements Filter {
        @Override
        public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
            Scenario scenario = Hooks.getScenario();
            if (scenario != null) {
                scenario.log("Request URI: " + requestSpec.getURI());
            }
            return ctx.next(requestSpec, responseSpec);
        }
    }

    @AfterStep("@APITest")
    public void logRequestDetails() {
        RestAssured.filters(new RequestLoggingFilter());
    }
}