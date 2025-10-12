package com.automation.e2eTests.StepDefinition;

import io.cucumber.java.en.Given;

public class CommonSteps {

	LoginStepDefinition loginSteps = new LoginStepDefinition();

	@Given("Je suis deja connecte")
	public void jeSuisDejaConnecte() {
		loginSteps.jeMeConnecteSurLeSiteProservices();
		loginSteps.jeSaisisLeChampEmail();
		loginSteps.jeSaisisLeChampPassword();
		loginSteps.jeCliqueSurLeBouttonSeConnecter();
	}

}
