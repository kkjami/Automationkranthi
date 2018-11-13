package localitie.tests;

import localitie.screenObjects.LoginOptions;
import localitie.screenObjects.LoginScreen;
import org.testng.annotations.Test;

public class Login extends Master {

    LoginOptions loginOptions = new LoginOptions();
    LoginScreen loginScreen = new LoginScreen();

    @Test
    public void successLogin() {
        loginOptions.touchSignIn();

        /***
         * Assertions
         */
        //visible elements

        softassert.assertAll();

        /*** position assertions
         * below element n above element.
         */
    }

    @Test(enabled = false)
    public void FacebookLogin() {

        loginOptions.fbLogin();
    }

    @Test
    public void googleLogin() {

    }
}
