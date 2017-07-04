package appium;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by Kranthi on 02-07-2017.
 */
public class Contacts {

    AndroidDriver<WebElement> driver;
    DesiredCapabilities desiredcapabilities;
    Logger log= Logger.getLogger(Contacts.class);
    @BeforeTest
    public void setup() throws MalformedURLException {
        desiredcapabilities = new DesiredCapabilities();
        desiredcapabilities.setCapability("platformName","Android");
        desiredcapabilities.setCapability("PlatformVersion","6.0");
        desiredcapabilities.setCapability("deviceName","AEmulator");
        desiredcapabilities.setCapability("appPackage","com.android.contacts");
        desiredcapabilities.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");
    }
    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }

    @Test
    public void openAndValidateMainScreenComponents() throws MalformedURLException {
        driver= new AndroidDriver<>(new URL("http://127.0.01:4723/wd/hub"),desiredcapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator(
                "UiSelector().className(\"android.widget.Button\").instance(0)").click();
        List<WebElement> list=driver.findElements(By.className("android.widget.EditText"));
        for (int i = 0; i < list.size(); i++) {
            log.info(list.get(i).getTagName());
            log.info(i);
        }
    }
}
