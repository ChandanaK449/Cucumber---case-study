package page;



import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import cucumber.api.DataTable;


public class HotelBookingPage extends TestBase{
	
	
	@FindBy(name = "userName")WebElement Username;
	@FindBy(name  = "userPwd")WebElement Password;
	@FindBy(xpath ="//input [@value ='Login']")WebElement loginBtn;
	@FindBy(xpath = "//h1[@align = \"center\"]") WebElement LoginpageTitle;
	@FindBy(id = "userErrMsg")WebElement UserErrMsg;
	@FindBy(id = "pwdErrMsg")WebElement PwdErrMsg;
	@FindBy(id ="txtFirstName")WebElement Firstname;
	@FindBy(id ="txtLastName")WebElement Lastname;
	@FindBy(id ="txtEmail")WebElement Email;
	@FindBy(name = "Phone")WebElement PhoneNo;
	@FindBy(xpath = "//textarea[@rows ='5']") WebElement Address;
	@FindBy(name = "city") WebElement City;	
	@FindBy(name = "state") WebElement State;
	@FindBy(name = "persons") WebElement NoOfPersons;
	@FindBy(id = "rooms") WebElement NoOfRooms;
	@FindBy(xpath = "//input[@id ='txtCardholderName']")WebElement CardHolderName;
	@FindBy(name = "debit") WebElement CardNumber;
	@FindBy(name = "cvv") WebElement CVV;
	@FindBy(name = "month") WebElement ExpMnth;
	@FindBy(name = "year") WebElement ExpYear;
	@FindBy(id ="btnPayment")WebElement paymentBtn;
	@FindBy(xpath = "//h1[contains(text(), \"Booking Completed\")]") WebElement cnfrmMsg;	
	
	
	//Actions
	public HotelBookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void getPagetitle() {
		String pageTitle = LoginpageTitle.getText();
		System.out.println("the tile of the page is " +pageTitle);
		Assert.assertEquals("Hotel Booking Application" , pageTitle);		
	}
		

	public void Loggingin(String uname, String pwd) {
		Username.sendKeys(uname);
		Password.sendKeys(pwd);
		loginBtn.click();
		if (uname.equals("")) {
			System.out.println(UserErrMsg.getText());
			 boolean UsernameErr = UserErrMsg.isDisplayed();
		     Assert.assertTrue(UsernameErr);
		}else
		if(pwd.equals("")) {
			System.out.println(PwdErrMsg.getText());
			boolean PasswordErr = PwdErrMsg.isDisplayed();
			Assert.assertTrue(PasswordErr);
		}		
	}
	
	public void Firstname(String Fname) {
		Firstname.sendKeys(Fname);	
		if(Fname.equals("")) {
			paymentBtn.click();
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert message : "+ alert.getText());
			Assert.assertEquals("Please fill the First Name", alert.getText());
		}
	}
	
	public void alerthandling() {
		Alert alert = driver.switchTo().alert();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		alert.accept();
	}
	
	public void Lastname(String Lname) {
		Lastname.sendKeys(Lname);
		if(Lname.equals("")) {
		paymentBtn.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message : "+ alert.getText());
		Assert.assertEquals("Please fill the Last Name", alert.getText());
		}
	}
	public void Email(String email) {
		Email.sendKeys(email);
		if(email.equals("")) {
			paymentBtn.click();
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert message : "+ alert.getText());
			Assert.assertEquals("Please fill the Email", alert.getText());
			}
		
	}
	public void PhoneNumber(String phone) {
		PhoneNo.clear();
		PhoneNo.sendKeys(phone);		
		if(phone .equals("")) {
			paymentBtn.click();
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert message : "+ alert.getText());
			Assert.assertEquals("Please fill the Mobile No.", alert.getText());
			
		}else {		
		char ch1 = phone.charAt(0);
		//System.out.println(ch1);
		if((phone.length() != 10 )|| (ch1!='7' && ch1!='8' && ch1!='9')) {
			paymentBtn.click();
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert message : "+ alert.getText());
			Assert.assertEquals("Please enter valid Contact no.", alert.getText());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		}
		
	}
	
	public void SelectCity(String CITY) {
		Select selectedCity = new Select(City);
		if (CITY.equals("")) {
			paymentBtn.click();
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert message : "+ alert.getText());
			Assert.assertEquals("Please select city", alert.getText());		
		}else {
		selectedCity.selectByValue(CITY);
//		WebElement SelectedCity = selectedCity.getFirstSelectedOption();
//		System.out.println(SelectedCity.getText());
		}
	}
	

	
	public void SelectState(String STATE) {
		Select selectState = new Select(State);
		if(STATE.equals("")) {
			paymentBtn.click();
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert message : "+ alert.getText());
			Assert.assertEquals("Please select state", alert.getText());
			
		}else {
		selectState.selectByValue(STATE);
	//	WebElement SelectedState = selectState.getFirstSelectedOption();		
	//	System.out.println(SelectedState.getText());
		}
		
	}
	
	public void NoOfGuests(String NG) {
		if(NG.equals("")) {
		Select selectPersons = new Select(NoOfPersons);
		WebElement SelectedPersons = selectPersons.getFirstSelectedOption();
		System.out.println("No.of guests staying is "+SelectedPersons.getText());
	}else {
		Select selectPersons = new Select(NoOfPersons);
		selectPersons.selectByValue(NG);
		WebElement SelectedPersons = selectPersons.getFirstSelectedOption();
		System.out.println("No.of guests staying is "+SelectedPersons.getText());
		}
		System.out.println("No.of rooms booked =" +NoOfRooms.getText());
	}
	
	public void CardOwner(String Cname) {
		CardHolderName.sendKeys(Cname);
		if(Cname.equals("")) {
			paymentBtn.click();
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert message : "+ alert.getText());
			Assert.assertEquals("Please fill the Card holder name", alert.getText());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}
	}
	
	public void CardNumber(String Cnumber) {
		CardNumber.sendKeys(Cnumber);
		if(Cnumber.equals("")) {
			paymentBtn.click();
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert message : "+ alert.getText());
			Assert.assertEquals("Please fill the Debit card Number", alert.getText());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	
	public void CVVNumber(String cvv) {
		CVV.sendKeys(cvv);
		if(cvv.equals("")) {
			paymentBtn.click();
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert message : "+ alert.getText());
			Assert.assertEquals("Please fill the CVV", alert.getText());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	
	public void MonthOfExpiry(String month) {
		ExpMnth.sendKeys(month);
		if(month.equals("")) {
			paymentBtn.click();
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert message : "+ alert.getText());
			Assert.assertEquals("Please fill expiration month", alert.getText());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	
	public void YearOfExpiry(String Year) {
		ExpYear.sendKeys(Year);
		if(Year.equals("")) {
			paymentBtn.click();
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert message : "+ alert.getText());
			Assert.assertEquals("Please fill the expiration year", alert.getText());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	
	public boolean confirmbooking() {
		paymentBtn.click();
		boolean check = cnfrmMsg.isDisplayed();
		String SucessMessage = cnfrmMsg.getText();
		System.out.println(SucessMessage);		
		Assert.assertEquals("Booking Completed!" , SucessMessage);
		return check;
	}
	
	public void succesfulBooking(DataTable userData) throws Throwable {
		List<Map<String, String>> data = userData.asMaps(String.class, String.class);
		Firstname.sendKeys(data.get(0).get("Firstname"));
		Lastname.sendKeys(data.get(0).get("Lastname"));
		Email.sendKeys(data.get(0).get("email"));
		PhoneNo.sendKeys(data.get(0).get("phone"));
		Address.sendKeys("Flat - 502, AR residency, Jublee hills");
		Select selectedCity = new Select(City);
		WebElement SelectedCity = selectedCity.getFirstSelectedOption();
		selectedCity.selectByValue(data.get(0).get("City"));
		Select selectState = new Select(State);
		WebElement SelectedState = selectState.getFirstSelectedOption();
		selectState.selectByValue(data.get(0).get("state"));
		NoOfPersons.sendKeys(data.get(0).get("NoOfGuests"));
		CardHolderName.sendKeys(data.get(0).get("CHname"));
		CardNumber.sendKeys(data.get(0).get("CardNumber"));
		CVV.sendKeys(data.get(0).get("CVV"));
		ExpMnth.sendKeys(data.get(0).get("Expmnth"));
		ExpYear.sendKeys(data.get(0).get("ExpYear"));		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	

	public void LoginDB(DataTable userCred) {
		List<List<String>> data =userCred.raw();
		Username.sendKeys(data.get(0).get(0));
		Password.sendKeys(data.get(0).get(1));
		loginBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	
}
