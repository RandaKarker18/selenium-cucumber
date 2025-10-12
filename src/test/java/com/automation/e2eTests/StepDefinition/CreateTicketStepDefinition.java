package com.automation.e2eTests.StepDefinition;

import com.automation.e2eTests.pageObjects.CreateTicketPage;
import com.automation.e2eTests.pageObjects.HomePage;
import com.automation.e2eTests.utils.Validations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateTicketStepDefinition {

	private Validations validation;
	private CreateTicketPage createTicketPage;

	public CreateTicketStepDefinition() {
		validation = new Validations();
		createTicketPage = new CreateTicketPage();
	}

	@When("Je clique sur le bouton Creation Ticket de page Home")
	public void jeCliqueSurLeBoutonCreationTicketDePageHome() {
		HomePage homePage = new HomePage();
		homePage.clickOnCreateTicketButton();
		createTicketPage.waitForCreateTicketPageToLoad();
	}

	@Then("Je suis redirige vers la page de creation de ticket {string}")
	public void jeSuisRedirigeVersLaPageDeCreationDeTicket(String expectedTitle) {
		if (expectedTitle != null && !expectedTitle.trim().isEmpty()) {
			validation.assertEquals(createTicketPage.getNewTicketLabel(), expectedTitle);
		}
	}

	@When("Je saisis tous les champs obligatoires")
	public void jeSaisisTousLesChampsObligatoires() {
		createTicketPage.fillRequiredFields();
	}

	@When("Je clique sur le bouton creation ticket")
	public void jeCliqueSurLeBoutonCreationTicket() {
		createTicketPage.createTicket();
	}

	@Then("Le ticket est cree avec succes")
	public void leTicketEstCreeAvecSucces() {

	}

	@Then("Le ticket apparait dans la liste des tickets")
	public void leTicketApparaitDansLaListeDesTickets() {

	}

	@When("Je ne saisie pas un champ obligatoire")
	public void jeNeSaisiePasUnChampObligatoire() {
		createTicketPage.clearOneRequiredField();
	}

	@Then("Un message d'erreur est affiche")
	public void unMessageDErreurEstAffiche() {

	}

	@Then("Le ticket n est pas cree")
	public void leTicketNEstPasCree() {

	}

}
