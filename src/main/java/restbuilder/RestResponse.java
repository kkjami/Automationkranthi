package restbuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.stream.Collectors;

public class RestResponse {
    int responseCode;
    StringBuffer responseBody = new StringBuffer(); ;

    public RestResponse(HttpURLConnection connection) {
        try {
            responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                responseBody.append(in.lines().collect(Collectors.joining()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RestResponse(HttpsURLConnection sslConnection) {
        try {
            responseCode = sslConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        sslConnection.getInputStream()));
                responseBody.append(in.lines().collect(Collectors.joining()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getresponseMessage() {
        return responseBody.toString();
    }

    public Boolean isJson() {
        return false;
    }
}