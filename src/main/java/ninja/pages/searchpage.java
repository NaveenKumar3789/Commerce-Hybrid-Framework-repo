package ninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchpage {
	WebDriver driver;

	 
		public searchpage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
		
		@FindBy(linkText="HP LP3065")
		private WebElement productsearch;
		
		@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
		private WebElement invalidproductsearch;
		
		public boolean displayofvalidhpproduct() {
			boolean displaystatus= productsearch.isDisplayed();
					return displaystatus;
		}
		
		public String invalidprod() {
			String warningmsge = invalidproductsearch.getText();
			return warningmsge;
		}
}
