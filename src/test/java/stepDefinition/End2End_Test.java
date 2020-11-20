package stepDefinition;
import java.util.List;
import java.util.Map;
 
import org.junit.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class End2End_Test {
	 
	 private static String token;
	 private static Response response;
	 private static String jsonString;


	 @Given("Latest Currency Conversion API Available")
	 public void CheckAPIAvalability() {

	 RestAssured.baseURI = "https://api.ratesapi.io/api/latest";
	
	 }
	 
	 @When("User Run Latest Currency Conversion API")
	 public void RunLatestCurrencyConversionAPI() {
		 try{
		 RestAssured.baseURI = "https://api.ratesapi.io/api/latest";
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.request(Method.GET,"?base=USD");
		 String responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + responseBody);
		 }
		 catch(Exception e)
		 {
			 
			System.out.println(response.getBody().asString());
		 }
		 
	 }
	 
	 @When("User Run Specific date Foreign Exchange API")
	 public void SpecificDateRangeExchangeAPIAPI() {
		 try{
		 RestAssured.baseURI = "https://api.ratesapi.io/api";
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.request(Method.GET,"/2010-01-12?base=USD&symbols=GBP");
		 String responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + responseBody);
		 }
		 catch(Exception e)
		 {
			 
			System.out.println(response.getBody().asString());
		 }
	 }
	 
	 
	 
	 @Then("Valid success code")
	 public void ValidateStatusCode() {
	int statusCode = response.getStatusCode();
    Assert.assertSame(200, statusCode);
	
		 }
	 
	 @Then("Validate invalid status code")
	 public void InvalidStatuscode() {
		 int statusCode = response.getStatusCode();
		 
	Assert.assertSame(400, statusCode);
	
		 }
	 
	 
	 @When("User Run Latest Currency Conversion API With multiple symbol")
	 public void ValidateCurrencyConversionAPIWithmultiplesymbol() {
		 try{
		 RestAssured.baseURI = "https://api.ratesapi.io/api/latest";
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.request(Method.GET,"?symbols=USD,GBP");
		 String responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + responseBody);;
	 
		 }
		 catch(Exception e)
		 {
			 
			System.out.println(response.getBody().asString());
		 }
	 }
	 
	 @When("User Run Specific date Foreign Exchange API With valid parameters")
	 public void ValidateSpecificDateAPIwithValidpara() {
		 try{
		 RestAssured.baseURI = "https://api.ratesapi.io/api";
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.request(Method.GET,"/2010-01-12?symbols=USD,GBP");
		 String responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + responseBody);
		 }
		 catch(Exception e)
		 {
			 
			System.out.println(response.getBody().asString());
		 }
	 
	 
	 }
	 @When("User Run Latest Currency Conversion API With  valid base passed")
	 public void ValidateCurrencyConversionAPIWithvalidBase() {
		 try{
		 RestAssured.baseURI = "https://api.ratesapi.io/api/latest";
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.request(Method.GET,"?base=USD");
		 String responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + responseBody);;
		 }
		 catch(Exception e)
		 {
			 
			System.out.println(response.getBody().asString());
		 }
	 
	 }
	 
	 @When("User Run Latest Currency Conversion API With  invalid base and symbol passed")
	 public void ValidateCurrencyConversionAPIWithvalidBaseandsymbol() {
		 try{
		 RestAssured.baseURI = "https://api.ratesapi.io/api/latest";
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.request(Method.GET,"?base=USSD&symbols=GBBP");
		 String responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + responseBody);
		 }
		 catch(Exception e)
		 {
			 
			System.out.println(response.getBody().asString());
		 }
	 
	 
	 }
	 
	 @And("Validate Response Body")
	 
		 public void ResponseBodayValidation()
		 {
		 try{
		 RestAssured.baseURI = "https://api.ratesapi.io/api/latest";
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.request(Method.GET,"?base=USD&symbols=GBP");
		 String responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + responseBody); 
		 ResponseBody body = response.getBody();
         String bodyStringValue = body.asString();
         Assert.assertTrue(bodyStringValue.contains("USD"));
		 
		 }
	 catch(Exception e)
	 {
		 
		System.out.println(response.getBody().asString());
	 }
		 }
		 
	 
	 @And("Validate Response Body For Specfic Date API")
	 
	 public void ResponseBodayValidationForSpecificDateAPI()
	 {
		 try{
	 RestAssured.baseURI = "https://api.ratesapi.io/api/";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.request(Method.GET,"/2010-01-12?base=USD&symbols=GBP");
	 String responseBody = response.getBody().asString();
	 System.out.println("Response Body is =>  " + responseBody); 
	 ResponseBody body = response.getBody();
     String bodyStringValue = body.asString();
     Assert.assertTrue(bodyStringValue.contains("USD"));
	 }		 
	 catch(Exception e)
	 {
		 
		System.out.println(response.getBody().asString());
	 }
		 }
	 
 @And("Validate Response Body For Specfic Date API for Future Date")
	 
	 public void ResponseBodayValidationForSpecificDateAPIForFutureDate()
	 {
	 try{
	 RestAssured.baseURI = "https://api.ratesapi.io/api/";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.request(Method.GET,"/2021-01-12?base=USD&symbols=GBP");
	 String responseBody = response.getBody().asString();
	 System.out.println("Response Body is =>  " + responseBody); 
	 ResponseBody body = response.getBody();
     String bodyStringValue = body.asString();
     Assert.assertTrue(bodyStringValue.contains("2020-11-19")); //current date
	 }
	  
 catch(Exception e)
 {
	 
	System.out.println(response.getBody().asString());
 }
	 }
 
 
	 @When("Validate API when incorrect URL is passed")
	 
	 public void ValidateAPIwithIncorrectURL()
	 {
		 try{
	 RestAssured.baseURI = "https://api.ratesapi.io/api";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.request(Method.GET,"?base=USD");
	 String responseBody = response.getBody().asString();
	 System.out.println("Response Body is =>  " + responseBody);
	 }
    catch(Exception e)
	 {
		 
		System.out.println(response.getBody().asString());
	 }
		 }
	 }
	 
	

