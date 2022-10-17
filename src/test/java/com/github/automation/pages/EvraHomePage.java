package com.github.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.geophy.utils.selenium.WebUtils;

public class EvraHomePage {
	
	@FindBy(css = "button[data-test=login-button]")
	private WebElement loginButton;
	
	@FindBy(xpath = "//a[.='Property Due Diligence']")
	private WebElement propertydueDiligenceTab;
	
	@FindBy(xpath = "//a[.='Property Map']")
	private WebElement propertyMapTab;
	
	@FindBy(xpath = "//a[.='Insights Portal']")
	private WebElement insightsPortalTab;
	
	WebUtils webUtils;

	public EvraHomePage(WebDriver driver) {
		webUtils = new WebUtils(driver);
		PageFactory.initElements(driver, this);
	}

	public void launchUrl(String url) {
		webUtils.navigateToURL(url);
	}
	
	public void openLoginForm() {
		webUtils.click(loginButton);
	}
	
	public void openInsightsPortalTab() {
		webUtils.click(insightsPortalTab);
	}
	
	public void openPropertyMapTab() {
		webUtils.click(propertyMapTab);
	}
	
	public void openPropertydueDiligenceTab() {
		webUtils.click(propertyMapTab);
	}
	

}
