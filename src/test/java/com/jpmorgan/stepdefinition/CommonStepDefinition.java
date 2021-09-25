package com.jpmorgan.stepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.jpmorgan.action.TestRunner;
import com.jpmorgan.pageobjectmodel.GoogleSearchPage;
import com.jpmorgan.utility.SeleniumUtil;
import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;



public class CommonStepDefinition {
	
	private static final Logger LOGGER = LogManager.getLogger(CommonStepDefinition.class);
	public static Scenario scenario;
	private static String scenarioName;
	public static ExtentTest extenttest;
	public WebDriver driver=null;
	

	@Before()
	public void Setup(Scenario scenario) {
		LOGGER.info("Inside Setup method");
		extenttest = TestRunner.getExtentReport().startTest(scenario.getName());
		CommonStepDefinition.scenario=scenario;
		scenarioName=scenario.getName();
		SeleniumUtil.getInstance();
	}
	
	@Given("^user navigates to Google search page$")
	public void navigateToGoogleSearch() throws Throwable {
		LOGGER.info("user navigates to Google search page");
			SeleniumUtil.getDriver();
			SeleniumUtil.maximizeBrowser();
		SeleniumUtil.launchApplication(SeleniumUtil.getConfigProperties().getProperty("Url"));
		SeleniumUtil.ImplicitWait();
		
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "google search page loaded successfully");
		GoogleSearchPage.validateGoogleSearchTitle();
	}
	
	
	@After()
	public void TearDown(Scenario scenario) {
		LOGGER.info("Inside Teardown method");

		if (scenario.isFailed()) {
			LOGGER.debug("###################  Inside screen shot after fail ####################");
			final byte[] screenshot = ((TakesScreenshot) SeleniumUtil.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenarioName);
			//scenario.embed(screenshot, "image/png");
			
			SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "The Step is failed");

		}
		if (SeleniumUtil.getDriver() != null) {
			
			SeleniumUtil.closeBrowser();
			SeleniumUtil.setDriver(null);
			SeleniumUtil.driverStatus=false;
		}
		
	}
	
	public static ExtentTest getExtentTest() {
		return extenttest;
	}
	
	 public static String getScenarioName() {
			return scenarioName;
		}
}
