
package com.jpmorgan.action;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.relevantcodes.extentreports.ExtentReports;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/featurefile/", tags = 
		"@Google" , plugin = { 
				"json:target/cucumber.json", "junit:target/cucumber.xml"
				 }, glue = { "com.jpmorgan" })

public class TestRunner {
	public static ExtentReports report;
	public static String reportName;
	@BeforeClass
	public static void beforeClass() {
		reportName = System.getProperty("user.dir")+"/target/test-report.html";
		report=new ExtentReports(reportName);
		
		File ScreenShotDir= new File(System.getProperty("user.dir")+"/src/test/resources/ExtendReportSnap/");
		for(File file:ScreenShotDir.listFiles()){
			file.delete();
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		System.setProperty("currentdate", dateFormat.format(new Date()));
		
	}

	@AfterClass
	public static void afterClass() {
		report.flush();
		

	}
	
	public static ExtentReports getExtentReport() {
		return report;
	}
    

}
