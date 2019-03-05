package localitie.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import localitie.util.DeviceConnector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LocalityFeedScreen {
    private AndroidDriver driver;

    public LocalityFeedScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/toolbar\"]/android.widget.ImageButton")
    private WebElement back_button;
    @AndroidFindBy(id = "com.localities:id/menu_search")
    private WebElement search_icon;
    @AndroidFindBy(id = "com.localities:id/tvTitle")
    private WebElement feed_title;
    @AndroidFindBy(id = "com.localities:id/tvLocality")
    private WebElement location_info;
    @AndroidFindBy(id = "com.localities:id/linPost")
    private WebElement search_keyword_box;
    @AndroidFindBy(id = "com.localities:id/fabAddPost")
    public WebElement add_post;



    public void back() {
        driver.navigate().back();
    }
}
