package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils{
	
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	Response response;
	static String place_Id; // make it static so all the TCs will share the same variable for that particular run
	
	
	TestDataBuild data = new TestDataBuild();
	@Given("Add Place payload with {string} {string} {string}")
	public void add_Place_payload_with(String name, String language, String address) throws IOException {
	    
		//  write the repetitive response code as below 
		
		 reqSpec = given().spec(requestSpecification()).body(data.addPlacePayload(name,language,address));
	}

	@When("User calls {string} using {string} http request")
			public void user_calls_using_http_request(String resource, String httpMethod) {  //----->2
		
		APIResources resourceAPI = APIResources.valueOf(resource);//--------->3 .Invoke constructor with value of
		                                                          //this resource which is nothing but the value of AddPlcaeAPI that we got from step 1 
		resourceAPI.getResource();                                // this will return AddPlaceAPI
		
		resSpec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(httpMethod.equalsIgnoreCase("POST"))
		 response = reqSpec.when().post(resourceAPI.getResource());
					
		else if(httpMethod.equalsIgnoreCase("GET"))
			 response = reqSpec.when().get(resourceAPI.getResource());
	    
	}

	@Then("Then the API call gets success message with status code {int}")
	public void then_the_API_call_gets_success_message_with_status_code(Integer int1) {
	    assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExpectedValue) {
		
		assertEquals(getJsonPath(response,keyValue),ExpectedValue);
	   
	 }
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_Id_created_maps_to_using(String expectedName, String resource) throws IOException {
	   // requestSpec
		 place_Id= getJsonPath(response,"place_id");
		 reqSpec = given().spec(requestSpecification()).queryParam("place_id", place_Id);
		 user_calls_using_http_request(resource, "GET"); // calling same method as in 
		                                                 //When User calls "AddPlaceAPI" using "POST" http request
		 String actualName= getJsonPath(response,"name");      // This will get us the name from getPlaceAPI response
		 assertEquals(actualName,expectedName);
	}
	
	@Given("DeletePlace payload")
	public void deleteplace_payload() throws IOException {
		reqSpec = given().spec(requestSpecification()).body(data.deletePlacePayload(place_Id)); //this will use the same 
		                                                                              // place_Id as in above step
	    
	}

	

               

}
