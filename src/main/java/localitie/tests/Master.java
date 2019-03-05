package localitie.tests;

import io.appium.java_client.android.AndroidDriver;
import localitie.screenObjects.*;
import localitie.util.AndroidController;
import localitie.util.ConfigReader;
import localitie.util.DeviceConnector;
import localitie.util.Navigator;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class Master {

    private Logger log = Logger.getLogger(this.getClass());
    AndroidDriver driver = DeviceConnector.getInstance();
    Navigator navigator = new Navigator();
    SoftAssert softassert = new SoftAssert();
    ConfigReader config = new ConfigReader();
    AndroidController androidController = new AndroidController();
    SplashScreen splashScreen = new SplashScreen(driver);
    IntroductionScreen intro = new IntroductionScreen(driver);
    LoginOptions loginOptions = new LoginOptions(driver);
    LoginScreen loginScreen = new LoginScreen(driver);
    BottomMainMenu bottomMainMenu = new BottomMainMenu(driver);

    @BeforeSuite
    public void initDriver() {
        if (!androidController.isWifiEnabled()) {
            androidController.wifiOn();
            splashScreen.clickRetry();
        }
        if (!intro.isSkipPresent() && !intro.isLastAd()) {
            intro.swipeTillLastIntro();
            intro.startApp();
        } else if (intro.isSkipPresent()) {
            intro.skipIntro();
        }
        loginOptions.welcomeAccept();
        loginOptions.permissionAccept();
        loginOptions.permissionAccept();
        loginOptions.permissionAccept();
    }


    //    @AfterSuite
    public void cleanup() {
        log.warn("turning off wifi");
        androidController.wifiOff();
        androidController.uninstallApp();
        androidController.quitDriver();
    }
}
