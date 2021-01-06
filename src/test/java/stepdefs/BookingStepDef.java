package stepdefs;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;

import base.TestBase;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.HotelBookingPage;

public class BookingStepDef extends TestBase {
	
	HotelBookingPage loginpage1;
	
			
	@Given("^User is on the Login page$")
	public void user_is_on_the_Login_page() throws Throwable {
		TestBase.initialize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Given("^Title of the page$")
	public void title_of_the_page() throws Throwable {
			loginpage1= new HotelBookingPage();
			loginpage1.getPagetitle();		
	}

	@When("^Username is not sent$")
	public void username_is_not_sent() throws Throwable {
	  //  loginpage1.emptyUsername();
		loginpage1.Loggingin("", "");
	}

	@Then("^Validate the error thrown$")
	public void validate_the_error_thrown() throws Throwable {
		  WebElement UserErrmsg = driver.findElement(By.id("userErrMsg" ));
		
	}

	@When("^password is not sent$")
	public void password_is_not_sent() throws Throwable {
		//loginpage1.emptyPassword();
		loginpage1.Loggingin(prop.getProperty("username"), "" );
	}

	@Then("^Validate the error$")
	public void validate_the_error() throws Throwable {
		 WebElement PwdErrmsg = driver.findElement(By.id("pwdErrMsg" ));
		
	}
	
	@Then("^enter valid username and password$")
	public void enter_valid_username_and_password() throws Throwable {
		loginpage1 = new HotelBookingPage();
	    loginpage1.Loggingin(prop.getProperty("username"), prop.getProperty("password") );
	}
	

	@Then("^user login should be successful$")
	public void user_login_should_be_successful() throws Throwable {
		System.out.println("The title of the page is "+ driver.getTitle());
		Assert.assertEquals("Hotel Booking", driver.getTitle());
	    
	}
	
	@Then("^enter valid credentials$")
	public void enter_valid_credentials(DataTable arg) throws Throwable {
		loginpage1= new HotelBookingPage();
	    loginpage1.LoginDB(arg);
	}
	@Then("^Validate the error when first name is \"([^\"]*)\"$")
	public void validate_the_error_when_first_name_is(String arg1) throws Throwable {
		loginpage1= new HotelBookingPage();
		loginpage1.Firstname(arg1);
		loginpage1.alerthandling();
	}

	@Then("^confirm and verify if the booking is successful$")
	public void confirm_and_verify_if_the_booking_is_successful() throws Throwable {
		loginpage1.confirmbooking();
	    
	}
	
	@Then("^Enter the details in the Hotel Booking page$")
	public void enter_the_details_in_the_Hotel_Booking_page(DataTable ValidData) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   loginpage1.succesfulBooking(ValidData);
	}
	
	@After//("@closeDriver")
	public void teardown() {
		driver.close();
	}
	
	@Then("^Enter the details for Hotel Booking page$")
	public void enter_the_details_for_Hotel_Booking_page() throws Throwable {
	  loginpage1.Firstname(prop.getProperty("Firstname"));
	  loginpage1.Lastname(prop.getProperty("Lastname"));
	  loginpage1.Email(prop.getProperty("email"));
	  loginpage1.PhoneNumber(prop.getProperty("Phone"));
	  driver.findElement(By.xpath("//textarea[@rows ='5']")).sendKeys("Flat - 502, AR residency, Jublee hills");
	  loginpage1.SelectCity(prop.getProperty("city"));
	  loginpage1.SelectState(prop.getProperty("State"));
	  loginpage1.NoOfGuests(prop.getProperty("NumberofGuests"));
	  loginpage1.CardOwner(prop.getProperty("CardHolderName"));
	  loginpage1.CardNumber(prop.getProperty("CardNumber"));
	  loginpage1.CVVNumber(prop.getProperty("CVV"));
	  loginpage1.MonthOfExpiry(prop.getProperty("Expirymnth"));
	  loginpage1.YearOfExpiry(prop.getProperty("ExpiryYear"));
	}

	@After 
	public void afterScenario(Scenario scenario) throws IOException {
	Reporter.addScenarioLog("In case of Failure take Sceenshot");
		if(scenario.isFailed()) {
			String screenshotname = scenario.getName().replace(" ", "_");
			TakesScreenshot screen = (TakesScreenshot)driver;
			File srcpath = screen.getScreenshotAs(OutputType.FILE);
			File destpath = new File (System.getProperty("user.dir")+"//target//html//"+screenshotname+".png");
			//should add commons io dependency
			FileUtils.copyFile(srcpath,  destpath);
			Reporter.addScreenCaptureFromPath(destpath.toString());
		}
		
	}
}

