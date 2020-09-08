package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PWA {

    private AndroidDriver<WebElement> driver;

    @Test
    public void openPwa() {
        ChromeOptions chromeOptions=new ChromeOptions();
        DesiredCapabilities desiredcapabilites = new DesiredCapabilities();
        desiredcapabilites.setCapability("deviceName", "emu");
        desiredcapabilites.setCapability("platformVersion", "6.0.1");
        desiredcapabilites.setCapability("platformName", "Android");
        desiredcapabilites.setCapability("appPackage", "com.sec.android.app.launcher");
        desiredcapabilites.setCapability("appActivity", "com.android.launcher2.LauncherProvider");
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredcapabilites);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("UiSelector().text(\"Aliv\")").click();
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        driver.context(contextNames.toArray()[1].toString()); // set

        driver.context("NATIVE_APP");
        driver.quit();
    }
}