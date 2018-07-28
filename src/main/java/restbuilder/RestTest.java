package restbuilder;

import org.eclipse.jetty.http.HttpMethod;

public class RestTest {
    public static void main(String[] args) {
        RestResponse response = new RestRequest()
                .setRequestType(HttpMethod.POST)
                .setHost(args[0])
                .setPath(args[1])
                .setProtocol(args[3])
                .build();
        response.getResponseCode();
        response.getresponseMessage();
        response.isJson();
    }
}
