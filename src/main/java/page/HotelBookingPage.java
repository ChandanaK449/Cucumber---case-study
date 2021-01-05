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
//	@FindBy(id = "userErrMsg")WebElement UserErrMsg;
//	@FindBy(id = "pwdErrMsg")WebElement PwdErrMsg;
	@FindBy(id ="txtFirstName")WebElement Firstname;
	@FindBy(id ="txtLastName")WebElement Lastname;
	@FindBy(id ="txtEmail")WebElement Email;
	@FindBy(name = "Phone")WebElement PhoneNo;
	@FindBy(xpath = "//textarea[@rows ='5']") WebElement Address;
	@FindBy(name = "city") WebElement City;	
	@FindBy(name = "state") WebElement State;
	@FindBy(name = "persons") WebElement NoOfPersons;
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
		
/*	public void emptyUsername() {
		loginBtn.click();
		System.out.println(UserErrMsg.getText());
		Assert.assertEquals("* Please enter userName.", UserErrMsg.getText());
	}
	public void emptyPassword() {
		Username.sendKeys("admin");
		loginBtn.click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(PwdErrMsg.getText());
		Assert.assertEquals("* Please enter password.", PwdErrMsg.getText());
	
	}
	*/
	
	public void Loggingin(String uname, String pwd) {
		Username.sendKeys(uname);
		Password.sendKeys(pwd);
		loginBtn.click();
		
	}
	
	public void Firstname(String Fname) {
		Firstname.sendKeys(Fname);
		
				
	}
	
	public void alerthandling() {
		paymentBtn.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message : "+ alert.getText());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		alert.accept();
	}
	
	public void Lastname(String Lname) {
		Lastname.sendKeys(Lname);
	}
	public void Email(String email) {
		Email.sendKeys(email);
		
	}
	public void PhoneNumber(String phone) {
		PhoneNo.sendKeys(phone);
		if(phone == null) {
			alerthandling();
		}else if(phone.length() < 10) {
			alerthandling();
			PhoneNo.clear();
		}
	}
	

	public void SelectCity() {
		Select selectedCity = new Select(City);
		WebElement SelectedCity = selectedCity.getFirstSelectedOption();
		//System.out.println(SelectedCity.getText());
		if(SelectedCity.getText().equals("Select City")) {
		alerthandling();
		}
		selectedCity.selectByValue(prop.getProperty("city"));
	}
	
	public void SelectState() {
		Select selectState = new Select(State);
		WebElement SelectedState = selectState.getFirstSelectedOption();
	//	System.out.println(SelectedState.getText());
		if(SelectedState.getText().equals("Select State")) {
		alerthandling();
		}
		selectState.selectByValue(prop.getProperty("State"));
	}
	
	public void NoOfGuests() {
		Select selectPersons = new Select(NoOfPersons);
		selectPersons.selectByIndex(5);
		WebElement SelectedPersons = selectPersons.getFirstSelectedOption();
		System.out.println("No.of guests staying is "+SelectedPersons.getText());
	}
	
	public void CardOwner(String Cname) {
		CardHolderName.sendKeys(Cname);
		if(Cname.equals("")) {
		alerthandling();
		}
	}
	
	public void CardNumber(String Cnumber) {
		CardNumber.sendKeys(Cnumber);
		if(Cnumber.equals("")) {
		alerthandling();
		}
	}
	
	public void CVVNumber(String cvv) {
		CVV.sendKeys(cvv);
		if(cvv.equals("")) {
		alerthandling();
		}
	}
	
	public void MonthOfExpiry(String month) {
		ExpMnth.sendKeys(month);
		if(month.equals("")) {
		alerthandling();
		}
	}
	
	public void YearOfExpiry(String Year) {
		ExpYear.sendKeys(Year);
		if(Year.equals("")) {
		alerthandling();
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
}
