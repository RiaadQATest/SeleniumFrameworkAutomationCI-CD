package riaadSeleniumFrameWork.Tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/cucumber",glue="riaadSeleniumFrameWork.StepDefinitions",
monochrome=true,tags ="@Regression", plugin= {"pretty", "html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {



}

