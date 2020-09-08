package json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReading {
    public static void main(String[] args) throws ParseException {

    String json = "{\"self\":\"http:\\/\\/jira.dev.ts\\/rest\\/api\\/2\\/customFieldOption\\/13575\"," +
            "\"value\":\"Aliv-ResellerApp\",\"id\":\"13575\"," +
            "\"child\":" +
            "{\"self\":\"http:\\/\\/jira.dev.ts\\/rest\\/api\\/2\\/customFieldOption\\/13577\"," +
            "\"value\":\"aliv-resellerapp-plan-sales\"," +
            "\"id\":\"13577\"}" +
            "}";
        JSONParser parse = new JSONParser();
        JSONObject jobj = (JSONObject)parse.parse(json);
        JSONObject feature = (JSONObject)parse.parse(jobj.get("child").toString());

        System.out.println(jobj.get("value"));
        System.out.println(feature.get("value"));
    }
}
