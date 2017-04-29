package com.gmail.compose;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjectModel.GmailPage;
import pageObjectModel.LoginPageNew;
import pageObjectModel.LoginPageOld;

public class UploadTest {
	WebDriver driver;
	Properties prop = new Properties();
	InputStream input = null;
	
	@BeforeMethod
	public void setup(){
		try{
			input = new FileInputStream("src\\config.properties");
			prop.load(input);
			
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriverLocation"));				
			driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.manage().window().maximize();
			driver.get(prop.getProperty("URL"));
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void GmailTest(){		
		try{
			input = new FileInputStream("src\\config.properties");
			prop.load(input);
			
			if(driver.getTitle().equals("Gmail - Free Storage and Email from Google"))
				driver.findElement(By.linkText("Sign In")).click();
			
			LoginPageOld lpo = new LoginPageOld(driver);
			LoginPageNew lpn = new LoginPageNew(driver);
			
			if(driver.findElements(By.id("Email")).size()!=0){	
				lpo.userName().sendKeys(prop.getProperty("gmailUserName"));
				lpo.userNameNext().click();
				lpo.password().sendKeys(prop.getProperty("gmailPassword"));
				lpo.signInButton().click();
			}else if(driver.findElements(By.id("identifierId")).size()!=0){
				lpn.userName().sendKeys(prop.getProperty("gmailUserName"));
				lpn.userNameNext().click();
				lpn.password().sendKeys(prop.getProperty("gmailPassword"));
				lpn.signInButton().click();
			}
			
			GmailPage gp = new GmailPage(driver);
			
			
			gp.composeButton().click();
			gp.attachmentButton().click();
			
			Thread.sleep(3000L);
			Process proc = Runtime.getRuntime().exec(prop.getProperty("uploadExe"));
			
			Thread.sleep(3000L);
			gp.deleteComposeMail().click();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				input.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
	
	@AfterMethod
	public void CleanUp(){
		driver.close();
	}
}
