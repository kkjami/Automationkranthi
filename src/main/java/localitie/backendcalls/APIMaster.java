package localitie.backendcalls;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class APIMaster {
    RequestSpecification request;
    Response response;
    static String Authorization;

    public APIMaster() {
        RestAssured.baseURI = "http://localitie.com/locality/";
        request = RestAssured.given();

        request.header("Content-Type", "application/json");
    }

    public String loginrequest() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Virender");
        requestParams.put("LastName", "Singh");

        requestParams.put("UserName", "simpleuser001");
        requestParams.put("Password", "password1");
        requestParams.put("Email", "someuser@gmail.com");
        return requestParams.toJSONString();
    }

    @Test
    public void performlogin() {
        request.body(loginrequest());

        response = request.post("v1/reviewPost");
        Assert.assertEquals(response.getStatusCode(),200);
//        Assert.assertEquals(response.);
    }
    @Test
    public void performloginwithget() {
        request.body(loginrequest());
        response = request.get("v1/reviewPost");
        Assert.assertEquals(response.getStatusCode(),200);
//        Assert.assertEquals(response.);
    }
    @Test
    public void performloginwrogbody() {
        request.body(loginrequest());
//        https://www.udemy.com/rest-api-automation-testing-rest-assured/
        response = request.get("v1/reviewPost");
        Assert.assertEquals(response.getStatusCode(),200);
//        Assert.assertEquals(response.);
    }

    @AfterTest
    public void updateToken() {
        Authorization = response.getHeader("Authorization");
    }
}
