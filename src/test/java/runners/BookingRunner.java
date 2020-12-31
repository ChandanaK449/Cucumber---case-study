package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src//main//resources//features//CaseStudyLogin.feature",
		glue= {"stepdefs"},
		monochrome = true,
		plugin = {"pretty", "com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"} 
		
		)

public class BookingRunner {
	
}
