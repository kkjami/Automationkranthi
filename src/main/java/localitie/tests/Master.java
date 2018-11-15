package localitie.tests;

import localitie.screenObjects.IntroductionScreen;
import localitie.screenObjects.LoginOptions;
import localitie.screenObjects.LoginScreen;
import localitie.screenObjects.SplashScreen;
import localitie.util.AndroidController;
import localitie.util.ConfigReader;
import localitie.util.Navigator;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class Master {

    public ConfigReader config = new ConfigReader();
    private Logger log = Logger.getLogger(this.getClass());
    SoftAssert softassert = new SoftAssert();
    private AndroidController androidController =new AndroidController();
    private SplashScreen splashScreen =new SplashScreen();
    private IntroductionScreen intro = new IntroductionScreen();
    LoginOptions loginOptions = new LoginOptions();
    LoginScreen loginScreen = new LoginScreen();
    Navigator navigator = new Navigator();
    @BeforeSuite
    public void initDriver() {

        if(!androidController.isWifiEnabled()){
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
