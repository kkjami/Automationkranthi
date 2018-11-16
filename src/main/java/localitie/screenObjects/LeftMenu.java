package localitie.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import localitie.util.DeviceConnector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LeftMenu {
    public LeftMenu() {

        AndroidDriver driver=DeviceConnector.getInstance();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
//TODO change as per notification screen.
    @AndroidFindBy(id = "com.localities:id/linProfile")
    public WebElement user_profile;

    @AndroidFindBy(id = "com.localities:id/linLocalityFeed")
    public WebElement locality_feed;

    @AndroidFindBy(id = "com.localities:id/linRateLocality")
    public WebElement locality_ratings;

    @AndroidFindBy(id = "com.localities:id/linSelectInterest")
    public WebElement categories;

    @AndroidFindBy(xpath = "")
    public WebElement business_page;

    @AndroidFindBy(xpath = "")
    public WebElement official_page;

    @AndroidFindBy(xpath = "")
    public WebElement resident_group;

    @AndroidFindBy(id = "com.localities:id/llWhatsapp")
    public WebElement whatsapp_share;

    @AndroidFindBy(id = "com.localities:id/llFacebook")
    public WebElement facebook_share;

    @AndroidFindBy(id = "com.localities:id/llFacebook")
    public WebElement twitter_share;

    @AndroidFindBy(id = "com.localities:id/switchSOS")
    public WebElement emergency_alerts_vibrate_toggle;

    @AndroidFindBy(id = "com.localities:id/switchMedical")
    public WebElement medical_alerts_vibrate_toggle;

    @AndroidFindBy(id = "com.localities:id/switchPush")
    public WebElement push_notification_vibrate_toggle;

    @AndroidFindBy(id = "com.localities:id/llRateUs")
    public WebElement rate_us;

    @AndroidFindBy(id = "com.localities:id/llContactUs")
    public WebElement contact_us;

    @AndroidFindBy(id = "com.localities:id/llFAQ")
    public WebElement menu_faq;

    @AndroidFindBy(id = "com.localities:id/linLogout")
    public WebElement logout;

}
