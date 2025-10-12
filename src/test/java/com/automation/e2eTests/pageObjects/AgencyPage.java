package com.automation.e2eTests.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.e2eTests.utils.BasePage;
import com.automation.e2eTests.utils.ConfigFileReader;
import com.automation.e2eTests.utils.SeleniumUtils;
import com.automation.e2eTests.utils.Wait;

public class AgencyPage extends BasePage {

	private SeleniumUtils seleniumUtils;
	private ConfigFileReader configFileReader;
	private Wait wait = new Wait(driver);

	public AgencyPage() {
		super();
		seleniumUtils = new SeleniumUtils();
		configFileReader = new ConfigFileReader();
	}

	@FindBy(id = "add-agence-dialog-title")
	private WebElement dialogTitle;

	@FindBy(id = "agences-title")
	private WebElement agencyListTitle;

	@FindBy(id = "add")
	private WebElement addAgencyBtn;

	@FindBy(id = "name")
	private WebElement inputAgencyName;

	@FindBy(id = "add-agence-cancel-button")
	private WebElement dialogBtnCancel;

	@FindBy(id = "add-agence-submit-button")
	private WebElement dialogBtnAdd;

	@FindBy(how = How.CLASS_NAME, using = "swal2-popup")
	private WebElement errorPopup;

	@FindBy(id = "swal2-html-container")
	private WebElement errorMsg;

	@FindBy(className = "swal2-confirm")
	private WebElement btnOkerrorDiallog;

	public void clickAddAgencyButton() {
		seleniumUtils.click(addAgencyBtn);
		wait.forElementToBeDisplayed(Duration.ofSeconds(30), dialogTitle, "Add Agency Dialog");
	}

	public WebElement getDialogTitle() {
		return dialogTitle;
	}

	public WebElement getAgencyListTitle() {
		wait.forElementToBeDisplayed(Duration.ofSeconds(10), agencyListTitle, "agencyListTitle");
		return agencyListTitle;
	}

	public void fillAgencyName() {
		seleniumUtils.writeText(inputAgencyName, configFileReader.getProperties("agency.duplicatename"));
	}

	public void addAgency() {
		seleniumUtils.click(dialogBtnAdd);
	}

	public WebElement showErrorPopup() {

		wait.forElementToBeDisplayed(Duration.ofSeconds(10), errorPopup, "Error Popup");
		return errorMsg;
	}

	public void closeErrorPopup() {
		seleniumUtils.click(btnOkerrorDiallog);
	}

	public void cancel() {
		seleniumUtils.click(dialogBtnCancel);
	}

	public long isAgencyDuplicated() {

		String newAgencyName = configFileReader.getProperties("agency.duplicatename");
		List<WebElement> existingAgencies = seleniumUtils
				.findElements(By.xpath("//tbody[@id='TableBody']//tr/td[1]//div"));

		// Verify if there is more than one occurrence
		return existingAgencies.stream().map(e -> e.getText().trim())
				.filter(name -> name.equalsIgnoreCase(newAgencyName.trim())).count();

	}

}
