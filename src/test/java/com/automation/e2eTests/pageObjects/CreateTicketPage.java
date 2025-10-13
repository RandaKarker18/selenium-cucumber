package com.automation.e2eTests.pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.e2eTests.utils.ConfigFileReader;
import com.automation.e2eTests.utils.SeleniumUtils;
import com.automation.e2eTests.utils.Wait;

public class CreateTicketPage extends BasePage {

	private SeleniumUtils seleniumUtils;
	private ConfigFileReader configFileReader;

	public CreateTicketPage() {
		super();
		seleniumUtils = new SeleniumUtils(driver);
		configFileReader = new ConfigFileReader();
	}

	@FindBy(how = How.XPATH, using = "//h5[normalize-space()='Nouveau Ticket']")
	private WebElement newTicketLabel;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Departements*')]/following::input[@role='combobox'][1]")
	private WebElement departementInput;

	@FindBy(how = How.XPATH, using = "//input[@id='right-SoftInputRoot-SoftInput']")
	private WebElement titreInput;

	@FindBy(how = How.XPATH, using = "//textarea[@id='right-SoftInputRoot-SoftInput']")
	private WebElement descriptionInput;

	@FindBy(how = How.XPATH, using = "//label[normalize-space()='Responsable*']/following::input[@role='combobox'][1]")
	private WebElement responsableInput;

	@FindBy(how = How.XPATH, using = "//button[@id='SoftButtonRoot-softButton']")
	private WebElement createButton;

	public WebElement getNewTicketLabel() {
		return newTicketLabel;
	}

	public void waitForCreateTicketPageToLoad() {
		Wait wait = new Wait(driver);
		wait.forElementToBeDisplayed(Duration.ofSeconds(40), newTicketLabel, "newTicket element");
	}

	public void fillRequiredFields() {
		Wait.waitUntilClickable(driver, Duration.ofSeconds(20), departementInput);

		// seleniumUtils.setValueWithJS(driver, departementInput,
		// configFileReader.getProperties("ticket.departement"));
		seleniumUtils.writeText(titreInput, configFileReader.getProperties("ticket.titre"));
		seleniumUtils.writeText(descriptionInput, configFileReader.getProperties("ticket.description"));
		seleniumUtils.setValueWithJS(driver, responsableInput, configFileReader.getProperties("ticket.responsabel"));
//		responsableInput.click();
//		responsableInput.sendKeys(configFileReader.getProperties("ticket.responsabel"));
//		responsableInput.sendKeys(Keys.ENTER);
		departementInput.click();
		departementInput.sendKeys(configFileReader.getProperties("ticket.departement"));
		departementInput.sendKeys(Keys.ENTER);
	}

	public void clearOneRequiredField() {
		Wait.waitUntilClickable(driver, Duration.ofSeconds(20), departementInput);
		seleniumUtils.writeText(departementInput, configFileReader.getProperties("ticket.departement"));
		seleniumUtils.writeText(titreInput, configFileReader.getProperties("ticket.titre"));
		seleniumUtils.writeText(descriptionInput, configFileReader.getProperties("ticket.description"));
	}

	public void createTicket() {
		seleniumUtils.clickWithJS(driver, createButton);
	}

}
