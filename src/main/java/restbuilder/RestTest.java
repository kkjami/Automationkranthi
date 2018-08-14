package restbuilder;

import org.eclipse.jetty.http.HttpMethod;

public class RestTest {
    public static void main(String[] args) {
        RestResponse response = new RestRequest()
                .setRequestType(HttpMethod.GET)
                .setHost("httpbin.org")
                .setPath("/get")
                .setProtocol("https")
                .build();
        response.getResponseCode();
        response.getresponseMessage();
        response.isJson();
    }
}
