package appiumtest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class AmexLogin {
	public static String appPackageName="com.americanexpress.android.acctsvcs.us:id/";
	public static void main(String[] args) {
		
		File appdir= new File("src");
		//File apppath = new File(appdir,"com.americanexpress.android.acctsvcs.us_2017-04-12.apk");
		//File apppath = new File(appdir,"BookMyShow–Movie Tickets-Plays_5.1.8_apk-dl.com.apk");
		File apppath = new File(appdir,"org.gamatech.androidclient.app-2.4.1@APK4Fun.com.apk");
		
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
		cap.setCapability(CapabilityType.VERSION, "6.0");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");     //max waiting time
		cap.setCapability("app", apppath.getAbsolutePath());
	//	cap.setCapability("appPackage","com.americanexpress.android.acctsvcs.us");
	//	cap.setCapability("appActivity","com.americanexpress.android.acctsvcs.us.firstuse.StartupActivity");
	//	cap.setCapability("appActivity","com.google.android.gms.common.api.GoogleApiActivity");
	//	cap.setCapability("appActivity","com.americanexpress.android.acctsvcs.us.firstuse.FirstTimeExperienceInitialLoadingActivity");
	//	cap.setCapability("appActivity","com.americanexpress.android.acctsvcs.us.login.LegalPrivacyActivity");
	//	cap.setCapability("appActivity","com.americanexpress.android.acctsvcs.us.login.LoginActivity");
		
		//cap.setCapability("appActivity","com.americanexpress.android.acctsvcs.us/.firstuse.FirstTimeExperienceEulaActivity");
		
		try {
			AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			System.out.println("check1");
			Thread.sleep(10000);
			//driver.findElementById("manuallyInputLocationLink").click();
			driver.findElementByXPath("//*[mtext='I\'ll ENTER LOCATION MANUALLY']");
		//	driver.findElementById(appPackageName+"generic_webview_positive_button").click();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.findElementById("").click();

	}

}
