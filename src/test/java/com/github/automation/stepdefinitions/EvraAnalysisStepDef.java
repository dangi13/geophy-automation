package com.github.automation.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.geophy.utils.common.Config;
import com.github.automation.pages.EvraHomePage;
import com.github.automation.pages.LoginPage;
import com.github.automation.pages.PropertyDueDiligencePage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EvraAnalysisStepDef {

	EvraHomePage evraHomePage;
	LoginPage loginPage;
	PropertyDueDiligencePage propertyDueDiligencePage;

	@Before
	public void setUp() {
		loginPage = new LoginPage();
		evraHomePage = new EvraHomePage();
		propertyDueDiligencePage = new PropertyDueDiligencePage();
	}

	
	@Given("Patrice Evra visits evra application")
	public void patrice_evra_visits_evra_application() {
		evraHomePage.launchUrl(Config.getProperty("APPLICATION_URL"));
	}

	@Given("Patrice clicks login button")
	public void patrice_clicks_login_button() {
		evraHomePage.openLoginForm();
	}

	@When("Submit username and password")
	public void submit_username_and_password() {
		loginPage.login(Config.getProperty("email"), Config.getProperty("password"));
	}

	@Then("Patrice see Property Search Bar on the home page")
	public void patrice_see_property_search_bar_on_the_home_page() {
		assertTrue(propertyDueDiligencePage.isSearchBarVisible());
	}


	@Then("user see tabs on the page header")
	public void user_see_tabs_on_the_page_header(io.cucumber.datatable.DataTable dataTable) {
		List<String> expectedTabsOnHeader = new ArrayList<String>(dataTable.asList(String.class));
		Collections.sort(expectedTabsOnHeader);
		List<String> actualTabsOnHeader = propertyDueDiligencePage.getHeaderTabNames();
		Collections.sort(actualTabsOnHeader);
		assertTrue(actualTabsOnHeader.equals(expectedTabsOnHeader));
	}
	
	@Then("Patrice see tabs on the page header")
	public void patrice_see_tabs_on_the_page_header(io.cucumber.datatable.DataTable dataTable) {
		List<String> expectedTabsOnHeader = new ArrayList<String>(dataTable.asList(String.class));
		Collections.sort(expectedTabsOnHeader);
		List<String> actualTabsOnHeader = propertyDueDiligencePage.getHeaderTabNames();
		Collections.sort(actualTabsOnHeader);
		assertTrue(actualTabsOnHeader.equals(expectedTabsOnHeader));
	}

	@When("he clicks View Sample Property link below Property search bar")
	public void he_clicks_view_sample_property_link_below_property_search_bar() {
	    propertyDueDiligencePage.openSampleProperty();
	}


@Then("he should be navigated to Evra analysis page and see tab Overview with subsections")
public void he_should_be_navigated_to_evra_analysis_page_and_see_tab_overview_with_subsections(io.cucumber.datatable.DataTable dataTable) {
	List<String> expectedSubSections = new ArrayList<String>(dataTable.asList(String.class));
	Collections.sort(expectedSubSections);
	List<String> actualSubSections = propertyDueDiligencePage.getAnalysisTabsSubSectionTitles();
	Collections.sort(actualSubSections);
	assertTrue(actualSubSections.equals(actualSubSections));
}


}
