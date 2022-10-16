package com.github.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.github.automation.core.BaseConfiguration;

public class GoogleSearchHomePage extends BaseConfiguration {

    @FindBy(how = How.XPATH, using = "//input[@title='Search']")
    private WebElement SearchBar;
    @FindBy(how = How.XPATH, using = "//div[@class='FPdoLc lJ9FBc']//input[@value='Google Search']")
    private WebElement GoogleSearch_Btn;

    public void launchUrl(String url) {
        driver.get(url);
    }

    public void entersTextInGoogleSearch(String searchText) {
        SearchBar.sendKeys(searchText);
    }

    public void clickOnGoogleSearchBtn() {
        GoogleSearch_Btn.click();
    }

}
