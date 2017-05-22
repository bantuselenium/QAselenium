package appiumtest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AmazonTest {

	public static void main(String[] args) {
		
		File appdir= new File("src");
		//File apppath = new File(appdir,"Amazon_App.apk");
		File apppath = new File(appdir,"Best Buy.v10.10.0.apk");
		
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
		cap.setCapability(CapabilityType.VERSION, "6.0");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");     //max waiting time
		cap.setCapability("app", apppath.getAbsolutePath());
		//cap.setCapability("appActivity","com.amazon.mShop.splashscreen.StartupActivity");
		
		try {
			AndroidDriver driver=new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			System.out.println("check1");
			Thread.sleep(10000);
			driver.findElement(By.id("toolbarSearchHint")).click();
			driver.findElementById("search_src_text").sendKeys("laptop");
			System.out.println("check2");
			
			//driver.findElement(By.id("search_src_text")).sendKeys(Keys.RETURN);
			System.out.println("check3");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
