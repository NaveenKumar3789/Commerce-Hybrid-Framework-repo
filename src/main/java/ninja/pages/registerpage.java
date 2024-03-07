package ninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerpage {

	 WebDriver driver;

	public registerpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//webelements
	
	@FindBy (id="input-firstname")
	private WebElement firstname;
	
	@FindBy (id="input-lastname")
	private WebElement lastname;
	
	@FindBy (id="input-email")
	private WebElement email;

	@FindBy (id="input-telephone")
	private WebElement telephone;

	@FindBy (id="input-password")
	private WebElement password;
	
	@FindBy (id="input-confirm")
	private WebElement confrmpassword;
	
	@FindBy (xpath="//input[@name='newsletter'][@value='1']")
	private WebElement newletter;
	
	@FindBy (name="agree")
	private WebElement agreebuton;
	
	@FindBy (xpath="//input[@value='Continue']")
	private WebElement continuebuton;
	
	// errors 
	
	@FindBy (xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateemailaddresmsge;
	
	@FindBy (xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacypolicymsge;
	
	@FindBy (xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstnamemsge;
	
	@FindBy (xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastnamemsge;
	
	@FindBy (xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement Emailmsge;
	
	@FindBy (xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneerror;
	
	@FindBy (xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement pswderror;
	
	
	
	
	// actions
	
	public void enterfirstname(String firstn) {
		firstname.sendKeys(firstn);
	}
	public void enterlastname(String lasttn) {
		lastname.sendKeys(lasttn);
	}
	public void enteremail(String emai) {
		email.sendKeys(emai);
	}
	public void entertelephone(String tele) {
		telephone.sendKeys(tele);
	}
	public void enterpassword(String pswd) {
		password.sendKeys(pswd);
	}
	public void entercnfrmpassword(String cnfmpswd) {
		confrmpassword.sendKeys(cnfmpswd);
	}
	public void confrmnewsletter() {
		newletter.click();
	}
	
	public void agreebut() {
		agreebuton.click();
	}
	public Accountsucesspage continuebut() {
		continuebuton.click();
		return new Accountsucesspage(driver);
	}
	public String duplicateemail() {
		String warningmsge = duplicateemailaddresmsge.getText();
		return warningmsge;
	}
	
	public String privacypp() {
		String warningmsge = privacypolicymsge.getText();
		return warningmsge;
	}
	
	public String fnmage() {
		String warningmsge = firstnamemsge.getText();
		return warningmsge;
	}
	
	public String lasnmg() {
		String warningmsge = lastnamemsge.getText();
		return warningmsge;
	}
	
	public String Emlmsage() {
		String warningmsge = Emailmsge.getText();
		return warningmsge;
	}
	
	public String phonemsge() {
		String warningmsge = telephoneerror.getText();
		return warningmsge;
	}
	
	public String pswder() {
		String warningmsge = pswderror.getText();
		return warningmsge;
	}

	public Accountsucesspage registerreduce(String firstn,String lasttn,String emai,String tele,String pswd,String cnfmpswd)
	{
		firstname.sendKeys(firstn);
		lastname.sendKeys(lasttn);
		email.sendKeys(emai);
		telephone.sendKeys(tele);
		password.sendKeys(pswd);
		confrmpassword.sendKeys(cnfmpswd);
		newletter.click();
		agreebuton.click();
		continuebuton.click();
		return new Accountsucesspage(driver);
		
	}
	
	public boolean displaystatusofwarningmesseges(String expprivacypolicywarning,String expfirstnamewarning,String explastnamewarning,String expemailwarning,String exptelephonewarning,String exppasswordwarning)
	 {
		boolean privacypolicywarningstatus = privacypolicymsge.getText().contains(expprivacypolicywarning);
		boolean firstnamewarningstatus = firstnamemsge.getText().contains(expfirstnamewarning);
		boolean lastnamewarningstatus = lastnamemsge.getText().contains(explastnamewarning);
		boolean emailwarningstatus = Emailmsge.getText().contains(expemailwarning);
		boolean telephonewarningstatus = telephoneerror.getText().contains(exptelephonewarning);
		boolean passwordwarningstatus = pswderror.getText().contains(exppasswordwarning);
		return privacypolicywarningstatus && firstnamewarningstatus && lastnamewarningstatus && emailwarningstatus && telephonewarningstatus && passwordwarningstatus;
		
		
	}
}


	
	
	
	
	
	
	
	

