package localitie.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import localitie.util.DeviceConnector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginOptions {

    public LoginOptions() {
        AndroidDriver driver = DeviceConnector.getInstance();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.localities:id/llFbLogin")
    private WebElement login_with_fb;
    @AndroidFindBy(id = "com.localities:id/llGLogin")
    private WebElement login_with_google;
    @AndroidFindBy(id = "com.localities:id/btnSignIn")
    private WebElement login_manual;
    @AndroidFindBy(id = "com.localities:id/btnSignUp")
    private WebElement signup_manual;
    @AndroidFindBy(id = "com.localities:id/tvOk")
    private WebElement welcomeOk;
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private WebElement permission_accept;
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    private WebElement permission_deny;
    @AndroidFindBy(id = "com.localities:id/tvTerms")
    private WebElement terms_of_services;
    @AndroidFindBy(id = "com.localities:id/tvContactUs")
    private WebElement report_us;

    public void touchSignIn() {
        login_manual.click();
    }

    public void welcomeAccept() {
        welcomeOk.click();
    }

    public void permissionAccept() {
        permission_accept.click();
    }

    public void permissionDeny() {
        permission_deny.click();
    }

    public void fbLogin() {
        login_with_fb.click();
    }

    public void back() {
    }
}
