package com.jpmorgan.pageobjectmodel;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.jpmorgan.stepdefinition.CommonStepDefinition;
import com.jpmorgan.utility.SeleniumUtil;

public class GoogleSearchPage {
	private static final Logger LOGGER = LogManager.getLogger(GoogleSearchPage.class);
	private static final String GOOGLE_TITLE="Google";
	private static final By SEARCH_INPUT = By.name("q");
	private static final By SEARCH_LIST=By.cssSelector("h3.LC20lb.DKV0Md");
	

	public static void validateGoogleSearchTitle() {
		LOGGER.info("Inside validateLoginTitle Method");
		Assert.assertEquals("The title does not match",GOOGLE_TITLE, SeleniumUtil.getTitle());
		
	}
	
	public static void searchText(String text) {
		LOGGER.info("Inside searchText Method");
		WebElement webelement=SeleniumUtil.getWebElement(SEARCH_INPUT);
		webelement.sendKeys(text);
		webelement.submit();
		
	}
	
	public static void clickSearchResult(int index) {
		LOGGER.info("Inside clickSearchResult Method");
		List<WebElement> searchResultList=SeleniumUtil.getWebElements(SEARCH_LIST);
		searchResultList.get(index).click();
	}

	
}
