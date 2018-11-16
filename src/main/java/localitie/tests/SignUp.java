package localitie.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SignUp extends Master {




    @Test
    public void fbSignUP() {

    }

    @Test
    public void invalidFbSignUP() {

    }

    @Test
    public void gmailSignUP() {

    }
    @Test
    public void invalidGmailSignUP() {

    }

    @Test
    public void manualSignUP() {


    }
    @Test
    public void InvalidManualSignUP() {


    }

    @AfterTest
    public void aftertest() {
        navigator.navigateTo(loginOptions.getClass());
    }
}
