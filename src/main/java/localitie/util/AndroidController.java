package localitie.util;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class AndroidController {


    private AndroidDriver driver = DeviceConnector.getInstance();
    private Logger log = Logger.getLogger(this.getClass().getName());

    public void wifiOn() {

        if (!driver.getConnection().isWiFiEnabled()) {
            driver.setConnection(new ConnectionStateBuilder()
                    .withWiFiEnabled()
                    .build());
            log.warn("turning on wifi");
        }
        log.info("isWiFiEnabled: " + driver.getConnection().isWiFiEnabled());
    }

    public void wifiOff() {
        if (driver.getConnection().isWiFiEnabled()) {
            driver.setConnection(new ConnectionStateBuilder()
                    .withWiFiDisabled()
                    .build());
            log.warn("turning off wifi");
        }
        log.info("isWiFiEnabled: " + driver.getConnection().isWiFiEnabled());
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
        int height = size.getHeight() / 2;
        int startPoint = (int) (size.getWidth() - (size.getWidth() * 0.10));
        int endPoint = (int) (size.getWidth() - (size.getWidth() * 0.30));
        int duration = 2000;
        new TouchAction(driver).press(p1.point(startPoint, height)).moveTo(p1.point(endPoint, height)).release().perform();
        log.info("performing swipe at " + driver.currentActivity());
    }

    public Boolean isPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Boolean isWifiEnabled() {
        return driver.getConnection().isWiFiEnabled();
    }

    public Boolean isLocationServiceOn() {
//        return driver.toggleLocationServices();
        return null;
    }

    public void uninstallApp() {
        log.warn("uninstalling app:" + driver.getCapabilities().getCapability("appPackage"));
        driver.removeApp(driver.getCapabilities().getCapability("appPackage").toString());
    }

    public void quitDriver() {
        log.warn("calling driver quit: " + driver.getSessionId());
        driver.quit();
    }
}