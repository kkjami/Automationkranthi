package nativeapp.android;

import io.appium.java_client.android.AndroidDriver;
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
    private boolean isconfigured=true;

    @BeforeTest(groups = {"app"})
    public void init() throws MalformedURLException {
        dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "AdDevice");
        dc.setCapability("platformVersion", "7.0");
        dc.setCapability("platformName", "Android");
        dc.setCapability("appPackage", "");
        dc.setCapability("appActivity", "");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        sleepfor(5000);
    }

    @AfterTest
    public void afterTest() throws Exception {
        Thread.sleep(10000);
        driver.quit();
    }

    private void configureServerSucessfully() {
        clickon("login.settings");
        enterTextToField("appsettings.serveraddr","http://localhost");
        enterTextToField("appsettings.port","7090");
        enterTextToField("appsettings.agent","agent");
        enterTextToField("appsettings.loginid","loginid");
        enterTextToField("appsettings.password","password");
        clickon("appsettings.save");

        isconfigured=true;
    }

    public void enterTextToField(String propertyKeyOfPath,String Data){

        driver.findElementByAndroidUIAutomator(paths.giveProperty(propertyKeyOfPath)).sendKeys(Data);
        driver.findElementByAndroidUIAutomator(paths.giveProperty(propertyKeyOfPath)).clear();
        driver.navigate().back();
    }

    public void clickon(String ClickLocation){
        driver.findElementByAndroidUIAutomator(paths.giveProperty(ClickLocation)).click();
    }

    public void alertoperation(String optionPath){
        driver.findElementByAndroidUIAutomator(paths.giveProperty(optionPath)).click();
        driver.context("NATIVE_APP");
        driver.switchTo().defaultContent();
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
