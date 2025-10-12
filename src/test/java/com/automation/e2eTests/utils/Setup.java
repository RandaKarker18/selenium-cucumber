package com.automation.e2eTests.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * Utility class for initializing and managing the {@link WebDriver} instance
 * before executing Cucumber scenarios.
 *
 * This class uses the {@code @Before} annotation to automatically start a
 * browser before each scenario. The browser is dynamically selected based on
 * the system property {@code -Dbrowser}.
 *
 * Supported browsers: - chrome (default) - firefox - edge
 *
 * If no parameter is provided, Chrome will be used by default.
 *
 * A logger is also available to track scenario status and driver
 * initialization.
 */
public class Setup {

	private static WebDriver driver;
	private static final Logger LOGGER = (Logger) LogManager.getLogger(Setup.class.getName());

	/**
	 * Executed before each Cucumber scenario. Initializes a {@link WebDriver}
	 * instance depending on the browser specified via the system property
	 * {@code -Dbrowser}. If no parameter is specified, Chrome is used by default.
	 * 
	 * @param scenario the Cucumber scenario currently being executed
	 * @throws IllegalArgumentException if the requested browser is not supported
	 */
	@Before
	public void setWebDriver(Scenario scenario) {

		LOGGER.info("Scenario: " + scenario.getName() + " -started.");

		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = "chrome";
		}

		switch (browser.toLowerCase()) {

		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("disable-infobars"); // disabling infobars
			options.addArguments("--disable-extensions"); // disabling extensions
			options.addArguments("--disable-gpu"); // applicable to windows os only
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			options.addArguments("--no-sandbox"); // Bypass OS security model
			options.addArguments("--disable-logging");
			options.addArguments("--log-level=3");
			options.addArguments("--remote-debugging-pipe");
			// options.addArguments("--headless=new");
			// options.addArguments("force-device-scale-factor=0.75");
			driver = new ChromeDriver(options);
			break;

		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--start-maximized");
			// firefoxOptions.setCapability("platform", Platform.WIN11);
			driver = new FirefoxDriver(firefoxOptions);
			break;

		case "edge":
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		default:
			throw new IllegalArgumentException("Browser not supported : " + browser);
		}
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
