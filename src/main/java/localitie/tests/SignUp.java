package localitie.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SignUp extends Master {




    @Test
    public void fbSignUP() {

    }

    @Test
    public void gmailSignUP() {

    }

    @Test
    public void manualSignUP() {


    }

    @AfterTest
    public void aftertest() {
        navigator.navigateTo(loginOptions.getClass());
    }
}
