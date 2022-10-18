package com.geophy.utils.selenium;

import static com.geophy.utils.common.Constants.CHROME;
import static com.geophy.utils.common.Constants.HEADLESS_CHROME;
import static com.geophy.utils.common.Constants.CHROME_BROWSERSTACK;
import static com.geophy.utils.common.Constants.LOG_DESIGN;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * It contains pool of web drivers for desktop web applications.
 * 
 * @author Jaikant
 *
 */
public class DriverPool {
	private static final Logger LOGGER = LoggerFactory.getLogger(DriverPool.class);

	/**
	 * It will get the WebDriver for specified browser when we want to run it on
	 * Selenium grid or any cloud solution.
	 * 
	 * @param browser
	 * @param nodeURL : can be a BorserStack/Saucelabs connect url, or a Selenium
	 *                hub or node URL
	 * @return WebDriver
	 */
	public static WebDriver getDriver(String browser, String nodeURL) {
		LOGGER.info("Creating driver instance for browser: [" + browser + "] and nodeURL as [" + nodeURL + "]" );

		WebDriver driver = null;
		try {
			if (Objects.nonNull(nodeURL) && !nodeURL.isEmpty()) {
				LOGGER.info(LOG_DESIGN + "Getting Remote web driver for : {} and node URL is : {} ", browser, nodeURL);
				driver = getRemoteDriver(browser, nodeURL);
			} else {
				driver = getWebDriver(browser);
				LOGGER.info(LOG_DESIGN + "Getting web driver for browser : {}", browser);
			}
		} catch (Exception e) {
			LOGGER.error(LOG_DESIGN + "!!!!!!!! Exception occurred while getting webdriver : {}", e.getMessage());
		}

		return driver;
	}

	/**
	 * @param browser browser name
	 * @param nodeURL node URL where want to run execution
	 * @return RemoteWebDriver corresponding to the given browser value
	 * @throws MalformedURLException
	 */
	public static WebDriver getRemoteDriver(String browser, String nodeURL) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		LOGGER.info("I AM INSIDE REMOTE DRIVER");
		switch (browser.toLowerCase()) {
		case CHROME:
			LOGGER.info("THIS IS THE DEFAULT SYSTEM BRO");
			cap = DesiredCapabilities.chrome();
			break;
		case CHROME_BROWSERSTACK:
			LOGGER.info("I AM INSIDE ENABLED BSTACK OPTION");
			cap = DesiredCapabilities.chrome();
			cap = DesiredCapabilities.chrome();
			HashMap<String, Boolean> networkLogsOptions = new HashMap<>();
			networkLogsOptions.put("captureContent", true);
			cap.setCapability("browserstack.networkLogs", true);
			cap.setCapability("browserstack.networkLogsOptions", networkLogsOptions);
			cap.setJavascriptEnabled(false);
			LOGGER.info("I AM setting uop ENABLED BSTACK OPTION");
			nodeURL = System.setProperty("REMOTE_NODE_URL", System.getenv("BROWSERSTACK_URL"));
			break;
		default:
			LOGGER.info("THIS IS THE DEFAULT SYSTEM BRO");
			cap = DesiredCapabilities.chrome();
			break;
		}

		LOGGER.info("FINALLY SOME REMORE  SYSTEM BRO");
		// TODO add support for configuring it from properties file as well.
		return new RemoteWebDriver(new URL(System.getProperty("REMOTE_NODE_URL")), cap);
	}

	/**
	 * @param browser browser name
	 * @return WebDriver corresponding to the given browser value
	 * @throws MalformedURLException
	 */
	public static WebDriver getWebDriver(String browser) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		WebDriver driver = null;
		switch (browser.toLowerCase()) {
		case CHROME:
			driver = getChromeDriver(cap);
			break;
		case HEADLESS_CHROME:
			driver = getHeadlessChromeDriver(cap);
			break;
		default:
			driver = getHeadlessChromeDriver(cap);
			break;
		}

		return driver;
	}

	/**
	 * @return instance of chrome driver
	 */
	public static WebDriver getChromeDriver(DesiredCapabilities cap) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("--disable-notifications");
		options.setCapability(ChromeOptions.CAPABILITY, options);

		return new ChromeDriver(options);
	}
	
	public static WebDriver getChromium(DesiredCapabilities cap) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("--disable-notifications");
		options.setCapability(ChromeOptions.CAPABILITY, options);

		return new ChromeDriver(options);
	}

	/**
	 * @return instance of chrome driver
	 */
	public static WebDriver getHeadlessChromeDriver(DesiredCapabilities cap) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");

		return new ChromeDriver(options);
	}

}