package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kranthi on 07-07-2017.
 */
public class CommonToolsForApp {

    DesiredCapabilities desiredcapabilites;
    AndroidDriver<WebElement> driver;

    @BeforeTest
    public void setup() {
        File file=new File("D:\\Whats app\\WhatsApp.apk");
        desiredcapabilites = new DesiredCapabilities();
        desiredcapabilites.setCapability("deviceName", "AEmulator");
        desiredcapabilites.setCapability("platformVersion", "6.0");
        desiredcapabilites.setCapability("platformName", "Android");
        desiredcapabilites.setCapability("appPackage", "com.android.dialer");
        desiredcapabilites.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
        //desiredcapabilites.setCapability("file",file.getAbsolutePath());
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredcapabilites);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void teardown() {
        //driver.closeApp();
        driver.quit();
    }
}
