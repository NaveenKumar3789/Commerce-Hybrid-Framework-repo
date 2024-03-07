package ninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountsucesspage {
	
	WebDriver driver;

	public Accountsucesspage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//div[@id='content']/h1")
	private WebElement confirmationmessege;
	
	public String confirmationmsge() {
		String warningmsge = confirmationmessege.getText();
		return warningmsge; 

}
}
