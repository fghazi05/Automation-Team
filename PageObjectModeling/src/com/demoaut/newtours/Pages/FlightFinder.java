package com.demoaut.newtours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightFinder {
	private WebDriver driver;

	@FindBy(css = "input[value= 'Business']")
	@CacheLookup
	private WebElement serviceClass;

	@FindBy(name = "airline")
	@CacheLookup
	private WebElement airline;
	
	@FindBy(name = "findFlights")
	@CacheLookup
	private WebElement submit;
	
	

	public FlightFinder(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public void selectPreferences(){
		serviceClass.click();
		Select drpAirline = new Select(airline);
		drpAirline.selectByIndex(1);
		submit.click();
		
	}
}
