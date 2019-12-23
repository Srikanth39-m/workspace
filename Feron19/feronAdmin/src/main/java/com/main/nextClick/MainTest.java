package com.main.nextClick;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MainTest {
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties org=new Properties();
	public static FileInputStream fis_config,fis_org;
	public static Actions ac;
	public MainTest(){
	try {
		fis_config= new FileInputStream("./properties/config.Properties");
		config.load(fis_config);
		fis_org=new FileInputStream("./properties/org.Properties");
		org.load(fis_org);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
  public void ChromeBrowser() {
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
					driver.findElement(By.xpath(xpath)).clear();
					driver.findElement(By.xpath(xpath)).sendKeys(value);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	//sendkeyNum
			public void sendkeyNum(WebDriver driver,String xpath,double d) {
				try {
					long quantity=(long) d;
					String qty=String.valueOf(quantity);
					driver.findElement(By.xpath(xpath)).clear();
					driver.findElement(By.xpath(xpath)).sendKeys(qty);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			
	
			public void feronAdminLaunch() {
				System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
				  driver=new ChromeDriver();
				  driver.manage().window().maximize();
				  driver.manage().deleteAllCookies();
				  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  driver.get("http://grepthorhosting.com/feron/admin");
				  driver.findElement(By.xpath("//input[@name='email']")).sendKeys("admin@gmail.com");
				  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234");
				  driver.findElement(By.xpath("//button[text()='SIGN IN']")).click();
				  
			}
  
  
  
  }
  
