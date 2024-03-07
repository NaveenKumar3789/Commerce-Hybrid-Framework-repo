package automation.commerce;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Ninjautilities.utils;
import automation.base.Base;
import ninja.pages.Accountpage;
import ninja.pages.homepage;
import ninja.pages.loginpage;

public class LoginwithvalidcerdientialsTest extends Base{
	public LoginwithvalidcerdientialsTest() throws IOException {
		super();
	}
	public WebDriver driver;
	loginpage lp;
	@BeforeMethod
	public void Setup()
	{
		driver= initializeBrowseropenAPP(prop.getProperty("browser"));
		homepage hm = new homepage(driver);
		lp =hm.navigatTologinpage();
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@Test(priority=1,dataProvider="validcred")
      public void Login(String email,String password)
      {
		Accountpage accountpage = lp.loginreduce(email, password);
		Assert.assertTrue(accountpage.getDisplayStatusofEditOption());
	  }
	
	
	@DataProvider(name="validcred")
	public  Object[][] supplyTestData() {
		Object[][] data = utils.gettestData("login");
		return data;
	}
		   
	@Test(priority=2)
	 public void invalidLogin()
     {
		lp.loginreduce(utils.generateEmailwithTimeStamp(), prop.getProperty("validPassword"));
		
		String actualWarningMessage= lp.retrivewarningmessege();
		String expectedWarningMessage= dataprop.getProperty("emailpasswordnomatchwarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning message is displayed!!");
		
		}
	
	@Test(priority=3)
	 public void invalidLoginWithinvalidemail()
	 
    {
		lp.loginreduce(utils.generateEmailwithTimeStamp(), prop.getProperty("validPassword"));
		
		String actualWarningMessage= lp.retrivewarningmessege();
		String expectedWarningMessage= dataprop.getProperty("emailpasswordnomatchwarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning message is displayed!!");
		
		}
	
	@Test(priority=4)
	 public void invalidLoginWithinvalidpassword()
	 {
		lp.loginreduce(prop.getProperty("validEmail"), dataprop.getProperty("invalidpassword"));
		//lp.enteremailaddress(prop.getProperty("validEmail"));
		//lp.enterpassword(dataprop.getProperty("invalidpassword"));
		//lp.loginbuttons();
		String actualWarningMessage= lp.retrivewarningmessege();
		String expectedWarningMessage= dataprop.getProperty("emailpasswordnomatchwarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning message is displayed!!");
		}
	
	@Test(priority=5)
	public void withoutprovidingcreditinals()
	{
		
		
		lp.loginbuttons();
		//String actualWarningMessage= lp.retrivewarningmessege();
		//String expectedWarningMessage= dataprop.getProperty("emailpasswordnomatchwarning");
		Assert.assertTrue(lp.retrivewarningmessege().contains(dataprop.getProperty("emailpasswordnomatchwarning")),"Expected Warning message is displayed!!");
			
	}
	
}
