package com.automation.e2eTests.StepDefinition;

import com.automation.e2eTests.pageObjects.HomePage;
import com.automation.e2eTests.pageObjects.LoginPage;
import com.automation.e2eTests.utils.Validations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	private LoginPage loginPage;
	private HomePage homePage;
	private Validations validation;

	public LoginStepDefinition() {
		loginPage = new LoginPage();
		validation = new Validations();
		homePage = new HomePage();
	}

	@Given("Je me connecte sur le site proservices")
	public void jeMeConnecteSurLeSiteProservices() {
		loginPage.openLoginPage();

	}

	@When("Je saisis le champ email")
	public void jeSaisisLeChampEmail() {
		loginPage.fillUserName();
	}

	@When("Je saisis le champ password")
	public void jeSaisisLeChampPassword() {
		loginPage.fillPassword();
	}

	@When("Je clique sur le boutton se connecter")
	public void jeCliqueSurLeBouttonSeConnecter() {
		loginPage.login();
		homePage.waitForHomeToLoad();
	}

	@Then("Je me redirige vers la page Home {string}")
	public void jeMeRedirigeVersLaPageHome(String expectedTitle) {
		if (expectedTitle != null && !expectedTitle.trim().isEmpty()) {
			validation.assertEquals(HomePage.getTotalTicketsText(), expectedTitle);
		}
	}

}
