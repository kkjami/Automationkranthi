package localitie.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import localitie.util.DeviceConnector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TopMyPageMenu {
    public TopMyPageMenu(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/cardView\"]/android.widget.HorizontalScrollView/android.widget.LinearLayout[1]/android.support.v7.app.ActionBar.Tab[1]")
    public WebElement my_posts;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/cardView\"]/android.widget.HorizontalScrollView/android.widget.LinearLayout[1]/android.support.v7.app.ActionBar.Tab[2]")
    public WebElement my_alerts;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/cardView\"]/android.widget.HorizontalScrollView/android.widget.LinearLayout[1]/android.support.v7.app.ActionBar.Tab[3]")
    public WebElement my_directories;

    public void switchToMyPosts() {
        my_posts.click();
    }

    public void switchToMyAlerts() {
        my_alerts.click();
    }

    public void switchToMyDirectories() {
        my_directories.click();
    }

}
