package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HotelBooking extends TestBase{

	@FindBy(name ="email") WebElement username;
	@FindBy(name ="password") WebElement password;
	@FindBy(xpath = "//div[@class= 'ui fluid large blue submit button']") WebElement loginbtn;
	
	//Actions
	public String getPagetitle() {
		return driver.getTitle();
	}
	//constructor should not have a return type 
	public HotelBooking() {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginbtn.click();
		
	}
}
