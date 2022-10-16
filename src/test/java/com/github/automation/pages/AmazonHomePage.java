package com.github.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.geophy.utils.selenium.WebUtils;
import com.github.automation.core.BaseConfiguration;

public class AmazonHomePage extends BaseConfiguration {

	@FindBy(id = "twotabsearchtextbox")
	private WebElement AmazonSearch;
	
	@FindBy(xpath = "//input[@value='Go']")
	private WebElement AmazonSearchBtn;

	private WebUtils webUtils;

	public AmazonHomePage() {
		webUtils = new WebUtils(driver);
	}

	public void launchUrl(String url) {
		webUtils.navigateToURL(url);
	}

	public void searchProductsOnAmazon(String productName) {
		webUtils.enterText(AmazonSearch, productName);
		webUtils.click(AmazonSearchBtn);
	}

}
