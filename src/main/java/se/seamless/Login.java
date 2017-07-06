package se.seamless;

import org.testng.annotations.Test;

/**
 * Created by kranthikumar on 05/07/17.
 */
public class Login extends Caller{
    @Test
    public void successLogin(){
        enterTextToField("login.agent","DIST1");
        enterTextToField("login.loginid","webuser");
        enterTextToField("login.password","20162016");
        click("login.submitbutton");
//        validateSucessLogin();
        alertoperation("buyscreen.alertdismiss");
        sleepfor(1000);
        click("buyscreen.logout");
        }

    @Test(dependsOnMethods = {"successLogin"})
    public void topup(){

        }
}