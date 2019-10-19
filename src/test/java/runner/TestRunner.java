package runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import framework.*;
@RunWith(Cucumber.class)
@CucumberOptions(features= {"D:\\Programs\\Cucumber.PhP.Automation\\src\\test\\java\\Features\\login.feature"},
glue= {"stepDefination"},
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
)
public class TestRunner {	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new Setting().getExtentReportConfigPath());
	    Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 7" + " 32 Bit");
	    Reporter.setSystemInfo("Selenium", "3.7.0");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
}
