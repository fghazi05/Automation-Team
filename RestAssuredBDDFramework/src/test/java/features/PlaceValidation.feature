Feature: Validating Place APIs
 @AddPlace @Regression
 Scenario Outline: Verify if Place is successfully added using AddPlace API
  Given Add Place payload with "<name>" "<language>" "<address>"
  When User calls "AddPlaceAPI" using "POST" http request        
  Then Then the API call gets success message with status code 200
  And "status" in response body is "OK"
  And verify place_Id created maps to "<name>" using "getPlaceAPI"
  
  Examples:
  | name | language | address   |
  | Dua  | English  | Chicago IL|
  | Emaan| Spanish  | Paramus NJ|
  
  @DeletePlace @Regression
  Scenario: To verify if Delete API functionality is working
  
  Given DeletePlace payload
  When User calls "deletePLaceAPI" using "POST" http request 
  Then Then the API call gets success message with status code 200
  And "status" in response body is "OK"
  
