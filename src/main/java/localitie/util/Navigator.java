package localitie.util;

import io.appium.java_client.android.AndroidDriver;

public class Navigator {
    AndroidDriver driver = DeviceConnector.getInstance();


    Node tree = new Node();

//    public Navigator() {
//        create(Parentactivity, childactivityname);
//        driver.getSessionDetails();
//    }
//
//    public void create() {
//
//        foreach( row
//        : database){
//        if
//        parent node
//        exists in
//        map
//        get it
//else
//        create it
//        and add
//        it
//
//        if
//        child node
//        exists in
//        map
//        get it
//else
//        create it
//        and add
//        it
//
//        set relationship
//        between parent
//        and child
//    }
    private Boolean hasPath(String source_activity,String destination_activity){
        return false;
    }
    public void navigateTo(String activity_name){
        String activity = driver.currentActivity();
        if(null!=hasPath(activity,activity_name)){
//            getPageObject(activity).back();
        }else
        {
            System.out.println("path dose not exist");
        }
    }

    private String getPageObject(String activity) {
        return "";
    }
}
