package com.main.nextClick;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MainTest {
	public WebDriver driver;
	public static Properties config=new Properties();
	public static Properties org=new Properties();
	public static FileInputStream fis_config,fis_org;
	public Actions ac;
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
  
  public void nextClickLaunch(){
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://cineplant.com/nextclick");
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@admin.com");
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("next@click");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
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
	
			
	//Listing Master Data Category
			public void MasterDataCategoryAdd() throws InterruptedException{
				 driver.findElement(By.cssSelector(".dropdown:nth-child(6) span")).click();
				    driver.findElement(By.linkText("Category")).click();
				    driver.findElement(By.cssSelector(".multiselect-selected-text")).click();
				    driver.findElement(By.cssSelector("li:nth-child(513) input")).click();
				    driver.switchTo().frame(0);
				    driver.findElement(By.cssSelector("html")).click();

			
			}
  
	
  
  
  
  }
  
