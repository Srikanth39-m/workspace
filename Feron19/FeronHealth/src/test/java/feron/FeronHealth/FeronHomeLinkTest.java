/*
 * package feron.FeronHealth;
 * 
 * import java.io.IOException; import java.util.concurrent.TimeUnit;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement; import
 * org.openqa.selenium.chrome.ChromeDriver; import org.testng.Reporter; import
 * org.testng.annotations.Test;
 * 
 * public class FeronHomeLinkTest { public FeronHomeLinkTest() th
 * 
 * @Test public void Links() throws InterruptedException {
 * System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
 * WebDriver driver=new ChromeDriver(); driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * driver.manage().deleteAllCookies(); openurl(driver,
 * config.getProperty("url")); Reporter.log("Feron Launched",true);
 * 
 * Thread.sleep(3000); Reporter.log("------Top links",true); click(driver,
 * config.getProperty("home")); if
 * ("http://grepthorhosting.com/feron/".equals(driver.getCurrentUrl())) {
 * Reporter.log("HOME Passed",true); }else { Reporter.log("HOME Failed",true); }
 * driver.navigate().back(); click(driver, config.getProperty("aboutus")); if
 * ("http://grepthorhosting.com/feron/about_Us".equals(driver.getCurrentUrl()))
 * { Reporter.log("ABOUT US Passed",true); }else {
 * Reporter.log("ABOUT US Failed",true); } driver.navigate().back();
 * click(driver, config.getProperty("contactus")); if
 * ("http://grepthorhosting.com/feron/contact".equals(driver.getCurrentUrl())) {
 * Reporter.log("CONTACT US Passed",true); }else {
 * Reporter.log("CONTACT US Failed",true); } driver.navigate().back();
 * click(driver, config.getProperty("signup")); if
 * ("http://grepthorhosting.com/feron/register".equals(driver.getCurrentUrl()))
 * { Reporter.log("SIGNUP Passed",true); }else {
 * Reporter.log("SIGNUP Failed",true); } driver.navigate().back(); click(driver,
 * config.getProperty("login")); if
 * ("http://grepthorhosting.com/feron/login".equals(driver.getCurrentUrl())) {
 * Reporter.log("LOGIN Passed",true); }else { Reporter.log("LOGIN Failed",true);
 * } driver.navigate().back();
 * 
 * click(driver, config.getProperty("login")); sendkey(driver,
 * config.getProperty("loginUser"), config.getProperty("user")); sendkey(driver,
 * config.getProperty("loginPwd"), config.getProperty("pwd")); click(driver,
 * config.getProperty("btnLogin")); driver.switchTo().alert().accept();
 * click(driver, config.getProperty("afterlogin")); WebElement UserProfile =
 * driver.findElement(By.xpath(config.getProperty("profile"))); if
 * (UserProfile.isDisplayed()) { Reporter.log("User login Passed",true); }else {
 * Reporter.log("User login Failed",true); }
 * 
 * 
 * Reporter.log("------Cart & Wishlist",true); click(driver,
 * config.getProperty("cart")); if
 * ("http://grepthorhosting.com/feron/cart".equals(driver.getCurrentUrl())) {
 * Reporter.log("Cart Passed",true); }else { Reporter.log("Cart Failed",true); }
 * driver.navigate().back();
 * 
 * click(driver, config.getProperty("wishlist")); if
 * ("http://grepthorhosting.com/feron/wishlist".equals(driver.getCurrentUrl()))
 * { Reporter.log("Wishlist Passed",true); }else {
 * Reporter.log("Wishlist Failed",true); } driver.navigate().back();
 * 
 * Reporter.log("------Bottom quick links",true);
 * 
 * click(driver, config.getProperty("qhome")); if
 * ("http://grepthorhosting.com/feron/#".equals(driver.getCurrentUrl())) {
 * Reporter.log("Home Passed",true); }else { Reporter.log("Home Failed",true); }
 * driver.navigate().back();
 * 
 * click(driver, config.getProperty("qaboutus")); if
 * ("http://grepthorhosting.com/feron/about_Us".equals(driver.getCurrentUrl()))
 * { Reporter.log("About us Passed",true); }else {
 * Reporter.log("About us Failed",true); } driver.navigate().back();
 * 
 * // click(driver, config.getProperty("qcareers")); // if
 * ("".equals(driver.getCurrentUrl())) { // Reporter.log("Careers Passed",true);
 * // }else { // Reporter.log("Careers Failed",true); // } //
 * driver.navigate().back();
 * 
 * 
 * Reporter.log("Carees page not Created",true); click(driver,
 * config.getProperty("qcontacus")); if
 * ("http://grepthorhosting.com/feron/contact".equals(driver.getCurrentUrl())) {
 * Reporter.log("Contact us Passed",true); }else {
 * Reporter.log("Contact us Failed",true); } driver.navigate().back();
 * 
 * 
 * Reporter.log("------Top Social Media links",true); click(driver,
 * config.getProperty("Tfacebook")); Reporter.log(driver.getCurrentUrl(),true);
 * if
 * ("https://www.facebook.com/FERON-healthcare-103652767688190/?modal=admin_todo_tour"
 * .equals(driver.getCurrentUrl())) { Reporter.log("Facebook Passed",true);
 * }else { Reporter.log("Facebook Failed",true); } driver.navigate().back();
 * 
 * click(driver, config.getProperty("Ttwitter"));
 * Reporter.log(driver.getCurrentUrl(),true); if
 * ("https://twitter.com/feronhealthcare".equals(driver.getCurrentUrl())) {
 * Reporter.log("twitter Passed",true); }else {
 * Reporter.log("twitter Failed",true); } driver.navigate().back();
 * 
 * click(driver, config.getProperty("Tinstagram"));
 * Reporter.log(driver.getCurrentUrl(),true); if
 * ("https://www.instagram.com/accounts/login/?hl=en".equals(driver.
 * getCurrentUrl())) { Reporter.log("Wishlist Passed",true); }else {
 * Reporter.log("Wishlist Failed",true); } driver.navigate().back();
 * 
 * click(driver, config.getProperty("Ttumblr"));
 * Reporter.log(driver.getCurrentUrl(),true); if
 * ("https://www.tumblr.com/login".equals(driver.getCurrentUrl())) {
 * Reporter.log("tumblr Passed",true); }else {
 * Reporter.log("tumblr Failed",true); } driver.navigate().back();
 * 
 * 
 * Reporter.log("------Bottom Social Media links",true); click(driver,
 * config.getProperty("Bfacebook")); Reporter.log(driver.getCurrentUrl(),true);
 * if
 * ("https://www.facebook.com/FERON-healthcare-103652767688190/?modal=admin_todo_tour"
 * .equals(driver.getCurrentUrl())) { Reporter.log("Facebook Passed",true);
 * }else { Reporter.log("Facebook Failed",true); } driver.navigate().back();
 * 
 * click(driver, config.getProperty("Btwitter"));
 * Reporter.log(driver.getCurrentUrl(),true); if
 * ("https://twitter.com/feronhealthcare".equals(driver.getCurrentUrl())) {
 * Reporter.log("twitter Passed",true); }else {
 * Reporter.log("twitter Failed",true); } driver.navigate().back();
 * 
 * click(driver, config.getProperty("Binstagram"));
 * Reporter.log(driver.getCurrentUrl(),true); if
 * ("https://www.instagram.com/accounts/login/?hl=en".equals(driver.
 * getCurrentUrl())) { Reporter.log("Wishlist Passed",true); }else {
 * Reporter.log("Wishlist Failed",true); } driver.navigate().back();
 * 
 * click(driver, config.getProperty("Btumblr"));
 * Reporter.log(driver.getCurrentUrl(),true); if
 * ("https://www.tumblr.com/login".equals(driver.getCurrentUrl())) {
 * Reporter.log("tumblr Passed",true); }else {
 * Reporter.log("tumblr Failed",true); } driver.navigate().back();
 * 
 * 
 * 
 * 
 * } }
 * 
 * 
 * 
 */