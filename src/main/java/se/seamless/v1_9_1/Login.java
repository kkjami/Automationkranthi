package se.seamless.v1_9_1;

import org.testng.annotations.Test;
import se.seamless.Caller;

/**
 * Created by kranthikumar on 05/07/17.
 */
public class Login extends Caller {
    @Test
    public void successLogin(){
        enterTextToField("login.agent","DIST1");
        enterTextToField("login.loginid","webuser");
        enterTextToField("login.password","20162016");
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