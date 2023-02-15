package org.appium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Firsttest{
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException, AWTException {
		
		DesiredCapabilities  cap = new DesiredCapabilities();

		cap.setCapability("platformName","Android");
		cap.setCapability("version","12");
		cap.setCapability("deviceName","redminote 10pro");
		cap.setCapability("udid", "2301d577");
		cap.setCapability("appPackage","com.android.chrome");
		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(url, cap);

		WebElement accept = driver.findElement(By.id("com.android.chrome:id/terms_accept"));
		accept.click();

		WebElement nothank = driver.findElement(By.id("com.android.chrome:id/negative_button"));
		nothank.click();
		Thread.sleep(3000);

		WebElement searchbox = driver.findElement(By.id("com.android.chrome:id/search_box_text"));
		
		searchbox.sendKeys("flipkart");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		WebElement flipkartsite = driver.findElement(By.id("com.android.chrome:id/line_2"));
		flipkartsite.click();

	}
}
