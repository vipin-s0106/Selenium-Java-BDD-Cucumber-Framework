package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.WebDriverFactory;
import utils.Common;

public class SignUpPage {
	WebDriver wd;
	WebElement element;
	WebDriverFactory webdriverfactory;
	Common com;
	
	//*******************************************************************************************
	
	//Xpath for Element on Sign up Page
	
	public By xpath_firstname = By.xpath("//*[@id=\"headersignupform\"]/div[3]/input");
	public By xpath_lastname = By.xpath("//*[@id=\"headersignupform\"]/div[4]/input");
	public By xpath_mobile = By.xpath("//*[@id=\"headersignupform\"]/div[5]/input");
	public By xpath_email = By.xpath("//*[@id=\"headersignupform\"]/div[6]/input");
	public By xpath_password = By.xpath("//*[@id=\"headersignupform\"]/div[7]/input");
	public By xpath_cnfpassword = By.xpath("//*[@id=\"headersignupform\"]/div[8]/input");
	public By xpath_submit_button = By.xpath("//*[@id=\"headersignupform\"]/div[9]/button");
	
	//********************************************************************************************
	
	public SignUpPage(WebDriver wd){
		this.wd = wd;
		this.com = new Common(this.wd);
	}
	
	public void typeFirstName(String firstName) {
		com.type_xpath(firstName,xpath_firstname);
	}
	
	public void typeLastName(String lastname) {
		com.type_xpath(lastname, xpath_lastname);
	}
	
	public void typemobile(String mobile) {
		com.type_xpath(mobile,xpath_mobile);
	}
	
	public void typeEmail(String email) {
		com.type_xpath(email,xpath_email);
	}
	
	public void typePassword(String password) {
		com.type_xpath(password, xpath_password);
	}
	
	public void typeConfPassword(String cnfPass) {
		com.type_xpath(cnfPass, xpath_cnfpassword);
	}
	
	public void clickOnSubmit() {
		com.click_xpath(xpath_submit_button);
	}

}
