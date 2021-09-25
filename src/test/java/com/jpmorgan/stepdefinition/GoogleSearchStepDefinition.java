package com.jpmorgan.stepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jpmorgan.pageobjectmodel.GoogleSearchPage;
import com.jpmorgan.pageobjectmodel.JPMorganPageObject;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(GoogleSearchStepDefinition.class);
	
	@When("^user search for \"([^\"]*)\" in Google search page$")
	public void userSearchInGooglepage(String text) {
		LOGGER.info("Inside userSearchInGooglepage step");
		GoogleSearchPage.searchText(text);
		
	}
	
	@And("^user click the first result returned by Google$")
	public void userClickSearchResult() {
		LOGGER.info("Inside userClickSearchResult step");
		GoogleSearchPage.clickSearchResult(0);
		
	}
	
	@Then("^verify that the J.P. Morgan logo is displayed$")
	public void verifyJPMorganLogo() {
		JPMorganPageObject.validateJPmorganTitle();
		JPMorganPageObject.validateJPMorganLogo();
		
	}
}
