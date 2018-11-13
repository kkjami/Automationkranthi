package localitie.util;

import java.util.HashMap;
import java.util.Map;

public class ConfigReader {
    private Map<String,String> configs= new HashMap<>();
    public ConfigReader(){
        configs.put("deviceName","73efd247");
        configs.put("appiumLink","http://127.0.01:4723/wd/hub");
        configs.put("apk","/Users/kranthikumar/Downloads/locality_06_Nov.apk");
    }

    public String get(String Item){
        return configs.get(Item);
    }
}
