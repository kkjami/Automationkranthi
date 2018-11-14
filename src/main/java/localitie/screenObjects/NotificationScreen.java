package localitie.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import localitie.util.DeviceConnector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NotificationScreen {
    public NotificationScreen() {

        AndroidDriver driver=DeviceConnector.getInstance();
        driver.openNotifications();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.localities:id/snackbar_action")
    public WebElement retry;

    @AndroidFindBy(id = "com.localities:id/snackbar_text")
    public WebElement retryNote;

    @AndroidFindBy(id = "com.localities:id/tvWelcome")
    public WebElement loadingNote;

    public void clickRetry(){
        retry.click();
    }

    public String getLoadingMessage(){
        return loadingNote.getText();
    }
}
