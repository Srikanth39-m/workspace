package com.nextClick;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MainTest {
	public WebDriver driver;
	public static Properties config=new Properties();
	public static Properties org=new Properties();
	public static FileInputStream fis_config,fis_org;
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
  @Test
  public void browserChrome() {
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @Test
  public void nextClickLaunch(){
	  driver.get("http://cineplant.com/nextclick");
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@admin.com");
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("next@click");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
  @Test
  public void gettingProductNamesFromImages() throws IOException{
	  driver.get(config.getProperty("localUrl"));
	  List<WebElement> folders = driver.findElements(By.xpath(config.getProperty("Folders")));
	  for (int i =1 ; i <= folders.size() ; i++) {
		  WebElement EchFolder = driver.findElement(By.xpath("(//tr//a[starts-with(@href,'/F:/Srikanth/NextClickGroceryAdd/NextClickBulk/')])["+i+"]"));
		  System.out.println(EchFolder.getText());
		  EchFolder.click();
		  List<WebElement> Allfiles = driver.findElements(By.xpath(config.getProperty("AllImages")));
		  for (int j = 1; j <= Allfiles.size(); j++) {
			  WebElement EchFile = driver.findElement(By.xpath("(//a[starts-with(@href,'/F:/Srikanth/NextClickGroceryAdd/NextClickBulk')])["+j+"]"));
			  System.out.println(EchFile.getText());
		}
		  driver.navigate().back();
	}
  }
public void DownloadImagesWithTxt() {
	// TODO Auto-generated method stub
	
}
  
	  
	  
	  
  }
  
