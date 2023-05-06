package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import PageObject.LoginPageObject;
import Utils.GenericUtils;
import Utils.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefination {
	
	public WebDriver driver;
	public LoginPageObject lp;
	public GenericUtils utils; 
	
	@Given("^User is on OrangeHRM login page$")
    public void user_is_on_orangehrm_login_page() throws Throwable {
		System.out.println("Starting HRM Application");
		
    }

    @When("^User enter (.+) and (.+)$")
    public void user_enter_and(String username, String password) throws Throwable {
    	lp = new LoginPageObject(TestBase.driver);
    	lp.keyInUsername(username);
    	lp.keyInPassword(password);
    	lp.clickLogin();
    }
    
    @Then("^Validate login (.+) in the login page$")
    public void validate_login_in_the_login_page(String message) throws Throwable {
    	utils = new GenericUtils(TestBase.driver);
    	String GlobalUrl = utils.getGloabalValues("QAURL");
    	if (GlobalUrl.equals(utils.getUrl())) {
    		Assert.assertTrue(message.equals(lp.warningText()));
		}
    }
    
    @Then("^Validate HRM Logo is displayed$")
    public void validate_hrm_logo_is_displayed() throws Throwable {
    	lp = new LoginPageObject(TestBase.driver);
    	Thread.sleep(2000);
    	Assert.assertTrue(lp.isLogoDisplayed());
    }
    
    @Then("^Validate forgot your password is clickable$")
    public void validate_forgot_your_password_is_clickable() throws Throwable {
    	lp = new LoginPageObject(TestBase.driver);
    	Thread.sleep(2000);
    	lp.clickForgetPassword();
    }
    
    @When("^Click on find your password button and input \"([^\"]*)\"$")
    public void click_on_find_your_password_button_and_input(String email) throws Throwable {
    	lp = new LoginPageObject(TestBase.driver);
    	lp.clickForgetPassword();
    	lp.resetPasswordInput(email);
    	lp.clickResetPasswordButton();
    }

    @Then("^Validate confirmation \"([^\"]*)\" message$")
    public void validate_confirmation_something_message(String msg) throws Throwable {
        System.out.println(lp.getResetPasswordMsg());
        System.out.println(msg);
    	Assert.assertTrue(msg.equals(lp.getResetPasswordMsg()));
    }

}
