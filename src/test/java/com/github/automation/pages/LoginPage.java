package com.github.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.geophy.utils.selenium.WebUtils;
import com.github.automation.core.BaseConfiguration;

public class LoginPage extends BaseConfiguration {
	
	@FindBy(css = ".visible-md.visible-lg #signInFormUsername")
	private WebElement emailInputBox;
	
	@FindBy(css = ".visible-md.visible-lg #signInFormPassword")
	private WebElement passwordInputBox;
	
	@FindBy(css = ".visible-md.visible-lg input[name='signInSubmitButton']")
	private WebElement signInButton;

	private WebUtils webUtils;

	public LoginPage() {
		webUtils = new WebUtils(driver);
	}
	
	public void login (String username, String password) {
		webUtils.waitForElementVisibility(passwordInputBox, 10);
		webUtils.enterText(emailInputBox, username);
		webUtils.enterText(passwordInputBox, password);
		webUtils.click(signInButton);
	}
	
	public void enterEmail(String username) {
		webUtils.waitForElementVisibility(emailInputBox, 10);
		webUtils.enterText(emailInputBox, username);
	}
	
	public void enterPassword(String password) {
		webUtils.waitForElementVisibility(passwordInputBox, 10);
		webUtils.enterText(passwordInputBox, password);
	}
	
	public void clickSignnInButton() {
		webUtils.click(signInButton);
	}


}
