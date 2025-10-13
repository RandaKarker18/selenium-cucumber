package com.automation.e2eTests.StepDefinition;

import org.openqa.selenium.WebElement;

import com.automation.e2eTests.pageObjects.AgencyPage;
import com.automation.e2eTests.pageObjects.HomePage;
import com.automation.e2eTests.utils.Validations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AjouterAgenceStepDefinition {

	private Validations validation;
	private AgencyPage agencyPage;

	public AjouterAgenceStepDefinition() {
		agencyPage = new AgencyPage();
		validation = new Validations();
	}

	@When("Je clique sur le bouton Agences de page Home")
	public void jeCliqueSurLeBoutonAgencesDePageHome() {
		HomePage home = new HomePage();
		home.clickOnAgencyLink();
	}

	@Then("Je suis redirige vers la page de gestion des agences {string}")
	public void jeSuisRedirigeVersLaPageDeGestionDesAgences(String expectedTitle) {
		if (expectedTitle != null && !expectedTitle.trim().isEmpty()) {
			validation.assertEquals(agencyPage.getAgencyListTitle(), expectedTitle);
		}
	}

	@When("Je clique sur le button Ajouter Agence")
	public void jeCliqueSurLeButtonAjouterAgence() {
		agencyPage.clickAddAgencyButton();
		// agencyPage.waitForAddAgencyDialogToLoad();
	}

	@Then("une boite de dialog {string} s'ouvre")
	public void uneBoiteDeDialogSOuvre(String expectedTitle) {
		if (expectedTitle != null && !expectedTitle.trim().isEmpty()) {
			validation.assertEquals(agencyPage.getDialogTitle(), expectedTitle);
		}
	}

	@When("Je saisis nom d'agence qui existe")
	public void jeSaisisNomDAgenceQuiExiste() {
		agencyPage.fillAgencyName();
	}

	@When("Je clique sur le bouton Ajouter")
	public void jeCliqueSurLeBoutonAjouter() {
		agencyPage.addAgency();
	}

	@Then("une boite de dialog d'erreur s'ouvre {string}")
	public void uneBoiteDeDialogDErreurSOuvre(String expectedMsg) {
		WebElement errorPopup = agencyPage.showErrorPopup();
		validation.assertTrue(errorPopup, expectedMsg);
	}

	@When("Je clique sur le button OK")
	public void jeCliqueSurLeButtonOK() {
		agencyPage.closeErrorPopup();
	}

	@Then("Je trouve la boite de dialog {string} ouverte")
	public void jeTrouveLaBoiteDeDialogOuverte(String expectedTitle) {
		if (expectedTitle != null && !expectedTitle.trim().isEmpty()) {
			validation.assertEquals(agencyPage.getDialogTitle(), expectedTitle);
		}
	}

	@When("Je clique sur le button Annuler")
	public void jeCliqueSurLeButtonAnnuler() {
		agencyPage.cancel();
	}

	@Then("Agence n est pas ajoute a la liste des agences")
	public void agenceNEstPasAjouteALaListeDesAgences() {
		validation.assertEquals(1, agencyPage.isAgencyDuplicated());
	}

}
