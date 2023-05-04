package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	
	public WebDriver intializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/global.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver();
		}
		else if (browserName.contains("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("QAURL"));
		return driver;
		
	}

}
