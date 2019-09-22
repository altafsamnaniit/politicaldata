package com.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = false,
        features = {"src/test/resources/features"},
        glue = {"com.stepDef"},
        monochrome = true,
        plugin = {"pretty", "html:target//cucumber-html-reports/cucumber-pretty", "json:target//cucumber-html-reports/cucumber.json"}
)
public class TestRunner {

    public static void main(String[] args) {
        JUnitCore.main(TestRunner.class.getName());
    }

}
