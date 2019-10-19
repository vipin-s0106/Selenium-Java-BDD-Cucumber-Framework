package po;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.WebDriverFactory;
import utils.Common;
import framework.Setting;

public class PHPHomepage {
	WebDriver wd;
	WebElement element;
	WebDriverFactory webdriverfactory;
	Common com;
	
	
	//Xpath LinkText
	private String my_account_link_text = "MY ACCOUNT";
	private String sign_up_link_text = "Sign Up";
	
	
	public PHPHomepage(WebDriver wd){
		this.wd = wd;
		this.com = new Common(this.wd);
	}
	
	public void openPHP_HomePage(String PHPTravel_URL) {
		PHPTravel_URL = new Setting().getApplicationUrl(PHPTravel_URL);
		com.openBrowser(PHPTravel_URL);
	}
	
	public void clickOnMyAccount() {
		wd.findElement(By.partialLinkText(this.my_account_link_text)).click();
	}
	public void clickOnsignUp() {
		wd.findElement(By.partialLinkText(this.sign_up_link_text)).click();
	}
}
