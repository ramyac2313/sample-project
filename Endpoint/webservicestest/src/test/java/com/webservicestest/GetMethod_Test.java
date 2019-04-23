package com.webservicestest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GetMethod_Test {

	public static void main(String[] args) {
		
		Response resp = given().
			    when().
		        get("http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/");
		int code = resp.getStatusCode();
		System.out.println(code);
		
		System.out.println(resp.asString());

	}

}
