package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;

public class APItests {
	
	private String REQUEST_URL="https://www.amazon.com/gp";
	
	@Test
	public void requestMethodGet()
	{
			
		int code=get("https://www.amazon.com/gp/prime/digital-adoption/navigation-bar?type=load&isPrime=false&referrer=https%3A%2F%2Fwww.amazon.com%2F&height=455&width=1436&_=1553533054823").getStatusCode();
	
		System.out.println("Status code is "+code);
		
		Assert.assertEquals(code, 200);
		
	}
	
	@Test
	public void requestMethodPost()
	{
		
		Map<String, Object> payLoad = new HashMap<>();
		payLoad.put("origSessionId", "140-9039571-8741307");
		payLoad.put("subPageType", "");
		payLoad.put("pageType", "Gateway");
		payLoad.put("ASIN", "");
		payLoad.put("path", "%2F");
		payLoad.put("isAUI", "1");
		payLoad.put("referrer", "");
		payLoad.put("queryString", "");
		
		
		Response response = given().
		contentType("application/json").
		accept("application/json").
		body(payLoad).
		when().
		post(REQUEST_URL + "/overlay/display.html").
		then().
		statusCode(200).
		contentType("text/html; charset=UTF-8").
		extract().
		response();
				
		System.out.println("Response "+response);
		
	}
	
}
