package com.automation.e2eTests;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/spec/features" }, plugin = { "pretty", "html:target/report/cucumber-report.html",
		"json:target/report/cucumber.json" }, tags = ("@addAgency_duplicate"),
		/*
		 * glue = {"src/test/java/com/automation/e2eTests/StepDefinition" },
		 */
		/*
		 * tags = ("@login_valid_credentials or @Logout"),@createTicket_valid
		 * or @createTicket_invalid
		 */
		monochrome = true, snippets = CAMELCASE)

public class RunWebSuiteTest {

}
