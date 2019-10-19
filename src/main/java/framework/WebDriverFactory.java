package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {
	public static WebDriver driver;
	String browserName;
	String environmentType;
	Setting set;
	public WebDriverFactory() {
		set =  new Setting();
		browserName = set.getBrowser();
		environmentType = set.getEnvironment();
	}
	
	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}
	
	private WebDriver createDriver() {
		   switch (environmentType.toLowerCase()) {	    
	        case "local" : driver = createLocalDriver();
	        	break;
	        case "remote" : driver = createRemoteDriver();
	        	break;
		   }
		   return driver;
	}
	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}
	
	private WebDriver createLocalDriver() {
        switch (browserName.toUpperCase()) {	    
        case "FIREFOX" : driver = new FirefoxDriver();
	    	break;
        case "CHROME" : 
        	System.setProperty("driver.chrome.webdriver", set.getDriverPath());
        	driver = new ChromeDriver();
    		break;
        case "INTERNETEXPLORER" : 
        	System.setProperty("driver.chrome.webdriver", set.getDriverPath());
        	driver = new InternetExplorerDriver();
    		break;
        }
		return driver;
	}	
	
	
}
