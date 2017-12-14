package stepDefinitions;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class EMBSUpdatePersonalDetailsStepDef {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	XSSFWorkbook workbook;
	String title;
	
	
	
	@Given("^User is logged in to EMBS application$")
	public void user_is_logged_in_to_EMBS_application() throws Throwable {
		   driver = BrowserFactory.getBrowser("Chrome");
		   driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	        driver.findElement(By.name("fusername")).sendKeys(DataProviderFactory.getExcel().getData(0, 0, 0));
	        driver.findElement(By.name("fpassword")).sendKeys(DataProviderFactory.getExcel().getData(0, 0, 1));
	        driver.findElement(By.name("login")).click();

	}

	@When("^I select Campus Code as City$")
	public void i_select_Campus_Code_as_City() throws Throwable {
		
		driver.findElement(By.linkText("My Personal Details")).click();
		//My Personal Details
		Select dropdown = new Select(driver.findElement(By.name("campus_id")));
		Thread.sleep(1000);
		
		dropdown.selectByVisibleText("other");
		
		//dropdown.selectByVisibleText(arg0);
		
		String value = dropdown.getAllSelectedOptions().get(0).getText();
		
		System.out.println("the value is     "+ value);
		
	}

	@When("^I click Update_User_Details$")
	public void i_click_Update_User_Details() throws Throwable {
		driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr/td[1]/input")).click();
		
		

	}

	@When("^I click Return_to_My_Account$")
	public void i_click_Return_to_My_Account() throws Throwable {
		driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr/td[5]/input")).click();
	}

	@When("^I click My_Personal_Details$")
	public void i_click_My_Personal_Details() throws Throwable {
		driver.findElement(By.linkText("My Personal Details")).click();

	}

	@Then("^I will be able to view Campus Code as City$")
	public void i_will_be_able_to_view_Campus_Code_as_City() throws Throwable {
		
		Select dropdown = new Select(driver.findElement(By.name("campus_id")));
		Thread.sleep(1000);
		
		String value = dropdown.getAllSelectedOptions().get(0).getText();
		
		System.out.println("the value is     "+ value);
		
		Assert.assertEquals("other", value);
		driver.close();

	}

	
}
