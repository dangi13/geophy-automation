package com.github.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.geophy.utils.selenium.WebUtils;
import com.github.automation.core.BaseConfiguration;

public class EvraHomePage extends BaseConfiguration{
	
	@FindBy(css = "button[data-test=login-button]")
	private WebElement loginButton;
	
	WebUtils webUtils;

	public EvraHomePage() {
		webUtils = new WebUtils(driver);
	}

	public void launchUrl(String url) {
		webUtils.navigateToURL(url);
	}
	
	public void openLoginForm() {
		webUtils.click(loginButton);
	}
	

}
