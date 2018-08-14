package restbuilder;

import org.eclipse.jetty.http.HttpMethod;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestRequest {
    private String requestbody;
    private String host;
    private String path;
    private String protocol;
    private HttpMethod method;
    private static final String USER_AGENT = "Mozilla/5.0";

    public RestRequest setHost(String host) {
        this.host = host;
        return this;
    }

    public RestRequest setPath(String path) {
        this.path = path;
        return this;
    }

    public RestRequest setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    public RestRequest setRequestType(HttpMethod method) {
        this.method = method;
        return this;
    }

    public RestResponse build() {
        try {
            switch (protocol) {
                case "https":
                    HttpsURLConnection sslConnection = (HttpsURLConnection) new URL(protocol+"://"+host + path).openConnection();
                    sslConnection.setRequestProperty("User-Agent", USER_AGENT);
                    if (method.equals(HttpMethod.GET))
                        sslConnection.setRequestMethod("GET");
                    else if (method.equals(HttpMethod.POST))
                        sslConnection.setRequestMethod("POST");
                    setPostBody(sslConnection);
                    return new RestResponse(sslConnection);
                default:
                    HttpURLConnection connection = (HttpURLConnection) new URL(host + path).openConnection();
                    connection.setRequestProperty("User-Agent", USER_AGENT);
                    if (method.equals(HttpMethod.GET))
                        connection.setRequestMethod("GET");
                    else if (method.equals(HttpMethod.POST))
                        connection.setRequestMethod("POST");
                    setPostBody(connection);
                    return new RestResponse(connection);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setPostBody(HttpsURLConnection sslConnection) {
        sslConnection.setDoOutput(true);
        OutputStream os = null;
        try {
            os = sslConnection.getOutputStream();
            os.write(requestbody.getBytes());
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPostBody(HttpURLConnection connection) {
        connection.setDoOutput(true);
        OutputStream os = null;
        try {
            os = connection.getOutputStream();
            os.write(requestbody.getBytes());
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

