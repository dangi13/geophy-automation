package com.github.automation.stepdefinitions;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.github.automation.core.BaseConfiguration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hooks {

    public WebDriver driver;

	@Before
	public void beforeScenario(Scenario scenario) {
		driver = new BaseConfiguration().driver;
		Allure.step("Started execution for scenario");
	}

	@After
	public void afterScenario(Scenario scenario)
			throws InterruptedException, IOException, IllegalMonitorStateException {
		Allure.step("Execution Finished for scenario");
		Allure.addAttachment(scenario.getName(), new ByteArrayInputStream(
				((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		 driver.quit();
	}

}
