package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	// When we declare a variable static that variable will be shared 
	// across all the test cases for that entire execution otherwise java will make it null for
	// the second TC execution
	// For ex if we dont make it static when first time run, all the five variables will be initialized 
	// but for second TC it will all become null.But when variable is null after first run it will not 
	// become null and will be available for further test case execution until its all done. So the results of second tC 
	// will not replace the results of first TC.  
	
	
	
	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException {
		
		if(req==null) { //write this step to prevent the control to go inside multiple times with each data set
		
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		 req =new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
		.addQueryParam("key", "qaclick123")
		.addFilter(RequestLoggingFilter.logRequestTo(log))
		.addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
		 return req;
	}
		return req;
	}	
	
	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\tarag\\eclipse-workspace\\RestAssuredBDDFramework\\src\\test\\java\\resources\\Global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	public String getJsonPath(Response response, String key) {
		String responseString = response.asString();
		JsonPath js = new JsonPath(responseString);
		return js.get(key).toString();
				
	}
	
	
	
	
	
	
	

}
