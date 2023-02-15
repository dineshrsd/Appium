package org.appium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExceptionTestContextImpl;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.SessionStatusStats;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.SystemAttributeContext;
import com.aventstack.extentreports.TestAttributeTestContextProvider;
import com.aventstack.extentreports.model.Author;
import com.aventstack.extentreports.model.Category;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.model.ScreenCapture;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;


public class Caltestng {

	public static AndroidDriver driver;
	ExtentHtmlReporter htmlreport;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeClass
	private void launchbrowser() throws MalformedURLException{
		 htmlreport = new ExtentHtmlReporter("calculator.html");
		 extent = new  ExtentReports();
		extent.attachReporter(htmlreport);
		
		 test = extent.createTest("Android","Calculator"); 
					
		DesiredCapabilities  cap = new DesiredCapabilities();
		cap.setCapability("platformName","Android");
		cap.setCapability("version","12");
		cap.setCapability("deviceName","redminote 10pro");
		cap.setCapability("udid", "2301d577");
		cap.setCapability("appPackage","com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
	}

	@Test(priority=1)
	private void tc1() {
		test.log(Status.INFO,"appium add the click button");
		WebElement one = driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
		one.click();
		test.log(Status.INFO,"appium add the click button");
		WebElement zero = driver.findElement(By.id("com.google.android.calculator:id/digit_0"));
		zero.click();
	}

	@Test
	(priority=2)
	private void tc2() {
		test.log(Status.INFO,"appium add the click button");
		WebElement multi = driver.findElement(By.id("com.google.android.calculator:id/op_mul"));
		multi.click();
	}

	@Test
	(priority=3)
	private void tc3() {
		test.log(Status.INFO,"appium add the click button");
		WebElement five = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
		five.click();
	}

	@Test
	(priority=4)
	private void tc4() throws IOException {
		test.log(Status.INFO,"appium add the click button");
		WebElement equal = driver.findElement(By.id("com.google.android.calculator:id/eq"));
		equal.click();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File img = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("./screenshoots\\cal.png");
		FileUtils.copyFile(img, f);

	}

	@BeforeMethod
	private void startdatetime() {
		Date d = new Date();
		System.out.println(d);
	}

	@AfterMethod
	private void enddatetime() {
		Date d = new Date();
		System.out.println(d);
	}

	@AfterClass
	private void closebrowser() {
		extent.flush();
		driver.quit();

	}

}
