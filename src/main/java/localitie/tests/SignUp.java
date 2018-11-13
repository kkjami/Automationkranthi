package localitie.tests;

import localitie.screenObjects.IntroductionScreen;
import localitie.screenObjects.LoginOptions;
import org.testng.annotations.Test;

public class SignUp extends Master {

    IntroductionScreen intro = new IntroductionScreen();
    LoginOptions login = new LoginOptions();

    @Test
    public void fbSignUP() {

    }

    @Test
    public void gmailSignUP() {

    }

    @Test
    public void manualSignUP() {
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
