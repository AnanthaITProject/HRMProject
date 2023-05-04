package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {
	
	public WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	By userName = By.xpath("//input[@name='username']");
	By passWord = By.xpath("//input[@name='password']");
	By loginButton = By.xpath("//button[@type='submit']");
	By warning = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
	By logo = By.xpath("//img[@alt='company-branding']");
	By forgetPassword = By.xpath("/button[contains(text(),'Forgot your password')]");
	By resetPasswordButton = By.xpath("//button[@type='submit']");
	By resetPasswordMsg = By.cssSelector(".orangehrm-card-container p:nth-child(1)");
	
	public void keyInUsername(String username) {
		driver.findElement(userName).sendKeys(username);
	}
	
	public void keyInPassword(String password) {
		driver.findElement(passWord).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	
	public String warningText() {
		return driver.findElement(warning).getText();
	}
	
	public boolean isLogoDisplayed() {
		return driver.findElement(logo).isDisplayed();
	}
	
	public void clickForgetPassword() {
		WebElement forgotPassword = driver.findElement(forgetPassword);
		forgotPassword.isDisplayed();
		forgotPassword.click();
	}
	
	public void resetPasswordInput(String username) {
		driver.findElement(userName).sendKeys(username);
	}
	
	public void clickResetPasswordButton() {
		driver.findElement(resetPasswordButton).click();
	}
	
	public String getResetPasswordMsg() {
		return driver.findElements(resetPasswordMsg).get(0).getText();
	}

}
