package ninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {
 
	WebDriver driver;
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement Myaccountdropmenu;
	
	@FindBy(linkText="Login")
	private WebElement loginoption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy (name="search")
	private WebElement Searchboxfield;
	
	@FindBy (xpath="//div[@id='search']/descendant::button")
	private WebElement searchbutton;
	
	 
	public homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickonmyaccount() {
		
		Myaccountdropmenu.click();
	}
    public loginpage selectloginoption() {
		
	loginoption.click();
	return new loginpage(driver);
	}
    
    public loginpage navigatTologinpage() {
    	
    	Myaccountdropmenu.click();
    	loginoption.click();
    	return new loginpage(driver);
    }
	
    public registerpage SelectRegisterOption() {
    	registerOption.click();
    	return new registerpage(driver);
    }
    
    public void enterproductintosearch(String producttext) {
    	Searchboxfield.sendKeys(producttext);
    	
    }
    public searchpage Searchbut() {
    	searchbutton.click();
    	return new searchpage(driver);
    
    }
    
    public registerpage navigateToRegisterpage() {
    	Myaccountdropmenu.click();
    	registerOption.click();
    	return new registerpage(driver);
    }
    public searchpage searchforaproduct(String producttext)
    {
    	Searchboxfield.sendKeys(producttext);
    	searchbutton.click();
    	return new searchpage(driver);
    	
    	
    	
    	
    }
    
    
    }
