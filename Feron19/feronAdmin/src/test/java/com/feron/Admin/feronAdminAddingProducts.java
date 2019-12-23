package com.feron.Admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.main.nextClick.MainTest;

public class feronAdminAddingProducts extends MainTest {
  @Test
  public void f() throws IOException {
	  File src=new File("./properties/FeronAdminData.xlsx");
	  FileInputStream fi=new FileInputStream(src);
	  XSSFWorkbook wb=new XSSFWorkbook(fi);
	  XSSFSheet sh=wb.getSheetAt(0);
	  int rc=sh.getLastRowNum();
	  feronAdminLaunch();
	  click(driver, config.getProperty("ProductList"));
	  click(driver, config.getProperty("AddProduct"));
//	  click(driver, config.getProperty("Online"));
	  for (int i = 1; i <= rc; i++) {
		  try {
			  click(driver, config.getProperty("Offline"));
			  sendkey(driver, config.getProperty("ProductName"), sh.getRow(i).getCell(0).getStringCellValue());
			  driver.findElement(By.xpath(config.getProperty("ProductTypeDrop"))).sendKeys(sh.getRow(i).getCell(1).getStringCellValue());
			  click(driver, config.getProperty("CategoryNameDrop"));
			  driver.findElement(By.xpath(config.getProperty("CategoryNameDrop"))).sendKeys(sh.getRow(i).getCell(2).getStringCellValue());
			  sendkeyNum(driver, config.getProperty("QuantityPerPack"),sh.getRow(i).getCell(3).getNumericCellValue());
			  sendkeyNum(driver, config.getProperty("Price"), sh.getRow(i).getCell(4).getNumericCellValue());
			  sendkeyNum(driver, config.getProperty("GST"), sh.getRow(i).getCell(5).getNumericCellValue());
			  sendkeyNum(driver, config.getProperty("Discount"), sh.getRow(i).getCell(6).getNumericCellValue());
			  sendkeyNum(driver, config.getProperty("Quantity"), sh.getRow(i).getCell(7).getNumericCellValue());
			  driver.switchTo().frame(0);
			  click(driver, config.getProperty("Discription"));
			  sendkey(driver, config.getProperty("Discription"), sh.getRow(i).getCell(8).getStringCellValue());
			  driver.switchTo().defaultContent();
			  try {
				sendkey(driver, config.getProperty("ChooseFile"), sh.getRow(i).getCell(9).getStringCellValue());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		  click(driver, config.getProperty("Submit"));

		  try {
			WebElement errMsg = driver.findElement(By.xpath("//h1[text()='A Database Error Occurred']"));
			  if (errMsg.isDisplayed()) {
				driver.navigate().back();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			  click(driver, config.getProperty("AddProduct"));
			  System.out.println(sh.getRow(i).getCell(0).getStringCellValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  }
}
