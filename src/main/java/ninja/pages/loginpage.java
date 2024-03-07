package ninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
 
	WebDriver driver;
	@FindBy(id="input-email")
	private WebElement emailaddressfield;
	
	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginbutton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement emailpasswordnotmatching;
	
	
	 
	public loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enteremailaddress(String emailText) {
		
		emailaddressfield.sendKeys(emailText);
	}
    public void enterpassword(String password) {
		
    	passwordfield.sendKeys(password);
	}
    public Accountpage loginbuttons() {
	
    	loginbutton.click();
    	return new Accountpage(driver);
	}
    public Accountpage loginreduce(String emailText,String password) {
    	
    	emailaddressfield.sendKeys(emailText);
    	passwordfield.sendKeys(password);
    	loginbutton.click();
    	return new Accountpage(driver);
    	
    }
	public String retrivewarningmessege() {
		
		String warningText= emailpasswordnotmatching.getText();
		return warningText;
	}
	
}



