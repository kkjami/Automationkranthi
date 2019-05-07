package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class PWA {

    private AndroidDriver<WebElement> driver;

    @Test
    public void openPwa() {
        DesiredCapabilities desiredcapabilites = new DesiredCapabilities();
        desiredcapabilites.setCapability("deviceName", "emu");
        desiredcapabilites.setCapability("platformVersion", "8.1");
        desiredcapabilites.setCapability("platformName", "Android");
//        cmp=com.android.chrome/com.google.android.apps.chrome.Main
        desiredcapabilites.setCapability("appPackage", "com.android.dialer");
        desiredcapabilites.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
        //desiredcapabilites.setCapability("file",file.getAbsolutePath());
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredcapabilites);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElementByAndroidUIAutomator(
//                "UiSelector().className(\"android.widget.Button\").instance(0)").click();
//        driver.get("http://gmail.com");
//        driver.findElement(By.id("Email")).sendKeys("testingse2");
        driver.findElement(By.id("next")).click();
        driver.findElement(By.id("Passwd")).sendKeys("selenium345");
        driver.findElement(By.id("signIn")).click();
        driver.quit();
    }
}