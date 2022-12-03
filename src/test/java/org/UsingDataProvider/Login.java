package org.UsingDataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	String [][] data={
			{"student","Password123"},
			{"student","dummy"},
			{"dummy","Password123"},
			{"dummy","dummy"}
	    	};
		@DataProvider(name="loginData")
		public String[][] loginDataProvider() {
			return data;
		}
		@Test(dataProvider="loginData")
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
