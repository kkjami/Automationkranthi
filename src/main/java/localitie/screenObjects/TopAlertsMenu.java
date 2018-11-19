package localitie.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import localitie.util.DeviceConnector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TopAlertsMenu {
    public TopAlertsMenu() {

        AndroidDriver driver = DeviceConnector.getInstance();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/cardView\"]/android.widget.HorizontalScrollView/android.widget.LinearLayout[1]/android.support.v7.app.ActionBar.Tab[1]")
    public WebElement traffic_alerts;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/cardView\"]/android.widget.HorizontalScrollView/android.widget.LinearLayout[1]/android.support.v7.app.ActionBar.Tab[2]")
    public WebElement broadcast_alerts;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/cardView\"]/android.widget.HorizontalScrollView/android.widget.LinearLayout[1]/android.support.v7.app.ActionBar.Tab[3]")
    public WebElement emergency_alerts;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/cardView\"]/android.widget.HorizontalScrollView/android.widget.LinearLayout[1]/android.support.v7.app.ActionBar.Tab[4]")
    public WebElement medical_alerts;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/cardView\"]/android.widget.HorizontalScrollView/android.widget.LinearLayout[1]/android.support.v7.app.ActionBar.Tab[5]")
    public WebElement all_alerts;


    public void switchToTrafficAlerts() {
        traffic_alerts.click();
    }

    public void switchToBroadcastAlerts() {
        broadcast_alerts.click();
    }

    public void switchToEmergencyAlerts() {
        emergency_alerts.click();
    }

    public void switchToMedicalAlerts() {
        medical_alerts.click();
    }

    public void switchToAllAlerts() {
        all_alerts.click();
    }


}
