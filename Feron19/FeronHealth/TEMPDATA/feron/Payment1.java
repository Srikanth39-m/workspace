package feron.FeronHealth;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Payment1 extends TestBase {
	Login1 obj;
public Payment1() throws IOException {
		super();
	}
@BeforeMethod
@Parameters("browser") 
 public void brow(String browser) throws Exception {
	obj = new Login1();
	obj.brow(browser);
	 obj.login2();
}

@Test
  public void Pay() throws InterruptedException, IOException {
	
	Actions ac=new Actions(driver);
	ac.moveToElement(driver.findElement(By.xpath(config.getProperty("OnlineProducts"))));
	ac.moveToElement(driver.findElement(By.xpath(config.getProperty("Nephrology")))).click().perform();
	click(driver, config.getProperty("product1"));
	click(driver, config.getProperty("AddtoCart"));
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	click(driver, config.getProperty("cart"));
	click(driver, config.getProperty("ProceedToCheckout"));
	
	

	
	
	  
  }
}
