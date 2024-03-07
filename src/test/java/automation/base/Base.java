package automation.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Ninjautilities.utils;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
	//public void loadPropertiesFile() throws IOException {
	public Base() throws IOException {
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\ninja\\confg\\config.properties");
		dataprop = new Properties();
		File datapropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\ninja\\testdata\\testdata.properties");
		try {
			
	
		FileInputStream fis2 = new FileInputStream(datapropFile);
		dataprop.load(fis2);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		try {
			
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		
	}
	public WebDriver initializeBrowseropenAPP(String browserName) {
		
		
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
			
		}else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utils.PAGE_WAIT_TIME));
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}
}
