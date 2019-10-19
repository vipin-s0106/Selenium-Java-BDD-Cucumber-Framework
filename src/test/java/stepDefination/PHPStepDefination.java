package stepDefination;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.WebDriverFactory;
import po.PHPHomepage;
import po.SignUpPage;
import po.UserHomePage;
import utils.Common;
import utils.ExcelFactory;
import framework.Setting;

public class PHPStepDefination {
	PHPHomepage homepage;
	SignUpPage signuppage;
	UserHomePage userhomepage;
	Common com;
	WebDriver wd;
	WebDriverFactory wf;
	String OutputFolderPath;
	ExcelFactory excel_obj;
	ArrayList<String> coulmn_name_list;
	boolean folder_present_status;
	
	
	String firstname;
	String lastname;
	String mobile;
	String email;
	String Password;
	String Confirmpassword;
	
	
	public PHPStepDefination(){
		wf = new WebDriverFactory();
		this.wd = wf.getDriver();
		homepage = new PHPHomepage(wd);
		signuppage = new SignUpPage(wd);
		userhomepage = new UserHomePage(wd);
		com = new Common(wd);
		excel_obj = new ExcelFactory();
		folder_present_status = false;
	}
	
	@Given("^I naviagte to the \"([^\"]*)\" Home Page$")
	public void i_naviagte_to_the_Home_Page(String PHPTravel_URL) throws Throwable {
	    homepage.openPHP_HomePage(PHPTravel_URL);
	}

	@Given("^I wait for \"([^\"]*)\" second$")
	public void i_wait_for_second(String time) throws Throwable {
	    Thread.sleep((Integer.parseInt(time))*1000);
	}

	@Given("^I created the Excel Template with \"([^\"]*)\" Excel file name and \"([^\"]*)\" sheetname$")
	public void i_created_the_Excel_Template_with_Excel_file_name_and_sheetname(String filename, String sheetname) throws Throwable {
		coulmn_name_list = new ArrayList<>();
		coulmn_name_list.add("FirstName");
		coulmn_name_list.add("LastName");
		coulmn_name_list.add("Mobile");
		coulmn_name_list.add("Email");
		coulmn_name_list.add("Password");
		coulmn_name_list.add("Confirm Password");
		coulmn_name_list.add("Status");
	    excel_obj.create_Excel_Template(coulmn_name_list, sheetname, "C:\\Users\\vipin\\Desktop", filename);
	}
	
	@When("^I click on \"([^\"]*)\" Link$")
	public void i_click_on_Link(String MyAccount) throws Throwable {
	    homepage.clickOnMyAccount();
	}

	@Then("^I Click on \"([^\"]*)\" Link$")
	public void i_Click_on_Link(String SignUp) throws Throwable {
		homepage.clickOnsignUp();
	}

	@When("^I Entered Correct \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" ,\"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_Entered_Correct_and(String firstname, String lastname, String mobile, String email, String pass, String cnfpass) throws Throwable {
		signuppage.typeFirstName(firstname);
		signuppage.typeLastName(lastname);
		signuppage.typemobile(mobile);
		signuppage.typeEmail(email);
		signuppage.typePassword(pass);
		signuppage.typeConfPassword(cnfpass);
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobile = mobile;
		this.email = email;
		this.Password = pass;
		this.Confirmpassword = cnfpass;
		
	}

	@When("^Click on Submit button$")
	public void click_on_Submit_button() throws Throwable {
		signuppage.clickOnSubmit();
		Thread.sleep(2000);
	}

	@Then("^I Navigated to the User Home Page$")
	public void i_Navigated_to_the_User_Home_Page() throws Throwable {
	    System.out.println("Title of Home page : "+com.getTitle());
	}

	@Then("^I verified I logged or not$")
	public void i_verified_I_logged_or_not() throws Throwable {
		System.out.println(wd.getCurrentUrl());
	}
	
	@Then("^I logged the result into \"([^\"]*)\" excelfile with sheetname \"([^\"]*)\"$")
	public void i_logged_the_result_into_excelfile_with_sheetname(String Filename, String sheetname) throws Throwable {
		ArrayList<String> coulmn_name_list_values = new ArrayList<>();
		coulmn_name_list_values.add(firstname);
		coulmn_name_list_values.add(lastname);
		coulmn_name_list_values.add(mobile);
		coulmn_name_list_values.add(email);
		coulmn_name_list_values.add(Password);
		coulmn_name_list_values.add(Confirmpassword);
		coulmn_name_list_values.add("Passed");
		excel_obj.write_Excel_single_row(coulmn_name_list_values, sheetname, "C:\\Users\\vipin\\Desktop", Filename);
	}

	@Then("^I click on \"([^\"]*)\" link$")
	public void i_click_on_link(String user) throws Throwable {
		userhomepage.clickOnUserLink(user);
	}

	@Then("^I click on \"([^\"]*)\" button$")
	public void i_click_on_button(String arg1) throws Throwable {
		userhomepage.clickOnLogout();
	}

	@Then("^I should be logout from the page$")
	public void i_should_be_logout_from_the_page() throws Throwable {
	    System.out.println(com.getTitle());
	}

	@Then("^I close the Browser$")
	public void i_close_the_Browser() throws Throwable {
	    com.closeBrowser();
	}
	

	@Given("^I take Screenshot after navigating into the page$")
	public void i_take_Screenshot_after_navigating_into_the_page() throws Throwable {
		OutputFolderPath = new Setting().getOutputFolderPath();
		OutputFolderPath = OutputFolderPath+"\\Run_"+(LocalDateTime.now()).toString().replaceAll(":", ".");
		File f  = new File(OutputFolderPath);
		if (!f.exists() && this.folder_present_status == false) {
			f.mkdirs();
			this.folder_present_status = true;
		}
	    com.takeScreenShot("image", OutputFolderPath);
	}
	
	@When("^I take Screenshot before entering value$")
	public void i_take_Screenshot_before_entering_value() throws Throwable {
		com.takeScreenShot("image", OutputFolderPath);
	}
	
	@When("^I take Screenshot after entering value$")
	public void i_take_Screenshot_after_entering_value() throws Throwable {
		com.takeScreenShot("image", OutputFolderPath);
	}
	
	@Then("^I take Screenshot after loging$")
	public void i_take_Screenshot_after_loging() throws Throwable {
		com.takeScreenShot("image", OutputFolderPath);
	}
	
	@Then("^I take Screenshot(\\d+) after logout$")
	public void i_take_Screenshot_after_logout(int arg1) throws Throwable {
		com.takeScreenShot("image", OutputFolderPath);
	}
	
	
	//Perform After Each Scenario Outline Test Cases
	@After
	public void afterScenario(Scenario scenario) throws InterruptedException {
		if (scenario.isFailed()) {
			try {
				Reporter.addScreenCaptureFromPath(com.takeScreenShot("Failed_Image", new Setting().getOutputFolderPath()));
			} catch (IOException e) {
			} 
		}
		
		Thread.sleep(2000);
		com.closeBrowser();
	}
}
