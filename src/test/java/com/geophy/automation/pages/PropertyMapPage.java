package com.geophy.automation.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.geophy.utils.selenium.WebUtils;

public class PropertyMapPage {
	
	@FindBy(css = "input[data-test=Units-minimum]")
	private WebElement unitsMinValueInputBox;
	
	@FindBy(css = "input[data-test=Units-maximum]")
	private WebElement unitsMaxValueInputBox;
	
	@FindBy(css = "input[data-test=YearBuilt-minimum]")
	private WebElement yearBuiltMinInputBox;
	
	@FindBy(css = "input[data-test=YearBuilt-maximum]")
	private WebElement yearBuiltMaxInputBox;
	
	@FindBy(css = "input[data-test=UrbanCore-checkbox]")
	private WebElement urbanCoreCheckbox;
	
	@FindBy(css = "input[data-test=InnerSuburb-checkbox]")
	private WebElement innerSuburbCheckbox;
	
	@FindBy(css = "tr[id^=listitem] td:nth-child(2)") // we can make it more Robust by using the 'Units' table header
	private List<WebElement> allUnitValues;
	
	@FindBy(css = "tr[id^=listitem] td:nth-child(2)")
	private WebElement firstUnitValue;
	
	@FindBy(css = "tr[id^=listitem] td:nth-child(3)")
	private List<WebElement> allYearBuiltValues;
	
	@FindBy(css = "tr[id^=listitem] td:nth-child(3)")
	private WebElement firstBuiltValue;
	
	@FindBy(css = "tr[id^=listitem] td:nth-child(7)")
	private List<WebElement> allNeighbourhoodValues;
	
	@FindBy(css = "tr[id^=listitem] td:nth-child(7)")
	private WebElement firstNeighbourhoodValue;
	

	private WebUtils webUtils;

	public PropertyMapPage(WebDriver driver) {
		webUtils = new WebUtils(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void enterMinMaxUnits (String minValue, String maxValue) {
		webUtils.enterText(unitsMinValueInputBox, minValue);
		webUtils.enterText(unitsMaxValueInputBox, maxValue);
		yearBuiltMinInputBox.click();
		webUtils.waitForElementVisibility(firstUnitValue);
	}
	
	public void enterMinMaxYearBuilt (String minValue, String maxValue) {
		webUtils.enterText(yearBuiltMinInputBox, minValue);
		webUtils.enterText(yearBuiltMaxInputBox, maxValue);
		unitsMaxValueInputBox.click();
		webUtils.waitForElementVisibility(firstBuiltValue);
	}
	
	public void selectUrbanCoreCheckbox () {
		webUtils.click(urbanCoreCheckbox);
		webUtils.waitForElementVisibility(firstNeighbourhoodValue);
	}

	public void selectInnerSuburbCheckbox () {
		webUtils.click(innerSuburbCheckbox);
		webUtils.waitForElementVisibility(firstNeighbourhoodValue);
	}
	
	public List<Integer> getAllUnits () {
		webUtils.waitForElementVisibility(allUnitValues.get(0));
		return allUnitValues.stream().
							filter(unit -> !unit.getAttribute("innerText").contains("-"))
							.map(unit -> Integer.valueOf(unit.getAttribute("innerText")))
							.collect(Collectors.toList());
		
	}
	
	public List<Integer> getAllBuildYears () {
		webUtils.waitForElementVisibility(allYearBuiltValues.get(0));
		return allYearBuiltValues.stream().
							filter(year -> !year.getAttribute("innerText").contains("-"))
							.map(year -> Integer.valueOf(year.getAttribute("innerText")))
							.collect(Collectors.toList());
		
	}
	
	public List<String> getAllNeighbourHoodValues () {
		webUtils.waitForElementVisibility(allNeighbourhoodValues.get(0));
		return allNeighbourhoodValues.stream().
							filter(unit -> !unit.getAttribute("innerText").contains("-"))
							.map(unit -> unit.getAttribute("innerText"))
							.collect(Collectors.toList());
		
	}

}
