package appium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.*;

/**
 * Created by Kranthi on 01-07-2017.
 */
public class CallMobileFromDailer extends CommonToolsForApp {
    Logger log = Logger.getLogger(CallMobileFromDailer.class);
    @Test
    public void test() throws Exception {

        //driver.findElement(By.xpath("//android.widget.TextView[@index='0']")).click();
        driver.findElement(By.id("com.android.dialer:id/floating_action_button")).click();

        driver.findElement(By.id("com.android.contacts:id/nine")).click();
        driver.findElement(By.id("com.android.contacts:id/eight")).click();
        driver.findElement(By.id("com.android.contacts:id/four")).click();
        driver.findElement(By.id("com.android.contacts:id/eight")).click();
        driver.findElement(By.id("com.android.contacts:id/seven")).click();
        driver.findElement(By.id("com.android.contacts:id/three")).click();
        driver.findElement(By.id("com.android.contacts:id/four")).click();
        driver.findElement(By.id("com.android.contacts:id/five")).click();
        driver.findElement(By.id("com.android.contacts:id/nine")).click();
        driver.findElement(By.id("com.android.contacts:id/five")).click();
        driver.findElement(By.id("com.android.contacts:id/five")).click();
        driver.findElement(By.id("com.android.contacts:id/callbutton")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.Button[@text='End call']")).click();
    }

}
