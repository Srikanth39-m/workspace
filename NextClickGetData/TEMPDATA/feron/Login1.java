package feron.FeronHealth;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login1 extends TestBase {
  public Login1() throws IOException {
		super();
	}
  
 @BeforeMethod
 @Parameters("browser") 
  public void brow(String browser) {
	 openbrowser(browser);
	 openurl(driver, config.getProperty("url"));
 }
@Test

  public void login2() throws InterruptedException {
	click(driver, config.getProperty("login"));
	sendkey(driver, config.getProperty("loginUser"), config.getProperty("user"));
	sendkey(driver, config.getProperty("loginPwd"), config.getProperty("pwd"));
	click(driver, config.getProperty("btnLogin"));
	driver.switchTo().alert().accept();
	click(driver, config.getProperty("afterlogin"));
	WebElement UserProfile = driver.findElement(By.xpath(config.getProperty("profile")));
	if (UserProfile.isDisplayed()) {
		Reporter.log("User login Passed",true);
	}else {
		Reporter.log("User login Failed",true);
	}
  }

}
