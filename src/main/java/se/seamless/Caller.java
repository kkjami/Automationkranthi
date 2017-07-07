package se.seamless;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kranthikumar on 06/07/17.
 */
public class Caller {

    public DesiredCapabilities dc;
    public AndroidDriver<WebElement> driver;
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    AppPropertyLoader paths=new AppPropertyLoader();
    private static boolean isconfigured=false;

    @BeforeTest(groups = {"app"})
    public void init() throws MalformedURLException {
        dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "AdDevice");
        dc.setCapability("platformVersion", "7.0");
        dc.setCapability("platformName", "Android");
        dc.setCapability("appPackage", "com.seamless.newco");
        dc.setCapability("appActivity", ".activity.SplashScreenActivity");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        sleepfor(5000);
    }

    @AfterTest
    public void afterTest() throws Exception {
        Thread.sleep(10000);
        driver.quit();
    }

    private void configureServerSucessfully() {
        click("login.settings");
        enterTextToField("appsettings.serveraddr","http://phoenix01.dev.ts");
        enterTextToField("appsettings.port","7090");
        enterTextToField("appsettings.agent","DIST1");
        enterTextToField("appsettings.loginid","webuser");
        enterTextToField("appsettings.password","20162016");
        click("appsettings.save");

        isconfigured=true;
    }

    public void enterTextToField(String propertyKeyOfPath,String Data){
        driver.findElementByAndroidUIAutomator(paths.giveProperty(propertyKeyOfPath)).sendKeys(Data);
        driver.navigate().back();
    }

    public void click(String ClickLocation){
        driver.findElementByAndroidUIAutomator(paths.giveProperty(ClickLocation)).click();
    }

    public void alertoperation(String optionPath){
        String currentContext = driver.getContext();
        driver.context("NATIVE_APP");
        driver.findElementByAndroidUIAutomator(paths.giveProperty(optionPath)).click();
        driver.context(currentContext);
    }

    public void sleepfor(int timeinms){
        try {
            Thread.sleep(timeinms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(!isconfigured){
            configureServerSucessfully();
        }
    }

}
