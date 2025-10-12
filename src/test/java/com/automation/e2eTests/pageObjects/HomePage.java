package com.automation.e2eTests.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.e2eTests.utils.BasePage;
import com.automation.e2eTests.utils.SeleniumUtils;
import com.automation.e2eTests.utils.Wait;

public class HomePage extends BasePage {

	SeleniumUtils seleniumUtils;

	public HomePage() {
		super();
		seleniumUtils = new SeleniumUtils();
	}

	@FindBy(how = How.ID, using = "SoftTyp3")
	private static WebElement totalTicketsText;

	@FindBy(how = How.ID, using = "sidenav-title-dashboards")
	private WebElement dashboards;

	@FindBy(id = "SoftButton1")
	private WebElement btnCreateTicket;

	@FindBy(xpath = "//a[@href='/agences']")
	private WebElement agenciesLink;

	// By agencesLink = By.xpath("//div[@id='sidenav-title-agences']/ancestor::a");

	public void waitForHomeToLoad() {
		Wait wait = new Wait(driver);
		// wait.forLoading(Duration.ofSeconds(40));
		wait.forElementToBeDisplayed(Duration.ofSeconds(40), totalTicketsText, "Total des tickets");
	}

	public void clickOnCreateTicketButton() {
		seleniumUtils.clickOnElementUsingJs(btnCreateTicket);
	}

	public void clickOnAgencyLink() {
		seleniumUtils.clickOnElementUsingJs(agenciesLink);
//		Wait wait = new Wait(driver);
//		wait.forLoading(Duration.ofSeconds(20));
	}

	public static WebElement getTotalTicketsText() {
		return totalTicketsText;
	}

}
