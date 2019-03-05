package localitie.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import localitie.util.AndroidController;
import localitie.util.DeviceConnector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IntroductionScreen {
    AndroidDriver driver;
    AndroidController ac = new AndroidController();

    public IntroductionScreen(AndroidDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.localities:id/tvSkip")
    public WebElement skip;

    @AndroidFindBy(id = "com.localities:id/pageIndicator")
    public WebElement adPosition;

    @AndroidFindBy(id = "com.localities:id/imgIntro")
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
