package org.UsingTestNGParameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BothIncorrect {
	@Test
	@Parameters({"username","password"})   
	public void loginWithBothIncorrect(String uName, String Pwd) {
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
