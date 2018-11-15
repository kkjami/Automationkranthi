package localitie.util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class DeviceConnector {
    private static ConfigReader config = new ConfigReader();
    private static AndroidDriver androidDriver;
    private Logger log = Logger.getLogger(this.getClass().getName());

    // Get the only object available
    public static AndroidDriver getInstance() {
        if (androidDriver == null) {
            androidDriver = (new DeviceConnector()).setDriver();
        }
        return androidDriver;
    }

    private AndroidDriver setDriver() {

        DesiredCapabilities desiredcapabilities = new DesiredCapabilities();
        File apk = new File(config.get("apk"));
        desiredcapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredcapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
        desiredcapabilities.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        desiredcapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.get("deviceName"));
//        desiredcapabilities.setCapability("appPackage", "com.localities");
//        desiredcapabilities.setCapability("appActivity","com.localities");
        try {
            androidDriver = new AndroidDriver<>(new URL(config.get("appiumLink")), desiredcapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }/*catch(ConnectException e){
            System.out.println("appium is down");
        }*/
        androidDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        log.info("appium session crated: " + androidDriver.getSessionId().toString());
        log.info("network bitmask: " + androidDriver.getConnection().getBitMask());
        log.info("appium session created: " + androidDriver.getConnection().isWiFiEnabled());
        return androidDriver;
    }
}
