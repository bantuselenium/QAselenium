package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailPage {
	WebDriver driver;
	public GmailPage(WebDriver driver) {
		this.driver=driver;
	}
	By composeButton=By.xpath(".//*[@id=':ha']/div/div");
	By attachmentButton=By.xpath(".//div[@class='M9']/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/div[4]/table/tbody/tr/td[4]/div/div[1]/div/div/div");
	By deleteComposedMail=By.xpath(".//div[@class='M9']/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/div[4]/table/tbody/tr/td[6]/div/div[1]/div/div");
  public WebElement composeButton(){
    	return driver.findElement(composeButton);
  }
   
  public WebElement attachmentButton(){
    	return driver.findElement(attachmentButton);
  }
  
  public WebElement deleteComposeMail(){
	  return driver.findElement(deleteComposedMail);
  }
  
}
