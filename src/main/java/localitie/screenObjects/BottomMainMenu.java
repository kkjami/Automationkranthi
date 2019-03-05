package localitie.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import localitie.util.DeviceConnector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BottomMainMenu {
    public BottomMainMenu(AndroidDriver driver) {


        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/cardBottom\"]/android.widget.HorizontalScrollView[last()]/android.widget.LinearLayout[1]//android.support.v7.app.ActionBar.Tab[1]")
    public WebElement home_menu;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/cardBottom\"]/android.widget.HorizontalScrollView[last()]/android.widget.LinearLayout[1]//android.support.v7.app.ActionBar.Tab[2]")
    public WebElement my_page_menu;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/cardBottom\"]/android.widget.HorizontalScrollView[last()]/android.widget.LinearLayout[1]//android.support.v7.app.ActionBar.Tab[3]")
    public WebElement trending_menu;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.localities:id/cardBottom\"]/android.widget.HorizontalScrollView[last()]/android.widget.LinearLayout[1]//android.support.v7.app.ActionBar.Tab[4]")
    public WebElement alerts_menu;


    public void switchToHomeMenu(){
        home_menu.click();
    }
    public void switchToMyPageMenu(){
        my_page_menu.click();
    }
    public void switchToTrendingMenu(){
        trending_menu.click();
    }
    public void switchToAlertsMenu(){
        alerts_menu.click();
    }


}
