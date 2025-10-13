package com.automation.e2eTests.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.e2eTests.utils.SeleniumUtils;
import com.automation.e2eTests.utils.Wait;

public class LogoutPage extends BasePage {

	private SeleniumUtils seleniumUtils;

	@FindBy(how = How.ID, using = "SoftButton2")
	private WebElement btnProfile;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Déconnecter']")
	private WebElement btnLogout;

	public LogoutPage() {
		super();
		seleniumUtils = new SeleniumUtils(driver);
	}

	public void clickOnProfileButton() {

		WebElement clickableBtn = Wait.waitUntilClickable(driver, Duration.ofSeconds(10), btnProfile);
		seleniumUtils.safeClick(clickableBtn);

	}

	public void logout() {
		WebElement clickablebtnLogout = Wait.waitUntilClickable(driver, Duration.ofSeconds(10), btnLogout);
		seleniumUtils.safeClick(clickablebtnLogout);

	}

	public WebElement getBtnProfile() {
		return btnProfile;
	}

	public WebElement getBtnLogout() {
		return btnLogout;
	}

}
