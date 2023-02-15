package org.appium;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Myntra {
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException, AWTException {

		DesiredCapabilities  cap = new DesiredCapabilities();

		cap.setCapability("platformName","Android");
		cap.setCapability("version","12");
		cap.setCapability("deviceName","redminote 10pro");
		cap.setCapability("udid", "2301d577");
		cap.setCapability("appPackage","com.myntra.android");
		cap.setCapability("appActivity", "com.myntra.android.SplashActivity");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
		Thread.sleep(5000);
		WebElement profile = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"tabButton_profile\"]/android.view.ViewGroup/android.widget.ImageView"));
		profile.click();
		Thread.sleep(3000);
		WebElement login = driver.findElement(By.xpath("//*[@text='LOG IN/SIGN UP']"));
		login.click();
		Thread.sleep(3000);
		WebElement mobilenumtext = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"mobile\"]"));
		mobilenumtext.sendKeys("123456789");
		Thread.sleep(3000);
		WebElement continu = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"form-button\"]"));
		continu.click();
	}
}