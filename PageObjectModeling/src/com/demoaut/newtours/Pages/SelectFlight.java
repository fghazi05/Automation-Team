package com.demoaut.newtours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlight {
	private WebDriver driver;

	@FindBy(name = "outFlight")
	@CacheLookup
	private WebElement depart;

	@FindBy(name="inFlight")
	@CacheLookup
	private WebElement back;
	
	@FindBy(name="reserveFlights")
	@CacheLookup
	private WebElement Continue;

	public SelectFlight(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public void chooseFlight(){
		depart.click();
		back.click();
		Continue.click();
	}
	
	
	
	
	
	
	
	
	
}










