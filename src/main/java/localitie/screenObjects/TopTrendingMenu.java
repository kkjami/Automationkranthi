package localitie.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import localitie.util.DeviceConnector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TopTrendingMenu {
    public TopTrendingMenu(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/cardView\"]/android.widget.HorizontalScrollView/android.widget.LinearLayout[1]/android.support.v7.app.ActionBar.Tab[1]")
    public WebElement groups_trending;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/cardView\"]/android.widget.HorizontalScrollView/android.widget.LinearLayout[1]/android.support.v7.app.ActionBar.Tab[2]")
    public WebElement governance_trending;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/cardView\"]/android.widget.HorizontalScrollView/android.widget.LinearLayout[1]/android.support.v7.app.ActionBar.Tab[3]")
    public WebElement all_trending;


    public void switchToGroupsTrend() {
        groups_trending.click();
    }

    public void switchToGovernanceTrend() {
        governance_trending.click();
    }

    public void switchToAllTrend() {
        all_trending.click();
    }



}
