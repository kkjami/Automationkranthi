package nativeapp.android.v1_9_1;

import nativeapp.android.Caller;
import org.testng.annotations.Test;

/**
 * Created by kranthikumar on 05/07/17.
 */
public class Login extends Caller {
    @Test
    public void successLogin(){
        enterTextToField("login.agent","agent");
        enterTextToField("login.loginid","loginid");
        enterTextToField("login.password","password");
        System.out.println(driver.getContext());
        clickon("login.submitbutton");
//        validateSucessLogin();
//        alertoperation("buyscreen.alertdismiss");
        sleepfor(1000);
        System.out.println(driver.getContext());
        clickon("buyscreen.logout");
        }

    @Test(dependsOnMethods = {"successLogin"})
    public void topup(){

        }
}