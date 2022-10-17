package com.github.automation.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.geophy.utils.common.Config;
import com.geophy.utils.selenium.DriverManager;

public class BaseConfiguration {

	public WebDriver driver = null;

	DriverManager driverManager;

	public BaseConfiguration() {
		driverManager = new DriverManager();
		driver = driverManager.getDriver();
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
		driver.navigate().to(Config.getProperty("APPLICATION_URL"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

	}
	
	

}
