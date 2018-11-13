package localitie.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import localitie.util.DeviceConnector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen {
    public LoginScreen() {
        AndroidDriver driver=DeviceConnector.getInstance();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(id = "com.localities:id/tvTerms")
    private WebElement terms_of_services;

    public void enterMailId() {

    }

    public void back(){

    }
}
