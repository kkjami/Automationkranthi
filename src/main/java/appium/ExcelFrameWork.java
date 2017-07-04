package appium;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * Created by Kranthi on 01-07-2017.
 */
public class ExcelFrameWork {

    private DesiredCapabilities desiredcapabilites;
    private AndroidDriver<WebElement> driver;
    private final static Logger log = Logger.getLogger(ExcelFrameWork.class);

    @BeforeTest
    public void setup() {
        desiredcapabilites = new DesiredCapabilities();
        desiredcapabilites.setCapability("deviceName", "AEmulator");
        desiredcapabilites.setCapability("platformVersion", "6.0");
        desiredcapabilites.setCapability("platformName", "Android");
        desiredcapabilites.setCapability("browserName", "Chrome");
    }

    @AfterTest
    public void TearDown() {
        driver.quit();
    }

    @Test
    public void executingExcelTests() throws MalformedURLException {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredcapabilites);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator(
                "UiSelector().className(\"android.widget.TextView\").instance(8)").click();
            log.info(driver.getPageSource());
        }
    }
