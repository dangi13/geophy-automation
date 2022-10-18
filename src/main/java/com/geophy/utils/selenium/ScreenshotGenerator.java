package com.geophy.utils.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenshotGenerator {

	/** It will capture the screenshot of the current page.
	 * @param driver
	 * @param testCaseName
	 * @return screenshot path
	 */
	public String captureScreen(WebDriver driver, String testCaseName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String screenShotPath = System.getProperty("user.dir") + File.separatorChar + "Screenshots" + File.separatorChar
				+ testCaseName + ".png";
		System.out.println("Screenshot path is : " + screenShotPath);
		File target = new File(screenShotPath);
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			System.out.println("Exception while creating screenshot.." + e.getMessage());
		}

		return screenShotPath;
	}
}
