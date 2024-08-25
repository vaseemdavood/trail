package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/java/cucumber",glue ="stepdefinition",tags="@Regression" ,monochrome=true,plugin = {"pretty","html:target/cucumber.html"})
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
