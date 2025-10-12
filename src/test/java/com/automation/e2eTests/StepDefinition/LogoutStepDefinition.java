package com.automation.e2eTests.StepDefinition;

import com.automation.e2eTests.pageObjects.LoginPage;
import com.automation.e2eTests.pageObjects.LogoutPage;
import com.automation.e2eTests.utils.Validations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStepDefinition {

	private LogoutPage logoutPage;
	private Validations validation;

	public LogoutStepDefinition() {
		logoutPage = new LogoutPage();
		validation = new Validations();
	}

	@When("Je clique sur le bouton Avatar")
	public void jeCliqueSurLeBoutonAvatar() {
		logoutPage.clickOnAvatarButton();
	}

	@When("Je clique sur le bouton Deconnexion")
	public void jeCliqueSurLeBoutonDeconnexion() {
		logoutPage.logout();
	}

	@Then("Je suis redirige vers la page de connexion {string}")
	public void jeSuisRedirigeVersLaPageDeConnexion(String expectedTitle) {
		if (expectedTitle != null && !expectedTitle.trim().isEmpty()) {
			validation.assertEquals(LoginPage.getAuthenticationTitle(), expectedTitle);
		}
	}

}
