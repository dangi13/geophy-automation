package com.geophy.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.geophy.utils.selenium.WebUtils;

public class InsightsPortalPage {
	

	@FindBy(css = "h1[data-test=insight-customize-header]")
	private WebElement insightCustomizeHeader;

	
	@FindBy(css = "a[data-test='insight-customise-getInTouchButton']")
	private WebElement getInTouchButton;

	private WebUtils webUtils;

	public InsightsPortalPage(WebDriver driver) {
		webUtils = new WebUtils(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean isInsightCustomizeHeaderPresent() {
		return webUtils.isElementDisplayed(insightCustomizeHeader);
	}
	
	public boolean isGetInTouchButtonPresent() {
		return webUtils.isElementDisplayed(getInTouchButton);
	}
	
	
	public String getEmailLinkFromGetinTouchButton() {
		return webUtils.getTextUsingAttribute(getInTouchButton, "href");
	}

}
