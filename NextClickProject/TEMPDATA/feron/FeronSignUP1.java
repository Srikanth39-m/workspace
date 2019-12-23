package feron.FeronHealth;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FeronSignUP1 extends TestBase {
  public FeronSignUP1() throws IOException {
		super();
	}

@Test
@Parameters("browser")
  public void register(String browser) throws InterruptedException {
	openbrowser(browser);
	openurl(driver, config.getProperty("url"));
	click(driver, config.getProperty("signup"));
		sendkey(driver, config.getProperty("firstName"), config.getProperty("firstName1"));
		sendkey(driver, config.getProperty("lastName"), config.getProperty("lastName1"));
		sendkey(driver, config.getProperty("email"), config.getProperty("email1"));
		sendkey(driver, config.getProperty("phone"), config.getProperty("phone1"));
		sendkey(driver, config.getProperty("sgpwd"), config.getProperty("sgpwd1"));
		sendkey(driver, config.getProperty("sgconfpwd"), config.getProperty("sgconfpwd1"));
		click(driver, config.getProperty("RegisterBtn"));
		driver.switchTo().alert().accept();
		Reporter.log("Sign up Passed",true);
	  
	  
	  
  }
}
