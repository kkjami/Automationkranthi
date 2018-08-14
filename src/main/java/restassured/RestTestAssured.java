package restassured;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;
import static org.hamcrest.Matchers.*;

public class RestTestAssured {
    Logger log=Logger.getLogger(this.getClass().getName());
    @BeforeMethod
    public void beforeRest() {

//    RestAssured.baseURI ="http://myhost.org";
//    RestAssured.port =80;
//    RestAssured.basePath ="/resource";
//    RestAssured.authentication =basic("username","password");
//    RestAssured.rootPath ="x.y.z";

// JSONObject is a class that represents a simple
// JSON. We can add Key - Value pairs using the put
// method

}

    @Test
    public void noteMe(){
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        /*given().
                config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL))).
                when().
                get("/price").
                then().
                log().all().
                body("price", is(new BigDecimal(12.12)));
   */
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");
        response.then().log().all();
//        httpRequest.given().log().all();
        ResponseBody body = response.getBody();
        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();

        Assert.assertEquals(response.getStatusCode(),200,"validating 200 response code");
        Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK","Correct status code returned");
        log.info(response.getStatusLine());
        log.info(response.header("Content-Type"));
        log.info(response.header("Server"));

        for(Header header : response.getHeaders())
        {
            log.info("Key: " + header.getName() + " Value: " + header.getValue());
        }
        Assert.assertEquals(response.asString().toLowerCase().contains("hyderabad"),true,"Response body contains Hyderabad");
        Assert.assertEquals(jsonPathEvaluator.get("City"), "Hyderabad", "Correct city name received in the Response");

//        body("price",is("hai"));
    }

    @Test
    public void second(){
        RestAssured.baseURI ="http://restapi.demoqa.com/customer";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Virender"); // Cast
        requestParams.put("LastName", "Singh");

        requestParams.put("UserName", "simpleuser001");
        requestParams.put("Password", "password1");
        requestParams.put("Email",  "someuser@gmail.com");
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        Response response = request.post("/register");
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        String successCode = response.jsonPath().get("FaultId");
        Assert.assertEquals( "User already exists", successCode, "OPERATION_SUCCESS");
    }
}
