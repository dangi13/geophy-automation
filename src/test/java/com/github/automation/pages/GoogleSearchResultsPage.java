package com.github.automation.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.automation.core.BaseConfiguration;

public class GoogleSearchResultsPage extends BaseConfiguration {

    @FindBy(xpath = "//h3[@class='LC20lb DKV0Md']")
    private List<WebElement> GoogleSearch_Results;

    public void getFirstGoogleSearchResult() {
        Assert.assertTrue("Couldn't fetch results", GoogleSearch_Results.size() > 0);
        System.out.println(GoogleSearch_Results.get(0).getText());
    }

}
