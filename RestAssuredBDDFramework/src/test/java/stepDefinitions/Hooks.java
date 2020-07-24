package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		//execute this code only when place Id is null
		
		StepDefinition sd = new StepDefinition();
		
		if(sd.place_Id==null) 
		{
		sd.add_Place_payload_with("Sara", "French", "California");
		sd.user_calls_using_http_request("AddPlaceAPI", "POST");
		sd.verify_place_Id_created_maps_to_using("Sara","getPlaceAPI" );
		}
		
		
		
		
	}
	

}
