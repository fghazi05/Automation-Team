package com.demoaut.newtours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage  {
	WebDriver driver;
	@FindBy(name = "userName") // this is equivalent to private WebElement
								// username = driver.findELement(By.name(""))
	@CacheLookup
	private WebElement username;

	@FindBy(name = "password")
	@CacheLookup
	private WebElement password;

	@FindBy(name = "login")
	@CacheLookup
	private WebElement submit;

	// The same way we can describe the linkText by writing linkText = REGISTER
	// ect. only if we are going to test them . Otherwise no need.
	public HomePage(WebDriver driver) { // This is Constructor. This means the
											// same driver instance should work
											// across all the classes
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void login(String user, String pass) { // this is the method.To avoid
													// hard coding, parameters
													// user and pass are created
													// and their values will be
													// given at the run time
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.click();

	}

}
