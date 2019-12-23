package com.main.nextClick;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestBase {
	public WebDriver driver;
	public static Properties config=new Properties();
	public static Properties org=new Properties();
	public static FileInputStream fis_config,fis_org;
	
	//loading property files
		public TestBase() throws IOException {
			
			
			try {
				fis_config= new FileInputStream("./properties/config.Properties");
				config.load(fis_config);
				fis_org=new FileInputStream("./properties/org.Properties");
				org.load(fis_org);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		//Open Browser
		
		public void openbrowser(String browser) {
			if(browser.equals("Chrome")) {
		      System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		      driver=new ChromeDriver();	
		      System.out.println("Chrome launched successfully");
		      
			} else if(browser.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
				driver= new FirefoxDriver();
				System.out.println("firefox launched successfully");
				
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		public void browser_chrome() {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		   WebDriver driver=new ChromeDriver();
		    driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		public void browser_firefox() {
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		   WebDriver driver=new FirefoxDriver();
		    driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		
		
		
		//Get Url
		public void openurl(WebDriver driver,String url) {
			
			try {
				driver.get(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Click
		public void click(WebDriver driver,String xpath) {
			
			try {
				driver.findElement(By.xpath(xpath)).click();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Sendkeys
		public void sendkey(WebDriver driver, String xpath,String value) {
			
			try {
				driver.findElement(By.xpath(xpath)).sendKeys(value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void closeBrowserTab() throws AWTException {
		    Robot robot=new Robot();
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_W);
		    robot.keyRelease(KeyEvent.VK_W);
		    robot.keyRelease(KeyEvent.VK_CONTROL);

		}
		
		
		
		
		
		// Mouse over
public void mouseover(WebDriver driver, String xpath) {
	try {
		Actions ac=new Actions(driver);
		WebElement obj = driver.findElement(By.xpath(xpath));
		ac.moveToElement(obj).perform();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


// Mouse over & print list & count.
public void mouseovergetlist(WebDriver driver, String xpath1, String xpath2) throws InterruptedException {

	Actions ac=new Actions(driver);
//	ac.keyDown(Keys.F5).perform();
//	ac.keyDown(Keys.F5).perform();
//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement obj = driver.findElement(By.xpath(xpath1));
	ac.moveToElement(obj).perform();
	List<WebElement> products = driver.findElements(By.xpath(xpath2));
//	System.out.println(products.size());
		int i=1,j=products.size();
		while (i<j) {
			
			System.out.println(products.get(i).getText());
			WebElement item=products.get(i);
			ac.click(item).perform();
			Thread.sleep(600);
			i++;
		}
}	



	
	

}
