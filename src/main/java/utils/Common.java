package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import framework.Setting;
import framework.WebDriverFactory;
import java.time.LocalDateTime; 
public class Common {
	WebDriver wd;
	WebElement element;
	int var;
	boolean folder_present_status;
	
	public Common(WebDriver driver) {
		wd = driver;
		var = 1;
		folder_present_status = false;
	}
	
	public void openBrowser(String URL) {
		wd.get(URL);
		wd.manage().window().maximize();
    	wd.manage().timeouts().implicitlyWait(new Setting().getImplicitlyWait(), TimeUnit.SECONDS);
	}
	
	public void closeBrowser() {
		wd.quit();
	}
	
	public void type(String text,String identifier,String Attributevalue) {
		switch(identifier) {
			case "class":
				wd.findElement(By.xpath("//input[@class='"+Attributevalue+"']")).sendKeys(text);
				break;
			case "id":
				wd.findElement(By.xpath("//input[@id='"+Attributevalue+"']")).sendKeys(text);
				break;
			case "xpath":
				wd.findElement(By.xpath(Attributevalue)).sendKeys(text);
				break;
			case "text":
				wd.findElement(By.xpath("//input[text()='"+Attributevalue+"']")).sendKeys("text");
				break;
			default:
				wd.findElement(By.xpath("//input[@"+identifier+" = ['"+Attributevalue+"']")).sendKeys(text);
				break;
		}
	}
	
	public void click(String identifier,String Attributevalue) {
		switch(identifier) {
			case "class":
				wd.findElement(By.xpath("//*[@class='"+Attributevalue+"']")).click();
				break;
			case "id":
				wd.findElement(By.xpath("//*[@id='"+Attributevalue+"']")).click();
				break;
			case "xpath":
				wd.findElement(By.xpath(Attributevalue)).click();
				break;
			case "text":
				wd.findElement(By.xpath("//*[text()='"+Attributevalue+"']")).click();
				break;
			default:
				wd.findElement(By.xpath("//*[@"+identifier+"='"+Attributevalue+"']")).click();
				break;
		}
	}
	
	public String takeScreenShot(String FileName,String Path) throws IOException {
		// Take screenshot and store as a file format
		File src= ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		 // now copy the  screenshot to desired location using copyFile //method
		Path = Path+"\\"+FileName+""+var+".png";
		FileUtils.copyFile(src, new File(Path));
		var++;
		return  Path;
	}
	
	public String getTitle() {
		return wd.getCurrentUrl();
	}
	
	public void click_xpath(By attributevalue) {
		wd.findElement(attributevalue).click();
	}
	public void type_xpath(String text,By attributevalue) {
		wd.findElement(attributevalue).sendKeys(text);
	}
	
	public void rightClick() {
		
	}
	
	public void doubleClick() {
		
	}
	
	public boolean verfiyText() {
		return true;
		
	}
}
