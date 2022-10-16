package com.geophy.utils.selenium;

import org.openqa.selenium.WebDriver;

import com.geophy.utils.common.Config;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {

		if (driver.get() != null) {
			return driver.get();
		}
		
		String browserName = System.getenv("BROWSER") != null ? System.getenv("BROWSER"): Config.getProperty("BROWSER");
		String remoteURL = System.getenv("REMOTE_NODE_URL") != null ? System.getenv("REMOTE_NODE_URL"): Config.getProperty("REMOTE_URL");
		driver.set(DriverPool.getDriver(browserName, remoteURL));

		return driver.get();
	}
}
