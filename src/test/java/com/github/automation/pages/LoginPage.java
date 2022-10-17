package com.github.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.geophy.utils.common.Config;
import com.geophy.utils.selenium.WebUtils;

public class LoginPage {
	
	@FindBy(css = ".visible-md.visible-lg #signInFormUsername")
	private WebElement emailInputBox;
	
	@FindBy(css = ".visible-md.visible-lg #signInFormPassword")
	private WebElement passwordInputBox;
	
	@FindBy(css = ".visible-md.visible-lg input[name='signInSubmitButton']")
	private WebElement signInButton;

	private WebUtils webUtils;

	public LoginPage(WebDriver driver) {
		webUtils = new WebUtils(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void login () {
		webUtils.enterText(emailInputBox, Config.getProperty("EVRA_EMAIL"));
		webUtils.enterText(passwordInputBox, System.getenv("EVRA_PASSWORD"));
		webUtils.click(signInButton);
	}
	
	public void enterEmail(String username) {
		webUtils.enterText(emailInputBox, username);
	}
	
	public void enterPassword(String password) {
		webUtils.enterText(passwordInputBox, password);
	}
	
	public void clickSignnInButton() {
		webUtils.click(signInButton);
	}


}
