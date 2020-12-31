package page;



import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;


public class Login extends TestBase{
	
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
	public Login() {
		PageFactory.initElements(driver, this);
	}
	
	public void getPagetitle() {
		String pageTitle = LoginpageTitle.getText();
		System.out.println(pageTitle);
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
		if(Firstname == null) {
		paymentBtn.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message : "+ alert.getText());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		alert.accept();
		}
	}
	public void Lastname(String Lname) {
		Lastname.sendKeys(Lname);
		if(Lastname == null) {
		paymentBtn.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message : "+ alert.getText());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		alert.accept();
		}
	}
	public void Email(String email) {
		Email.sendKeys(email);
		if(email == null) {
		paymentBtn.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message : "+ alert.getText());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		alert.accept();
		}
	}
	public void PhoneNumber(String phone) {
		PhoneNo.sendKeys(phone);
		if(phone == null) {
		paymentBtn.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message : "+ alert.getText());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		alert.accept();
		}else if(phone.length() < 10) {
			paymentBtn.click();
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert message : "+ alert.getText());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			alert.accept();
			PhoneNo.clear();
		}
	}
	

	public void SelectCity() {
		Select selectedCity = new Select(City);
		WebElement SelectedCity = selectedCity.getFirstSelectedOption();
		System.out.println(SelectedCity.getText());
		if(SelectedCity.getText() == "Select City") {
		paymentBtn.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message : "+ alert.getText());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		alert.accept();
		}
		selectedCity.selectByValue("Hyderabad");
	}
	
	public void SelectState() {
		Select selectState = new Select(State);
		WebElement SelectedState = selectState.getFirstSelectedOption();
		System.out.println(SelectedState.getText());
		if(SelectedState.getText() == "Select City") {
		paymentBtn.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message : "+ alert.getText());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		alert.accept();
		}
		selectState.selectByValue("Telangana");
	}
	
	public void NoOfGuests() {
		Select selectPersons = new Select(NoOfPersons);
		selectPersons.selectByIndex(5);
		WebElement SelectedPersons = selectPersons.getFirstSelectedOption();
		System.out.println(SelectedPersons.getText());
	}
	
	public void CardOwner(String Cname) {
		CardHolderName.sendKeys(Cname);
		if(Cname == null) {
		paymentBtn.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message : "+ alert.getText());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		alert.accept();
		}
	}
	
	public void CardNumber(String Cnumber) {
		CardNumber.sendKeys(Cnumber);
		if(Cnumber == null) {
		paymentBtn.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message : "+ alert.getText());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		alert.accept();
		}
	}
	
	public void CVVNumber(String cvv) {
		CVV.sendKeys(cvv);
		if(cvv == null) {
		paymentBtn.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message : "+ alert.getText());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		alert.accept();
		}
	}
	
	public void MonthOfExpiry(String month) {
		ExpMnth.sendKeys(month);
		if(month == null) {
		paymentBtn.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message : "+ alert.getText());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		alert.accept();
		}
	}
	
	public void YearOfExpiry(String Year) {
		ExpYear.sendKeys(Year);
		if(Year == null) {
		paymentBtn.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message : "+ alert.getText());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		alert.accept();
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
	
}
