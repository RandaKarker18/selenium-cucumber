package com.automation.e2eTests.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.e2eTests.utils.BasePage;
import com.automation.e2eTests.utils.ConfigFileReader;
import com.automation.e2eTests.utils.SeleniumUtils;

public class LoginPage extends BasePage {

	private SeleniumUtils seleniumUtils;
	private ConfigFileReader configFileReader;

	@FindBy(how = How.ID, using = "sign-in-email-input")
	private static WebElement userName;

	@FindBy(how = How.ID, using = "sign-in-password-input")
	private static WebElement password;

	@FindBy(id = "sign-in-button")
	private static WebElement btnLogin;

	@FindBy(id = "authentication-layout-title")
	private static WebElement authenticationTitle;

	public LoginPage() {
		super();
		seleniumUtils = new SeleniumUtils();
		configFileReader = new ConfigFileReader();
	}

	public void openLoginPage() {
		seleniumUtils.get(configFileReader.getProperties("home.url"));
	}

	public String getLoginPageTitle() {
		return seleniumUtils.getTitle();
	}

	public void fillUserName() {
		seleniumUtils.writeText(userName, configFileReader.getProperties("home.username"));
	}

	public void fillPassword() {
		seleniumUtils.writeText(password, configFileReader.getProperties("home.password"));
	}

	public void login() {
		seleniumUtils.click(btnLogin);
	}

	public static WebElement getUserName() {
		return userName;
	}

	public static WebElement getPassword() {
		return password;
	}

	public static WebElement getBtnLogin() {
		return btnLogin;
	}

	public static WebElement getAuthenticationTitle() {
		return authenticationTitle;
	}

}
