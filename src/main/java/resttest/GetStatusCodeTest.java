package resttest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetStatusCodeTest {
String token ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzcmMiOiJXZWIiLCJ1c3IiOiJ7XCJ1aWRcIjpcIndlYmFkbWluXCIsXCJjclwiOlwiMjAxNjIwMTZcIixcInJpZFwiOlwiRElTVDFcIixcInR5cFwiOlwiUkVTRUxMRVJVU0VSXCIsXCJydHBcIjpcImRpc3RyaWJ1dG9yXCIsXCJyb2xcIjpcIlJlc2VsbGVyX2FkbWluXCJ9IiwiaXNzIjoiRVJTMzYwIiwiZXhwIjoxNTMxMTQ5OTM3LCJpYXQiOjE1MzExNDk2Mzd9.5rSA7avYW-iY0Om4q5zzEbpZrzGUkzN-YtjI2qSI0mo";
    HashMap newmap = new HashMap();

    @BeforeClass
    public void setBaseUri () {

        newmap.put("Authorization", token);
        newmap.put("api-key", "BTS");
        RestAssured.baseURI = "http://10.10.0.209:7090";
    }

    @Test
    public void testStatusCode () {

        Response res =
                given ().headers(newmap)
                        .when()
                        .get ("/topupservice/auth/thirdparty/subscriberBalance?msisdn=2429555555");

        Assert.assertEquals (res.statusCode (), 200);
    }

    @Test
    public void testStatusCodeRestAssured () {

        given ().headers(newmap)
                .when()
                .get ("/topupservice/auth/thirdparty/subscriberBalance?msisdn=2429555555")
                .then ()
                .assertThat ().statusCode (200);

    }

    @Test
    public void test01()  {
        Response res = given()
                .headers(newmap)
                .when()
                .get ("/topupservice/auth/thirdparty/subscriberBalance?msisdn=2429555555")
                .then()
                .contentType(ContentType.JSON)
                .extract().response();


        System.out.println(res.asString());

    }
}
