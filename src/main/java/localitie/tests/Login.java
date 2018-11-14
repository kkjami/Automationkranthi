package localitie.tests;

import localitie.screenObjects.LoginOptions;
import localitie.screenObjects.LoginScreen;
import org.testng.annotations.Test;

public class Login extends Master {

    private LoginOptions loginOptions = new LoginOptions();
    private LoginScreen loginScreen = new LoginScreen();

    @Test
    public void successLogin() {
        loginOptions.touchSignIn();
        loginScreen.enterMailId("user1@mail.com");
        loginScreen.enterPassword("1234");
        loginScreen.signin_button.click();
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
