package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src//main//resources//features//Hotelbookingfeature.feature",
		glue= {"stepdefs"},
		monochrome = true,
		strict = true,
		plugin = {"pretty", "com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"} 
		
		)

public class BookingRunner {
	
	@AfterClass
	public static void writeExtentReport(){
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") +"//src//test//resources//extent-config.xml"));
		
	}
	
}
