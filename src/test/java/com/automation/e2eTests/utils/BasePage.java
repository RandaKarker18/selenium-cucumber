package com.automation.e2eTests.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	protected WebDriver driver;
	protected static Logger log = (Logger) LogManager.getLogger(BasePage.class.getName());

	public BasePage() {
		this.driver = Setup.getDriver();
		PageFactory.initElements(driver, this);// Initialize the web elements annotated with @FindBy of your page class.
	}

}
