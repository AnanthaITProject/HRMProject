package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = { "stepDefinations",
		"Hooks" }, monochrome = true, tags = "@SmokeTest", plugin = { "html:target/cucumber.html",
				"json:target/cucmber-report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenario.txt" })

public class TestLoginRunner extends AbstractTestNGCucumberTests {

//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios(){
//		return super.scenarios();
//	}

}
