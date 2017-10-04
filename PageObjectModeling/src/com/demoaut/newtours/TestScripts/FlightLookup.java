package com.demoaut.newtours.TestScripts;

import org.testng.annotations.Test;

import com.demoaut.newtours.Pages.FlightFinder;
import com.demoaut.newtours.Pages.HomePage;

public class FlightLookup extends BaseTest {
	// WebDriver driver;

	@Test
	public void searchFlight() {
		HomePage hp = new HomePage(driver);
		FlightFinder ff = new FlightFinder(driver);
		hp.login("mercury", "mercury");
		ff.selectPreferences();

	}

}
