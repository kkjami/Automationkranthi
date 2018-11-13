package localitie.util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class DeviceConnector {
    static ConfigReader config = new ConfigReader();
    private static AndroidDriver driver;

    // Get the only object available
    public static AndroidDriver getInstance() {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    public static void setDriver() {

        DesiredCapabilities desiredcapabilities = new DesiredCapabilities();
        File apk = new File(config.get("apk"));
        desiredcapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredcapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredcapabilities.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        desiredcapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.get("deviceName"));
        desiredcapabilities.setCapability("appPackage", "com.localities");
//        desiredcapabilities.setCapability("appActivity","com.localities");
        try {
            driver = new AndroidDriver<>(new URL(config.get("appiumLink")), desiredcapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }/*catch(ConnectException e){
            System.out.println("appium is down");
        }*/
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println("appium session crated: "+driver.getSessionId().toString());
    }
}
