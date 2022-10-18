package com.geophy.automation.stepdefinitions;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.geophy.utils.common.Config;
import com.geophy.utils.selenium.DriverPool;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class BaseStep {

	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();


    @Before
    public void Setup(){
        String browserName = System.getenv("BROWSER") != null ? System.getenv("BROWSER"): Config.getProperty("BROWSER");
		String remoteURL = System.getenv("REMOTE_NODE_URL") != null ? System.getenv("REMOTE_NODE_URL"): Config.getProperty("REMOTE_URL");
		WebDriver driver = DriverPool.getDriver(browserName, remoteURL);
        threadLocalDriver.set(driver);

        System.out.println("Before Test Thread ID: "+Thread.currentThread().getId());

        getDriver().manage().window().maximize();
        getDriver().navigate().to(Config.getProperty("APPLICATION_URL"));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    @After
    public void tearDown(Scenario scenario){
    	Allure.step("Execution Finished for scenario");
		Allure.addAttachment(scenario.getName(), new ByteArrayInputStream(
				((TakesScreenshot)  getDriver()).getScreenshotAs(OutputType.BYTES)));
        getDriver().quit();
        threadLocalDriver.remove();
    }

}
