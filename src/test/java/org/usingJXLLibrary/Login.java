package org.usingJXLLibrary;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Login {
	String[][] data = null;

	@DataProvider(name = "loginData")
	public String[][] loginDataProvider() throws BiffException, IOException {
		data = getExcelData();
		return data;
	}

	public String[][] getExcelData() throws BiffException, IOException {
		FileInputStream excel = new FileInputStream("‪‪D:\\java\\Java HW\\DemoProject\\Driver\\TestData.xls");
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet sheet = workbook.getSheet(0);
		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();
		String testData[][] = new String[rowCount - 1][columnCount];
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				testData[i - 1][j] = sheet.getCell(j, i).getContents();
			}
		}
		return testData;
	}

	@Test(dataProvider = "loginData")
	public void loginWithBothCorrect(String uName, String Pwd) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys(uName);
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys(Pwd);
		WebElement loginBtn = driver.findElement(By.id("submit"));
		loginBtn.click();
		driver.quit();
	}
}
