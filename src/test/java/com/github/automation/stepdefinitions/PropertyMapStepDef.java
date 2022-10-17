package com.github.automation.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.github.automation.pages.EvraHomePage;
import com.github.automation.pages.InsightsPortalPage;
import com.github.automation.pages.LoginPage;
import com.github.automation.pages.PropertyDueDiligencePage;
import com.github.automation.pages.PropertyMapPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PropertyMapStepDef {

	EvraHomePage evraHomePage;
	LoginPage loginPage;
	PropertyDueDiligencePage propertyDueDiligencePage;
	PropertyMapPage propertyMapPage;
	InsightsPortalPage insightsPortalPage;

	@Before
	public void setUp() {
		loginPage = new LoginPage(BaseStep.getDriver());
		evraHomePage = new EvraHomePage(BaseStep.getDriver());
		propertyMapPage = new PropertyMapPage(BaseStep.getDriver());
		insightsPortalPage = new InsightsPortalPage(BaseStep.getDriver());
	}

	@Given("Patrice is already logged in")
	public void patrice_is_already_logged_in() {
		evraHomePage.openLoginForm();
		loginPage.login();
	}

	@Given("Patrice is on Property Map screen")
	public void patrice_is_on_property_map_screen() {
		evraHomePage.openPropertyMapTab();
	}

	@Given("he filter by units with minValue {string} maxValue {string}")
	public void he_filter_by_units_with_min_value_max_value(String minUnit, String maxUnit) {
		propertyMapPage.enterMinMaxUnits(minUnit, maxUnit);
	}

	@Then("Patrice see all resulted properties have Units in the range provided")
	public void patrice_see_all_resulted_properties_have_units_in_the_range_provided() {
		List<Integer> allFilteredUnits = propertyMapPage.getAllUnits();
		System.out.println("ALL FILTERED UNITS" + allFilteredUnits);
	}

	@Given("he filter by Year Built with minValue {string} maxValue {string}")
	public void he_filter_by_year_built_with_min_value_max_value(String minYear, String maxYear) {
		propertyMapPage.enterMinMaxYearBuilt(minYear, maxYear);
	}

	@Then("Patrice see all resulted properties have Year Built in the range provided")
	public void patrice_see_all_resulted_properties_have_year_built_in_the_range_provided() {
		List<Integer> allFilteredBuiltYears = propertyMapPage.getAllBuildYears();
		System.out.println("ALL FILTERED YEARS" + allFilteredBuiltYears);
	}

	@Given("he filter by Neighborhood Type with Urban Core and Inner Suburb")
	public void he_filter_by_neighborhood_type_with_and() {
		propertyMapPage.selectUrbanCoreCheckbox();
		propertyMapPage.selectInnerSuburbCheckbox();
	}

	@Then("Patrice see all resulted properties have Neighborhood Type that he selected")
	public void patrice_see_all_resulted_properties_have_neighborhood_type_that_he_selected() {
		List<String> allFilteredNeighbourHoods = propertyMapPage.getAllNeighbourHoodValues();
		System.out.println("ALL FILTERED NEIGHBOURHOODS" + allFilteredNeighbourHoods);
	}
	
	@Given("Patrice is on Insights Portal screen")
	public void patriceIsOnInsightsPortalScreen() {
		evraHomePage.openInsightsPortalTab();
	}
	@Given("he sees heading on page [Customize Evra insights for your needs]")
	public void heSeesHeadingOnPageCustomizeEvraInsightsForYourNeeds() {
		assertTrue(insightsPortalPage.isInsightCustomizeHeaderPresent());
	}
	@Given("he see a blue button with text [GET IN TOUCH]")
	public void heSeeABlueButtonWithTextGETINTOUCH() {
		assertTrue(insightsPortalPage.isGetInTouchButtonPresent());
	}
	@Given("this button has link to email {string}")
	public void thisButtonHasLinkToEmail(String email) {
		assertEquals(insightsPortalPage.getEmailLinkFromGetinTouchButton(), email);
	}
}
