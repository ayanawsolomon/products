package com.pipelines.main;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "html:target/cucumberHtmlReport", "json:target/cucumber-report.json" }, 
		features = "src/test/java/features", 
		glue = { "src/test/java/integerationTest" }
		//tags = {"@run"}
		)
public class RunnerCucumber {
}