package localitie.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import localitie.util.AndroidController;
import localitie.util.DeviceConnector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TutorialScreen {
    AndroidDriver driver;
    AndroidController ac = new AndroidController();

    public TutorialScreen(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.localities:id/btnSkip")
    public WebElement skip;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView")
    public WebElement adPosition;

    @AndroidFindBy(xpath = "\t/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")
    public WebElement adImage;

    @AndroidFindBy(id = "com.localities:id/tvText")
    public WebElement start;

    public void nextAd() {
        ac.swipeMiddleHorizontally();
    }

    public Boolean isSkipPresent() {
        return ac.isPresent(skip);
    }

    public Boolean isLastAd() {
        return ac.isPresent(start);
    }

    public void swipeTillLastIntro() {
        while(!isLastAd()){
            nextAd();
        }
    }
    public void skipIntro() {
        skip.click();
    }
    public void startApp() {
        start.click();
    }
    public void back(){

    }
}
