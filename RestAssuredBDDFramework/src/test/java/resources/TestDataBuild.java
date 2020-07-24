package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayload(String name, String language, String address) {
	
	AddPlace aP = new AddPlace();
	aP.setAccuracy(50);
	aP.setAddress(address);
	aP.setLanguage(language);
	aP.setName(name);
	aP.setPhone_number("2452824657");
	aP.setWebsite("www.trainingrite.com");
	
	Location l = new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	aP.setLocation(l);
	
	List<String> myList = new ArrayList<String>();
	myList.add("shoe park");
	myList.add("shop");
	aP.setTypes(myList); 
	return aP;
	

}
	public String deletePlacePayload(String placeId) {
		
		return "{\r\n\"place_id\":\""+placeId+"\"\r\n}";
		    
		
		
		
	}
}