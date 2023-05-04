package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getGloabalValues(String val) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/global.properties");
		prop.load(fis);
		return prop.getProperty(val);
	}

}
