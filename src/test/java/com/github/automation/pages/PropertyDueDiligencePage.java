package com.github.automation.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.geophy.utils.selenium.WebUtils;
import com.github.automation.core.BaseConfiguration;

public class PropertyDueDiligencePage extends BaseConfiguration {

	@FindBy(id = "address_input")
	private WebElement propertySearchBar;
	
	@FindBy(css = "#report-navigation li.inline")
	private List<WebElement> homePageHeaderTabs;
	
	@FindBy(xpath = "//a[.='Property Due Diligence']")
	private WebElement propertydueDiligenceTab;
	
	@FindBy(xpath = "//a[.='Property Map']")
	private WebElement propertyMapTab;
	
	@FindBy(xpath = "//a[.='Insights Portal']")
	private WebElement insightsPortalTab;
	
	@FindBy(css = "a[data-test='view-sample-property']")
	private WebElement viewSamplePropertyLink;
	
	@FindBy(xpath = "//div[.='Evra Analysis']")
	private WebElement evraAnalysisLabel;
	
	@FindBy(css = "div.box-title")
	private List<WebElement> analysisTabsSubSections;

	private WebUtils webUtils;

	public PropertyDueDiligencePage() {
		webUtils = new WebUtils(driver);
	}
	
	public boolean isSearchBarVisible() {
		webUtils.waitForElementVisibility(propertySearchBar, 10);
	    return propertySearchBar.isDisplayed();
	}
	
	public void openSampleProperty() {
		webUtils.waitForElementVisibility(viewSamplePropertyLink, 10);
	    webUtils.click(viewSamplePropertyLink);
		webUtils.waitForElementVisibility(evraAnalysisLabel, 10);
	}
	
	public List<String> getHeaderTabNames() {
		return homePageHeaderTabs.stream().map(tab -> webUtils.getTextUsingAttribute(tab, "innerText")).collect(Collectors.toList());
	}
	
	public List<String> getAnalysisTabsSubSectionTitles() {
		return analysisTabsSubSections.stream().map(tab -> webUtils.getTextUsingAttribute(tab, "innerText")).collect(Collectors.toList());
	}
}
