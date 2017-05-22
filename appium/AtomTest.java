package appiumtest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AtomTest {

	public static void main(String[] args) {
		File appdir= new File("src");
		File apppath = new File(appdir,"org.gamatech.androidclient.app-2.4.1@APK4Fun.com.apk");
		
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
		cap.setCapability(CapabilityType.VERSION, "6.0");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");     //max waiting time
		cap.setCapability("app", apppath.getAbsolutePath());
		cap.setCapability("appActivity","org.gamatech.androidclient.app.activities.gateway.LocationServicesDisabledActivity");
		
		try {
			AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			System.out.println("check1");
			Thread.sleep(10000);
			//driver.findElementById("manuallyInputLocationLink").click();
			driver.findElementByXPath("//*[mtext='I\'ll ENTER LOCATION MANUALLY']");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}

}
