package listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Ninjautilities.ExtentReporter;
import Ninjautilities.utils;

public class MyListeners implements ITestListener {
	ExtentReports extentReport;
	ExtentTest extenttest;
	
     public void onStart(ITestContext context) {
		
			
				try {
					extentReport = ExtentReporter.generateExtentReport();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		 		 }
	

	@Override
	public void onTestStart(ITestResult result) {
		//testName = result.getName();
		 extenttest = extentReport.createTest(result.getName());
		extenttest.log(Status.INFO,result.getName()+"started excuting");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	extenttest.log(Status.PASS, (result.getName()+"got successfully excuted"));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	WebDriver driver = null;
	try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	    String destinationScreenshotPath = utils.captureScreenshot(driver,result.getName());
		extenttest.addScreenCaptureFromPath(destinationScreenshotPath);
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.FAIL, result.getName()+"got failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.SKIP, result.getName()+"got skipped");
		
	}

	
	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		 
		String pathofExtentReport = System.getProperty("user.dir")+"\\test-output\\Extentreports\\report.html";
		File extentReport = new File(pathofExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
