package resources;

public enum APIResources {
	
	//Collection of methods in enum class
	AddPlaceAPI("/maps/api/place/add/json"), // ----->4. After step 3 this string will be extracted and fall to step 5
	getPlaceAPI("/maps/api/place/get/json"),
	deletePLaceAPI("/maps/api/place/delete/json");
	private String resource; //------->6 
	
	APIResources(String resource) // constructor ------> 5 value of AddPlaceAPI will be stored here.This variable is 
	                              // local so we will create global variable and this value will be assigned to step 6
	{
		this.resource= resource;
	}
	public String getResource() {
		return resource; //----->7 this will return step 6
	}

}
