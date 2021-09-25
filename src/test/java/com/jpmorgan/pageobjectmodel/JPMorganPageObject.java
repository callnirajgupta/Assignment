package com.jpmorgan.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.jpmorgan.utility.SeleniumUtil;

public class JPMorganPageObject {
	private static final Logger LOGGER = LogManager.getLogger(JPMorganPageObject.class);
	private static final String JPMORGAN_TITLE="J.P. Morgan | Official Website";
	private static final By JPMORGAN_LOGO=By.xpath("(//img[@alt='J.P. Morgan logo'])[2]");
	public static void validateJPmorganTitle() {
		LOGGER.info("Inside validateJPmorganTitle Method");

		Assert.assertEquals("The title does not match",JPMORGAN_TITLE, SeleniumUtil.getTitle());
		
	}
	
	public static void validateJPMorganLogo() {
		LOGGER.info("Inside validateJPMorganLogo Method");
		SeleniumUtil.validateWebElementVisible(JPMORGAN_LOGO);
		
	}
	
}
