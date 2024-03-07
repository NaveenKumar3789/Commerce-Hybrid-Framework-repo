package automation.commerce;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Ninjautilities.utils;
import automation.base.Base;
import ninja.pages.Accountsucesspage;
import ninja.pages.homepage;
import ninja.pages.registerpage;


public class RegisterTest extends Base {
	public RegisterTest() throws IOException {
		super();
	}
	public WebDriver driver;
	registerpage rp;
	Accountsucesspage ap;
	@BeforeMethod
	public void Setup()
	{
		
		driver= initializeBrowseropenAPP(prop.getProperty("browser"));
		homepage hp=new homepage(driver);
	   // hp.clickonmyaccount();
		//registerpage rp =hp.SelectRegisterOption();
		rp= hp.navigateToRegisterpage();
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@Test(priority=1)
        public void VerifyRegisteringanAccountbyprovidingonlytheMandatoryfields() {
		ap=rp.registerreduce(dataprop.getProperty("firstName"), dataprop.getProperty("lastName"), utils.generateEmailwithTimeStamp(), dataprop.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		//String actualSuccessHeading = ap.confirmationmsge();
	    Assert.assertEquals(ap.confirmationmsge(),dataprop.getProperty("accountSuccessfullyCreatedHeading"),"Account sucess page is not displayed");
	    
	    }
	@Test(priority=2)
	public void VerifyRegisteringanAccountbyprovidingallthefields() {
		ap=rp.registerreduce(dataprop.getProperty("firstName"), dataprop.getProperty("lastName"), utils.generateEmailwithTimeStamp(), dataprop.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword")); 
	    Assert.assertEquals(ap.confirmationmsge(),dataprop.getProperty("accountSuccessfullyCreatedHeading"),"Account sucess page is not displayed");
	     
	    }

	
	@Test(priority=3)
	public void VerifyRegisteringanAccountbyprovidingtheexistingaccountdetails()
	{
		rp.registerreduce(dataprop.getProperty("firstName"), dataprop.getProperty("lastName"), prop.getProperty("validEmail"), dataprop.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		
	   // String actualwarning= rp.duplicateemail();
	    Assert.assertTrue(rp.duplicateemail().contains(dataprop.getProperty("duplicateEmailwarning")),"warning messege duplicate emailaddress is not diaplyed");
	     
		
	}
	@Test(priority=4)
	public void withoutprovideing() {
		
		rp.continuebut();
	   
	  Assert.assertTrue(rp.displaystatusofwarningmesseges(dataprop.getProperty("privacypolicywarnng"), dataprop.getProperty("firstNamewarning"), dataprop.getProperty("lastNamewarning"), dataprop.getProperty("emailwarning"), dataprop.getProperty("telephonewarning"), dataprop.getProperty("passwordwarning")),"warning messeges are not displayed");
	   
	    }
}

