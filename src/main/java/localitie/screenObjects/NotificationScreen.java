package localitie.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import localitie.util.DeviceConnector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NotificationScreen {
    public NotificationScreen(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
//TODO change as per notification screen.
    @AndroidFindBy(id = "")
    public WebElement retry;

    @AndroidFindBy(id = "")
    public WebElement retryNote;

    @AndroidFindBy(id = "")
    public WebElement loadingNote;

    public void clickRetry(){
        retry.click();
    }

    public String getLoadingMessage(){
        return loadingNote.getText();
    }
}
