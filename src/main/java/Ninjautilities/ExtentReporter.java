package Ninjautilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	
	 public static ExtentReports generateExtentReport() throws IOException {
		 
		 ExtentReports extentreport = new ExtentReports();
		 File extentreportFile = new File(System.getProperty("user.dir")+"\\test-output\\Extentreports\\report.html");
	
		 ExtentSparkReporter sparkreporter = new ExtentSparkReporter(extentreportFile);
		 
		 sparkreporter.config().setTheme(Theme.DARK);
		 sparkreporter.config().setReportName("Ninja Testautomation Result");
		 sparkreporter.config().setDocumentTitle("TN Automation Report");
		 sparkreporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		 
		 
		 extentreport.attachReporter(sparkreporter);
		 Properties configProp = new Properties();
		
		 
		 File configPropFile = new  File(System.getProperty("user.dir"),"\\src\\main\\java\\ninja\\confg\\config.properties");
		 try {
		 FileInputStream fisConfigPROP = new FileInputStream(configPropFile);
		 configProp.load(fisConfigPROP);
		 }catch(Throwable e) {
			 e.printStackTrace();
		 }
		 extentreport.setSystemInfo("Application URL",configProp.getProperty("url"));
		 
		 extentreport.setSystemInfo("Browser Name",configProp.getProperty("browser"));
		 extentreport.setSystemInfo("EMAIL",configProp.getProperty("validEmail"));
		 extentreport.setSystemInfo("PASSWORD",configProp.getProperty("validPassword"));
		 extentreport.setSystemInfo("Operating syatem",System.getProperty("os.name"));
		 extentreport.setSystemInfo("User Name",System.getProperty("user.name"));
		 extentreport.setSystemInfo("Java version",System.getProperty("java.version.name"));
		 
		 return extentreport;
	 }
}
