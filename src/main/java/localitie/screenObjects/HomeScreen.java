package localitie.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import localitie.util.DeviceConnector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen {
    public HomeScreen(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/llMain\"]//*[@resource-id=\"com.localities:id/tabLayout\"]//android.support.v7.app.ActionBar.Tab[1]")
    public WebElement medical_alert;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/llMain\"]//*[@resource-id=\"com.localities:id/tabLayout\"]//android.support.v7.app.ActionBar.Tab[1]")
    public WebElement traffic_alert_message;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/llMain\"]//*[@resource-id=\"com.localities:id/tabLayout\"]//android.support.v7.app.ActionBar.Tab[2]")
    public WebElement emergency_alert;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/llMain\"]//*[@resource-id=\"com.localities:id/tabLayout\"]//android.support.v7.app.ActionBar.Tab[3]")
    public WebElement traffic_alert;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/llMain\"]//*[@resource-id=\"com.localities:id/tabLayout\"]//android.support.v7.app.ActionBar.Tab[4]")
    public WebElement broadcast_alert;

    public void postTrafficAlert(String alert_message) {
        traffic_alert.click();
        traffic_alert_message.sendKeys(alert_message);
    }

    public void switchToBroadcastAlerts() {
        broadcast_alert.click();
    }

    public void switchToEmergencyAlerts() {
        emergency_alert.click();
    }

    public void switchToMedicalAlerts() {
        medical_alert.click();
    }

}
