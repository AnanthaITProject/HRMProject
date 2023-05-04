package Hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
	
	private WebDriver driver;
	public TestBase testBase;
	
	@Before
	public void StartHrmApp() throws IOException {
		testBase = new TestBase();
		testBase.intializeDriver();
	}
	
	@After
	public void AfterScenario() {
		testBase.driver.quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			System.out.println("Screenshot of Failure TC");
			File Sourcepath = ((TakesScreenshot)testBase.driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(Sourcepath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}

}
