package com.demoaut.newtours.TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	WebDriver driver ;

	
	@BeforeTest
	public void openBrowser(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.newtours.demoaut.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

}
	@AfterTest
	public void closeBrowser(){
		driver.quit();
	}
}
