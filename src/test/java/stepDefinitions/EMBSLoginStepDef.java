package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Sleeper;

import com.cucumber.listener.Reporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ExcelDataProvider;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import junit.framework.Assert;
//import utility.Utility;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class EMBSLoginStepDef {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	XSSFWorkbook workbook;
	String title;
	
	

	
	@Given("^I access the EMBS _application URL$")
	public void i_access_the_EMBS__application_URL() throws Throwable {
		   driver = BrowserFactory.getBrowser("Chrome");
		   driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}

	
	
	@SuppressWarnings("deprecation")
	@Then("^I will see page title$")
	public void i_will_see_page_title() throws Throwable {
		Reporter.addStepLog("Test case is for Title testing");
        title = driver.getTitle();
        Assert.assertEquals("RMMF booking system", title);
		driver.close();
	}
	
	
// Enter valid username and password
	
	@When("^I enter correct RMIT_ID and Password$")
	public void i_enter_correct_RMIT_ID_and_Password() throws Throwable {
        driver.findElement(By.name("fusername")).sendKeys(DataProviderFactory.getExcel().getData(0, 0, 0));
        driver.findElement(By.name("fpassword")).sendKeys(DataProviderFactory.getExcel().getData(0, 0, 1));
        }
	
	
	@When("^I click Login_to_Bookings$")
	public void i_click_Login_to_Bookings() throws Throwable {
		driver.findElement(By. name("login")).click();
		//driver.findElement(By.className("blue")).click();
	}
	
	
	@SuppressWarnings("deprecation")
	@Then("^I will be redirected to the EMBS_Main_Menu$")
	public void i_will_be_redirected_to_the_EMBS_Main_Menu() throws Throwable {
		//Reporter.addStepLog("Test case is for Title testing");
        //title = driver.getTitle();
        
        String chkPage = driver.findElement(By.linkText("My Personal Details")).getText() ;
        
    //   String chkPage1 = driver.findElement(By.className("blue")).
        
        System.out.println("the chkpage text is   " + chkPage);
        
        Assert.assertEquals("My Personal Details", chkPage);
		driver.close();
		
		//RMMF booking system 
	}
	
	
	@SuppressWarnings("deprecation")
	@Then("^User should be able to login Successfully$")
	public void user_should_be_able_to_login_Successfully() throws Throwable {
		
		String title=driver.getTitle(); 
		
		System.out.println("pgs tile page log in   "+ title );

		
		
	//	if (title != "Program Guides Main Menu")
			if (driver.getTitle() == "Program Guides Main Menu" )	
				{
			
			//String screenshotPath = 
			getscreenshot();
			//Utility.takeSnapShot(driver, title);
			Reporter.addScreenCaptureFromPath("C:\\eclipse\\29112017\\RMIT.LTR\\Screenshots\\screenshottest.png");
			//Assert.assertTrue(title.contains("Program Guides Main Menu"));
			//Assert.assertEquals(title, "Program Guides Main Menu");
			
			}
		else
				{
			Reporter.addStepLog("Successfully logged in");
			
			//Reporter.addScreenCaptureFromPath("C:\\eclipse\\xyz.png");
				}; 
			 
		
	
		//String screenshotPath = Utility.takeSnapShot(driver, result.getName());
		
		driver.close();
		

	}
	
	

	//invalid username and password
	@When("^I enter incorrect RMIT_ID and Password$")
	public void i_enter_incorrect_RMIT_ID_and_Password() throws Throwable {
	       driver.findElement(By.name("fusername")).sendKeys(DataProviderFactory.getExcel().getData(1, 0, 0));
	        driver.findElement(By.name("fpassword")).sendKeys(DataProviderFactory.getExcel().getData(1, 0, 1));
	        driver.findElement(By. name("login")).click();
	}
	
	
	
	@SuppressWarnings("deprecation")
	@Then("^I will see an Error message 'Login error : either username or password was not recognised - please try again!'$")
	public void i_will_see_an_Error_message_Login_error_either_username_or_password_was_not_recognised_please_try_again() throws Throwable {
		
		
		
	     /*  String chkPage = driver.findElement(By.linkText("My Personal Details")).getText() ;
	        
	       //   String chkPage1 = driver.findElement(By.className("blue")).
	           
	           System.out.println("the chkpage text is   " + chkPage);
	           
	           Assert.assertEquals("My Personal Details", chkPage);  */
		
		
		String chkPage = "something";
		
		if ( chkPage.contentEquals("My Personal Details"))	
		{
			Reporter.addStepLog("Successfully logged in");

	}
	
else
		{
	
	Thread.sleep(1000);
	
	getscreenshot();
    Reporter.addScreenCaptureFromPath("C:\\Users\\tankar\\workspace\\embs.set.rmit.edu\\Screenshots\\screenshottest.png");
    //driver.findElement(By.xpath("//li[contains(text(), 'Password invalid')]"))
    Assert.assertEquals("Program Guides Main Menu", driver.getTitle());
		}; 
	 


//String screenshotPath = Utility.takeSnapShot(driver, result.getName());

driver.close();


	}


/*	public void tearDown(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//utility.Utility
			//this.takeSnapShot(driver, "c://eclipse//test.png") ;
			//String screenshotPath = Utility.takeSnapShot(driver, result.getName());
			String screenshotPaths = Utility.takeSnapShot(driver, "xyz");
			//logger.log(LogStatus.FAIL, "Title Verification", screenshotPath);
			
		}
		//report.endTest(logger);
		//report.flush();
		
	} */
	
    public void getscreenshot() throws Exception 
    {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png"
            FileUtils.copyFile(scrFile, new File(".\\Screenshots\\screenshottest.png"));
    }  

}
