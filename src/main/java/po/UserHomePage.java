package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.WebDriverFactory;
import utils.Common;

public class UserHomePage {
	WebDriver wd;
	WebElement element;
	WebDriverFactory webdriverfactory;
	Common com;
	
	public UserHomePage(WebDriver wd){
		this.wd = wd;
		this.com = new Common(this.wd);
	}
	
	public void clickOnUserLink(String User) {
		wd.findElement(By.linkText(User.toUpperCase())).click();
	}
	public void clickOnLogout() {
		wd.findElement(By.partialLinkText("Logout")).click();
	}
}
