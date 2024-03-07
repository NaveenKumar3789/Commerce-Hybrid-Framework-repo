package automation.commerce;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.base.Base;
import ninja.pages.homepage;
import ninja.pages.searchpage;

public class SearchTest extends Base {
	public SearchTest() throws IOException   {
		super();
	}
	public WebDriver driver;
	searchpage sp;
	homepage hp;
	
	@BeforeMethod
	public void Setup()
	{
		
		driver= initializeBrowseropenAPP(prop.getProperty("browser"));
		 hp = new homepage(driver);
	}
		
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void VerifysearchWithValidProduct()
	{
	sp=hp.searchforaproduct(dataprop.getProperty("validproduct"));
	//hp.enterproductintosearch(dataprop.getProperty("validproduct"));
	 //sp= hp.Searchbut();
	
	Assert.assertTrue(sp.displayofvalidhpproduct());
	}
	
	
	
	@Test(priority=2)
	public void VerifySearchwithinvalidproduct()
	{
		
		//hp.enterproductintosearch(dataprop.getProperty("invalidproduct"));
		//sp=hp.Searchbut();
		sp=hp.searchforaproduct(dataprop.getProperty("invalidproduct"));
		// String Actalsearchmessege = sp.invalidprod();
		Assert.assertEquals(sp.invalidprod(),"abcd","No product messege in search result is not displayed");
		}
	                               //dataprop.getProperty("noproducttest")
	
	
	@Test(priority=3,dependsOnMethods={"VerifysearchWithValidProduct","VerifySearchwithinvalidproduct"})
	 public void verifySearchwithoutAnyProduct()
	 {
		//homepage hp = new homepage(driver);
		sp=hp.Searchbut();
		
		 //String Actalsearchmessege = sp.invalidprod();
			Assert.assertEquals(sp.invalidprod(),dataprop.getProperty("noproducttest"),"No product messege in search result is not displayed");
			}
		 
	 }
		
	
	
	


