package com.demoaut.newtours.TestScripts;

import org.testng.annotations.Test;

import com.demoaut.newtours.Pages.FlightFinder;
import com.demoaut.newtours.Pages.HomePage;
import com.demoaut.newtours.Pages.SelectFlight;

public class FlightSelection extends BaseTest {
	// WebDriver driver;

	@Test
	public void pickFlight() {
		HomePage hp = new HomePage(driver);
		FlightFinder ff = new FlightFinder(driver);
		SelectFlight sf = new SelectFlight(driver);
		hp.login("mercury", "mercury");
		ff.selectPreferences();
		sf.chooseFlight();

	}

}
