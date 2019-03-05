package localitie.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import localitie.util.DeviceConnector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginScreen {
    private AndroidDriver driver;

    public LoginScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.localities:id/edtEmail")
    private WebElement emailInput;
    @AndroidFindBy(id = "com.localities:id/edtPassword")
    private WebElement passwordInput;
    @AndroidFindBy(id = "com.localities:id/tvForgotPass")
    private WebElement forgot_pasword_button;
    @AndroidFindBy(id = "com.localities:id/btnSignIn")
    public WebElement signin_button;

    public void enterMailId(String emailid) {
        emailInput.click();
        Assert.assertTrue(driver.isKeyboardShown(), "isKeyboardShown= ");
        emailInput.sendKeys(emailid);
//        driver.pressKey(new KeyEvent(AndroidKey.A));
        driver.hideKeyboard();
    }

    public void enterPassword(String passwords) {
        passwordInput.sendKeys(passwords);
        driver.navigate().back();
    }

    public void back() {
        driver.navigate().back();
    }
}
