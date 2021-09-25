# Real Cube Automation

Add Url and users under src/test/resoureces/config/config.properties

Add featture file under /src/test/resoureces/featurefile/**.feature

Add locator and method for each page under /src/test/java/com.realcube.estate.arada.pageobjectmodel

Add Step definition under /src/test/java/com.realcube.estate.arada.stepdefinition

Add selenium related method under /src/test/java/com.realcube.estate.util/SeleniumUtil

How to run:

Update the browser name in config.properties under src/test/resoureces/config
 Example :Browser=firefox

If you are using Eclipse then go to  pakacge com.acdt.edu.action-->TestRunner.class and update the tag which you want to run it.
Tag can be found in feature file.

Then right click the TestRunner.class and click Run as -->Junit test

Or

Go to the project folder
you can go to cmd/terminal
 
navigate to project

type this: mvn clean install

IF youwant to override the Testrunner tag then pass from terminal 
Runing from Terminal/cmd with updated tag
mvn clean install -DCucumber.options="-t @Login"

BrowserDriver:

Drivers will download automatically.No need to download browser driver

Reports:
We are gererating three type of report1. Under Target folder 

1.-->cucumber-JVM-reporst-->overview-feature.html

Screen shot for each step

2.--->test-report.html 

updated




