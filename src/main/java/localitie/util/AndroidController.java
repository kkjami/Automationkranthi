package localitie.util;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class AndroidController {


    AndroidDriver driver = (AndroidDriver) DeviceConnector.getInstance();

    public void wifiOn() {

    }

    public void wifiOff() {

    }

    public void setToGPRS() {

    }

    public void setToEDGE() {

    }

    public void setTo3G() {

    }

    public void setTo4G() {

    }

    public void swipeMiddleHorizontally() {
        PointOption p1 = new PointOption();
        Dimension size = driver.manage().window().getSize();
        int height = (int) (size.getHeight() / 2);
        int startPoint = (int) (size.getWidth() - (size.getWidth() * 0.10));
        int endPoint = (int) (size.getWidth() - (size.getWidth() * 0.30));
        int duration = 2000;
        new TouchAction(driver).press(p1.point(startPoint, height)).moveTo(p1.point(endPoint, height)).release().perform();
    }

    public Boolean isPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}