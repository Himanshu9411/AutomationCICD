package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber",glue="rahulshettyacademy.stepDefination",
monochrome=true,plugin= {"html:traget/cucumber.html"},tags="@ErrorValidation")
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
