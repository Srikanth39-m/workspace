package feron.FeronHealth;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

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
	public void Chrome() {
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

	//DropDwonSelectByValue
	public void dropdownValue(WebDriver driver, String xpath, String Value) {
		WebElement WebEle = driver.findElement(By.xpath(xpath));
		WebEle.click();
		Select drop = new Select(WebEle);
		drop.selectByVisibleText(Value);
	}

	public void feronHome() {
		driver.get(config.getProperty("url"));
	}

	public void feronlogin() {
		Chrome();
		feronHome();
		click(driver, config.getProperty("login"));
		sendkey(driver, config.getProperty("loginUser"), config.getProperty("user"));
		sendkey(driver, config.getProperty("loginPwd"), config.getProperty("pwd"));
		click(driver, config.getProperty("btnLogin"));
		driver.switchTo().alert().accept();
	}

	public void feronsignup() {
		click(driver, config.getProperty("signup"));
		sendkey(driver, config.getProperty("firstName"), config.getProperty("firstName1"));
		sendkey(driver, config.getProperty("lastName"), config.getProperty("lastName1"));
		sendkey(driver, config.getProperty("email"), config.getProperty("email1"));
		sendkey(driver, config.getProperty("phone"), config.getProperty("phone1"));
		sendkey(driver, config.getProperty("sgpwd"), config.getProperty("sgpwd1"));
		sendkey(driver, config.getProperty("sgconfpwd"), config.getProperty("sgconfpwd1"));
		click(driver, config.getProperty("RegisterBtn"));
		driver.switchTo().alert().accept();
	}

	public void feronPaymentSinglePrdct() throws InterruptedException {
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath(config.getProperty("OnlineProducts"))));
		ac.moveToElement(driver.findElement(By.xpath(config.getProperty("Nephrology")))).click().perform();
		click(driver, config.getProperty("product1"));
		click(driver, config.getProperty("AddtoCart"));
		Thread.sleep(2000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
		click(driver, config.getProperty("cart"));
		Thread.sleep(2000);
		click(driver, config.getProperty("ProceedToCheckout"));

		click(driver, config.getProperty("purpose"));
		{
			WebElement drop=driver.findElement(By.xpath(config.getProperty("purpose")));
			drop.click();
			click(driver, config.getProperty("others"));
		}
		dropdownValue(driver, config.getProperty("location"),config.getProperty("madhapurValue"));
		sendkey(driver, config.getProperty("userTextBox"), config.getProperty("hyd"));
		click(driver, config.getProperty("payBtn"));
		Thread.sleep(4000);
		click(driver, config.getProperty("continueToPay"));
		sendkey(driver, config.getProperty("CardNumber"), config.getProperty("CardNumberValue"));
		sendkey(driver, config.getProperty("CardExpiry"), config.getProperty("CardExpiryValue"));
		sendkey(driver, config.getProperty("CardCVV"), config.getProperty("cardCVVvalue"));
		sendkey(driver, config.getProperty("NameOnCard"), config.getProperty("NameOnCardValue"));
		click(driver, config.getProperty("PayNowButton"));
	}
	public void feronAllProductsAddtoCartTest() throws InterruptedException {
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath(config.getProperty("OnlineProducts"))));
		ac.moveToElement(driver.findElement(By.xpath(config.getProperty("Nephrology")))).click().perform();
		WebElement nextBtn = driver.findElement(By.xpath(config.getProperty("NextBtn")));
		for (int j=1;j<1000;j++) {
			List<WebElement> prdcts = driver.findElements(By.xpath(config.getProperty("AllProducts")));
			Reporter.log(""+prdcts.size(),true);
			for (int i = 1; i <= prdcts.size(); i++) {
				WebElement EchPrdct = driver.findElement(By.xpath("(//h3[1]//a[starts-with(@href,'http://grepthorhosting.com/feron/product_info?id=')])["+i+"]"));
				Reporter.log(EchPrdct.getText(),true);
				EchPrdct.click();
				click(driver, config.getProperty("AddtoCart"));
				Thread.sleep(2000);
				try {
					driver.switchTo().alert().accept();
				} catch (Exception e) {
					e.printStackTrace();
				}
				driver.navigate().back();
			}
			System.out.println("loop term : "+j);
			Thread.sleep(10000);
			if (nextBtn.isDisplayed()) {
				nextBtn.click();
				Reporter.log("Next Button Clicked",true);
			} else {
				continue;
			}
		}
	}

	public void feronpayment() throws InterruptedException {
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath(config.getProperty("OnlineProducts"))));
		ac.moveToElement(driver.findElement(By.xpath(config.getProperty("Nephrology")))).click().perform();
		String[] products = {"Nephrisol","Anthonem"};
		for (int i = 0; i < products.length; i++) {
			List<WebElement> prdcts = driver.findElements(By.xpath(config.getProperty("AllProducts")));
			for (int j = 1; j <= prdcts.size(); j++) {
				WebElement EchPrdct = driver.findElement(By.xpath("(//h3[1]//a[starts-with(@href,'http://grepthorhosting.com/feron/product_info?id=')])["+j+"]"));
				String txt2=EchPrdct.getText();
				Reporter.log(txt2,true);
				if (products[i].equals(txt2)) {
					click(driver, config.getProperty("EchPrdct"));
					click(driver, config.getProperty("AddtoCart"));
					Thread.sleep(2000);
					try {
						driver.switchTo().alert().accept();
					} catch (Exception e) {
						e.printStackTrace();
					}
					driver.navigate().back();
				}
			}
		}
		click(driver, config.getProperty("cart"));
		Thread.sleep(2000);
		click(driver, config.getProperty("ProceedToCheckout"));

		click(driver, config.getProperty("purpose"));
		{
			WebElement drop=driver.findElement(By.xpath(config.getProperty("purpose")));
			drop.click();
			click(driver, config.getProperty("others"));
		}
		sendkey(driver, config.getProperty("location"), config.getProperty("madhapurValue"));
		try {
			ac.keyDown(Keys.ENTER).build();
			ac.keyUp(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sendkey(driver, config.getProperty("userTextBox"), config.getProperty("hyd"));
		click(driver, config.getProperty("payBtn"));
	}
}

