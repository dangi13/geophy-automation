package com.geophy.automation.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.geophy.utils.selenium.WebUtils;

public class PropertyDueDiligencePage {

	@FindBy(id = "address_input")
	private WebElement propertySearchBar;
	
	@FindBy(css = "#report-navigation li.inline")
	private List<WebElement> homePageHeaderTabs;
	
	@FindBy(css = "a[data-test='view-sample-property']")
	private WebElement viewSamplePropertyLink;
	
	@FindBy(xpath = "//div[.='Evra Analysis']")
	private WebElement evraAnalysisLabel;
	
	@FindBy(css = "div.box-title")
	private List<WebElement> analysisTabsSubSections;
	
	@FindBy(id = "address_input")
	private WebElement searchBarInputBox;
	
	@FindBy(css = "div.pac-item")
	private List<WebElement> searchResultDropdown;
	
	@FindBy(css = "div[data-test='page-Valuation']")
	private WebElement valuationTab;
	
	@FindBy(id = "number_of_units")
	private WebElement numberOfUnitsInputBox;
	
	@FindBy(id = "year_built")
	private WebElement builtYearInputBox;
	
	@FindBy(id = "noi")
	private WebElement noiInputBox;
	
	@FindBy(css = "button[data-test=valuation-form-submit-button]")
	private WebElement runValuationButton;
	
	@FindBy(xpath = "//span[.='Property Details']")
	private WebElement propertyDetailsSection;
	
	@FindBy(xpath = "//div[.=' Evra Valuation ']")
	private WebElement evraValuationHeader;
	
	@FindBy(xpath = "//div[.=' Evra Valuation Per Unit ']")
	private WebElement evraValuationPerUnitHeader;
	
	@FindBy(xpath = "//div[.=' Evra Cap Rate ']")
	private WebElement evraCapRateHeader;
	
	@FindBy(xpath = "//div[.=' Confidence Indicator ']")
	private WebElement confidenceIndicatorHeader;

	private WebUtils webUtils;

	public PropertyDueDiligencePage(WebDriver driver) {
		webUtils = new WebUtils(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean isSearchBarVisible() {
		webUtils.waitForElementVisibility(propertySearchBar);
	    return propertySearchBar.isDisplayed();
	}
	
	public void openSampleProperty() {
	    webUtils.click(viewSamplePropertyLink);
		webUtils.waitForElementVisibility(evraAnalysisLabel);
	}
	
	public List<String> getHeaderTabNames() {
		return homePageHeaderTabs.stream().map(tab -> webUtils.getTextUsingAttribute(tab, "innerText")).collect(Collectors.toList());
	}
	
	public List<String> getAnalysisTabsSubSectionTitles() {
		return analysisTabsSubSections.stream().map(tab -> webUtils.getTextUsingAttribute(tab, "innerText")).collect(Collectors.toList());
	}
	
	public void searchAddress(String address) {
		webUtils.enterText(searchBarInputBox, " ");
		webUtils.click(searchBarInputBox);
		webUtils.enterText(searchBarInputBox, address);
		webUtils.sleep(2);
		webUtils.click(searchResultDropdown.get(0));
		webUtils.waitForElementVisibility(evraAnalysisLabel);
	}
	
	public void openValuationTab() {
		webUtils.click(valuationTab);
		webUtils.waitForElementVisibility(evraAnalysisLabel);
		webUtils.waitForElementVisibility(numberOfUnitsInputBox);
	}
	
	public void enterValuationInputs(String numberOfUnits, String yearOfconstruction, String netOperatingIncome ) {
		webUtils.enterText(numberOfUnitsInputBox, numberOfUnits);
		webUtils.enterText(builtYearInputBox, yearOfconstruction);
		webUtils.enterText(noiInputBox, netOperatingIncome);
		
	}
	
	public void runValuation() {
		webUtils.click(runValuationButton);
		webUtils.waitForElementVisibility(propertyDetailsSection);
	}
	
	public boolean propertyDetailsHeadersArePresent () {
		
		return webUtils.isElementDisplayed(evraValuationHeader)
				&& webUtils.isElementDisplayed(evraValuationPerUnitHeader)
				&& webUtils.isElementDisplayed(evraCapRateHeader)
				&& webUtils.isElementDisplayed(confidenceIndicatorHeader);
	}
	
}
