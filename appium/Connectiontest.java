package appiumtest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Connectiontest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		File appdir= new File("src");
		File apppath = new File(appdir,"com.americanexpress.android.acctsvcs.us_2017-04-12.apk");
		//File apppath = new File(appdir,"Dice_v3.9.2_apkpure.com.apk");
		DesiredCapabilities cap= new DesiredCapabilities();
//		cap.setCapability("platformName" , "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator - Nexus_5X_API_23");
		cap.setCapability(CapabilityType.VERSION, "7.1.1");
//		cap.setCapability(MobileCapabilityType.APP, apppath.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "5000");     //max waiting time
//		cap.setCapability("deviceName", "Android Emulator");
		cap.setCapability("app", apppath.getAbsolutePath());

		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		//driver.findElementById("").click();
		
		
/*		DesiredCapabilities capabilities = new DesiredCapabilities().android();
        capabilities.setCapability("no",true);
        capabilities.setCapability("newCommandTimeout", 100000);
        capabilities.setCapability("noReset", true);
 //       capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
 //       capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
        capabilities.setCapability("deviceName", "Galaxy nexus");
        capabilities.setCapability("app", apppath.getAbsolutePath());
        capabilities.setCapability("automationName", "selendroid");
        capabilities.setCapability("noRest", true);
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);*/
		
/*		DesiredCapabilities capabilities = new DesiredCapabilities ();
		capabilities.setCapability("browsername","Browser");
		//capabilities.setCapability("browsername","chrome");
		capabilities.setCapability("device","android");
		capabilities.setCapability("newCommandTimeout", 100000);
		//capabilities.setCapability("devicename","Nexus_6_API_25");
		capabilities.setCapability("deviceName", "Nexus_5X_API_23");
		capabilities.setCapability("platformversion","7.1.1");
		capabilities.setCapability("platformname","Android");
		//capabilities.setCapability("appPackage","com.android.chrome");
		//capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Thread.sleep(10000);
		
		driver.get("https://www.google.com");*/
		
		
		
	}

}
