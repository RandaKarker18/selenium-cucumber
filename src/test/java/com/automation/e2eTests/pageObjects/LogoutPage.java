package com.automation.e2eTests.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.e2eTests.utils.BasePage;
import com.automation.e2eTests.utils.SeleniumUtils;
import com.automation.e2eTests.utils.Wait;

public class LogoutPage extends BasePage {

	private SeleniumUtils seleniumUtils;

	@FindBy(how = How.ID, using = "SoftButton2")
	private static WebElement btnAvatar;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Déconnecter']")
	private static WebElement btnLogout;

	private By btnAvatarLocator = By.id("SoftButton2");
	private By btnLogoutLocator = By.xpath("//span[normalize-space()='Déconnecter']");

	public LogoutPage() {
		super();
		seleniumUtils = new SeleniumUtils();
	}

	public void clickOnAvatarButton() {

		// Wait wait = new Wait(driver);
		Wait.waitUntilClickable(driver, btnAvatarLocator);
//		seleniumUtils.clickOnElementUsingJs(logoutPage.getBtnAvatarLocator());
		seleniumUtils.clickOnElementUsingActions(btnAvatar);

	}

	public void logout() {
		Wait wait = new Wait(driver);
		wait.forElementToBeDisplayed(Duration.ofSeconds(40), btnLogout, "btnLogout");
		// seleniumUtils.clickOnElementUsingActions(btnLogout);
		seleniumUtils.clickOnElementUsingJs(btnLogout);

	}

	public By getBtnLogoutLocator() {
		return btnLogoutLocator;
	}

	public static WebElement getBtnAvatar() {
		return btnAvatar;
	}

	public static WebElement getBtnLogout() {
		return btnLogout;
	}

	public By getBtnAvatarLocator() {
		return btnAvatarLocator;
	}

}
