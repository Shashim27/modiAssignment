package ASSignmmentMOdi.ASSignmmentMOdi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
mport io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import Files.payLoad;


import org.junit.Assert;


import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://gorest.co.in/";
		String accessToken="d38fc18e808ab7bb9e21b9ce756dd3ce01eac40d9f8ad697fff3a8f0de282d7c";
		
		//post request
		String response=given().queryParam("access_token", accessToken).header("Content-Type", "application/json")
				
				.body(payLoad.AddPlace())
						.when().log().all().post("POST /public/v2/users").then().assertThat().statusCode(200).body("id[0].name", equalTo("AbulHashim"))		
		.extract().response().asString();
		
		System.out.println(response);
		
		//put request for update 
		String name="pollob";
		
		String response1=given().queryParam("access_token", accessToken).header("Content-Type", "application/json")
		
		.body("{[\r\n"
				+ "  {\r\n"
				+ "    \"id\": 5217,\r\n"
				+ "    \"name\": \""+ name+"\",\r\n"
				+ "    \"email\": \"deependra_gupta@senger-mertz.com\",\r\n"
				+ "    \"gender\": \"male\",\r\n"
				+ "    \"status\": \"inactive\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"id\": 5216,\r\n"
				+ "    \"name\": \"Chandrakin Khatri\",\r\n"
				+ "    \"email\": \"chandrakin_khatri@fisher-lakin.io\",\r\n"
				+ "    \"gender\": \"female\",\r\n"
				+ "    \"status\": \"active\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"id\": 5215,\r\n"
				+ "    \"name\": \"Esha Gandhi\",\r\n"
				+ "    \"email\": \"gandhi_esha@abernathy.name\",\r\n"
				+ "    \"gender\": \"female\",\r\n"
				+ "    \"status\": \"inactive\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"id\": 5214,\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"email\": \"agrata_mehra_dds@brown.org\",\r\n"
				+ "    \"gender\": \"female\",\r\n"
				+ "    \"status\": \"active\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"id\": 5213,\r\n"
				+ "    \"name\": \"Fr. Deevakar Kaniyar\",\r\n"
				+ "    \"email\": \"deevakar_fr_kaniyar@rowe-pollich.org\",\r\n"
				+ "    \"gender\": \"female\",\r\n"
				+ "    \"status\": \"inactive\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"id\": 5212,\r\n"
				+ "    \"name\": \"Saroja Talwar\",\r\n"
				+ "    \"email\": \"talwar_saroja@damore-pagac.net\",\r\n"
				+ "    \"gender\": \"male\",\r\n"
				+ "    \"status\": \"inactive\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"id\": 5211,\r\n"
				+ "    \"name\": \"Shakuntala Menon\",\r\n"
				+ "    \"email\": \"menon_shakuntala@macgyver.name\",\r\n"
				+ "    \"gender\": \"male\",\r\n"
				+ "    \"status\": \"inactive\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"id\": 5210,\r\n"
				+ "    \"name\": \"Dr. Rukhmani Ahuja\",\r\n"
				+ "    \"email\": \"ahuja_dr_rukhmani@corkery-dickens.net\",\r\n"
				+ "    \"gender\": \"male\",\r\n"
				+ "    \"status\": \"inactive\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"id\": 5209,\r\n"
				+ "    \"name\": \"Miss Vasudha Iyer\",\r\n"
				+ "    \"email\": \"miss_iyer_vasudha@daugherty-batz.biz\",\r\n"
				+ "    \"gender\": \"male\",\r\n"
				+ "    \"status\": \"active\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"id\": 5208,\r\n"
				+ "    \"name\": \"Nimit Joshi\",\r\n"
				+ "    \"email\": \"nimit_joshi@lindgren.com\",\r\n"
				+ "    \"gender\": \"female\",\r\n"
				+ "    \"status\": \"inactive\"\r\n"
				+ "  }\r\n"
				+ "]}")
				.when().put("PUT /public/v2/users").then().log().all().assertThat()
				.statusCode(200).body("msg",equalTo( "name")).extract().response().asString();
		
		System.out.println(response1);
		
		//getplaceApi
		
		
		
		
		JsonPath js1=new JsonPath(response1);
		String actualName=js1.getString("name[3]");
		System.out.println(actualName);
		//verifying with testng
		Assert.assertEquals(actualName, name);
		
		
		//Deleteplacess api
		
		String deleteplaceApi=given().log().all().queryParam("access_token", accessToken).header("Content-Type", "application/json")
				.when().delete("DELETE /public/v2/users/1").then().assertThat().log().all().statusCode(200).body("msg", equalTo("Deleted successfully")).extract().response().asString();
		System.out.println(deleteplaceApi);
			
		
		
		
	}
	}

