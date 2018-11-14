package localitie.tests;

import io.appium.java_client.android.connection.ConnectionStateBuilder;
import localitie.screenObjects.IntroductionScreen;
import localitie.screenObjects.LoginOptions;
import localitie.screenObjects.SplashScreen;
import localitie.util.AndroidController;
import org.testng.annotations.Test;

public class SignUp extends Master {

    IntroductionScreen intro = new IntroductionScreen();
    LoginOptions login = new LoginOptions();
    AndroidController controller=new AndroidController();
    SplashScreen splash=new SplashScreen();
    @Test
    public void fbSignUP() {

    }

    @Test
    public void gmailSignUP() {

    }

    @Test
    public void manualSignUP() {

        if(!controller.isWifiEnabled()){
            controller.wifiOn();
            splash.clickRetry();
        }

        if (!intro.isSkipPresent() && !intro.isLastAd()) {
            intro.swipeTillLastIntro();
            intro.startApp();
        } else if (intro.isSkipPresent()) {
            intro.skipIntro();
        }
        login.welcomeAccept();
        login.permissionAccept();
        login.permissionAccept();
        login.permissionAccept();
    }
}
