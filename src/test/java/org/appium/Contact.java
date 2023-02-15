package org.appium;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
public class Contact {
	public static AndroidDriver driver;
	@Test
	public void tc1()throws InterruptedException, AWTException, IOException {
		
		DesiredCapabilities  cap = new DesiredCapabilities();
		
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\rider44\\eclipse-workspace\\org.appium\\Files\\config.properties");
        properties.load(fis);
        
		cap.setCapability("platformName",properties.getProperty("platformName"));
		cap.setCapability("version",properties.getProperty("version"));
		cap.setCapability("deviceName",properties.getProperty("deviceName"));
		cap.setCapability("udid", properties.getProperty("udid"));
		cap.setCapability("appPackage",properties.getProperty("appPackage"));
		cap.setCapability("appActivity",properties.getProperty("appActivity"));
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
		
		WebElement add = driver.findElement(By.id(properties.getProperty("add")));
		add.click();
		
		WebElement fname = driver.findElement(By.xpath(properties.getProperty("fname")));
		fname.sendKeys(properties.getProperty("phonename"));
		Thread.sleep(2000);
		WebElement phone = driver.findElement(By.xpath(properties.getProperty("phone")));
		phone.sendKeys(properties.getProperty("phonenum"));
		
		WebElement save = driver.findElement(By.id(properties.getProperty("save")));
		save.click();

}
}