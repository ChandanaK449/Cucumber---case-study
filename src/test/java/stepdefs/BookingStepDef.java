package stepdefs;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.TestBase;
import cucumber.api.DataTable;
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
		  System.out.println(UserErrmsg.getText());
		  boolean UsernameErr = UserErrmsg.isDisplayed();
	      Assert.assertTrue(UsernameErr);
	}

	@When("^password is not sent$")
	public void password_is_not_sent() throws Throwable {
		//loginpage1.emptyPassword();
		loginpage1.Loggingin(prop.getProperty("username"), "" );
	}

	@Then("^Validate the error$")
	public void validate_the_error() throws Throwable {
		 WebElement PwdErrmsg = driver.findElement(By.id("pwdErrMsg" ));
		  System.out.println(PwdErrmsg.getText());
		boolean PasswordErr = PwdErrmsg.isDisplayed();
	      Assert.assertTrue(PasswordErr);
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
	
	@Then("^Validate the error when first name is \"([^\"]*)\"$")
	public void validate_the_error_when_first_name_is(String arg1) throws Throwable {
		loginpage1= new HotelBookingPage();
		loginpage1.Firstname(arg1);
		loginpage1.alerthandling();
	}
	
	
	@Then("^Enter the firstname$")
	public void enter_the_firstname() throws Throwable {
		loginpage1.Firstname(prop.getProperty("Firstname"));
	}

	@Then("^validate the error when Last name is empty$")
	public void validate_the_error_when_Last_name_is_empty() throws Throwable {
		loginpage1= new HotelBookingPage();
		loginpage1.alerthandling();
	}

	@Then("^Enter the Last name$")
	public void enter_the_Last_name() throws Throwable {
	   loginpage1.Lastname(prop.getProperty("Lastname"));
	}

	@Then("^Validate the error when email is not entered$")
	public void validate_the_error_when_email_is_not_entered() throws Throwable {
		loginpage1.alerthandling();
	    System.out.println(prop.getProperty("email"));
	}

	@Then("^enter a valid Email$")
	public void enter_a_valid_Email() throws Throwable {
		loginpage1.Email(prop.getProperty("email"));
		
	}
	
	

	@After//("@closeDriver")
	public void teardown() {
		driver.close();
	}
	
	@Then("^Validate the error when phone is not entered$")
	public void validate_the_error_when_phone_is_not_entered() throws Throwable {
	   loginpage1.PhoneNumber("");
	}

	@Then("^Validate the error message when phone number is invalid$")
	public void validate_the_error_message_when_phone_number_is_invalid() throws Throwable {
		loginpage1.PhoneNumber("78974544");
	}

	@Then("^enter a valid phone$")
	public void enter_a_valid_phone() throws Throwable {
		loginpage1.PhoneNumber(prop.getProperty("Phone"));
	}

	@Then("^Enter Address$")
	public void enter_Address() throws Throwable {
			driver.findElement(By.xpath("//textarea[@rows ='5']")).sendKeys("Flat - 502, AR residency, Jublee hills");
	}

	@When("^City is not selected throw error and select a city from the list$")
	public void city_is_not_selected_throw_error_and_select_a_city_from_the_list() throws Throwable {
	   loginpage1.SelectCity();
	}

	@When("^State is not selected throw error and select a State from the list$")
	public void state_is_not_selected_throw_error_and_select_a_State_from_the_list() throws Throwable {
	   loginpage1.SelectState();
	}	

	@Then("^Enter the number of persons staying at the hotel$")
	public void enter_the_number_of_persons_staying_at_the_hotel() throws Throwable {
	  loginpage1.NoOfGuests();
	}

	@When("^Card holder name is not entered validate the error thrown$")
	public void card_holder_name_is_not_entered_validate_the_error_thrown() throws Throwable {
	 loginpage1.CardOwner("");  
	}

	@Then("^Enter the card holder name$")
	public void enter_the_card_holder_name() throws Throwable {
		System.out.println(prop.getProperty("CardHolderName"));
		loginpage1.CardOwner(prop.getProperty("CardHolderName")); 
		
	}

	@When("^debit card number is not entered validate the error thrown$")
	public void debit_card_number_is_not_entered_validate_the_error_thrown() throws Throwable {
		loginpage1.CardNumber("");
	}

	@Then("^Enter the debit card number$")
	public void enter_the_debit_card_number() throws Throwable {
	  loginpage1.CardNumber(prop.getProperty("CardNumber"));
	}

	@When("^CVV is not entered validate the error thrown$")
	public void cvv_is_not_entered_validate_the_error_thrown() throws Throwable {
	    loginpage1.CVVNumber("");
	}

	@Then("^Enter the cvv$")
	public void enter_the_cvv() throws Throwable {
	    loginpage1.CVVNumber(prop.getProperty("CVV"));
	}

	@When("^Expiration month is not entered validate the error thrown$")
	public void expiration_month_is_not_entered_validate_the_error_thrown() throws Throwable {
	  loginpage1.MonthOfExpiry("");
	}

	@Then("^Enter the Expiration month$")
	public void enter_the_Expiration_month() throws Throwable {
	   loginpage1.MonthOfExpiry(prop.getProperty("Expirymnth"));
	}

	@When("^Expiration year is not entered validate the error thrown$")
	public void expiration_year_is_not_entered_validate_the_error_thrown() throws Throwable {
	   loginpage1.YearOfExpiry("");
	}

	@Then("^Enter the Expiration year$")
	public void enter_the_Expiration_year() throws Throwable {
	   loginpage1.YearOfExpiry(prop.getProperty("ExpiryYear"));
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
	
}

