package tests;

import modules.LoginModule;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageobjects.*;

import java.time.Duration;

public class SauceDemoLoginTests extends TestCaseBase {

    @Test(priority = 1)
    public void validateLoginWithInvalidCredentials(){
        loginModule.login("vinay","xyz");
        loginModule.validateErrorMsg(Loginpageobjects.Expectedmessage);
    }
    @Test(priority = 2)
    public void validateLoginWithInvalidOrBlankUsername(){
        loginModule.login("","secret_sauce");
        loginModule.validateErrorMsg(Loginpageobjects.Expectedmessageforinvaliduser);
    }

    @Test(priority = 3)
    public void validateLoginWithInvalidOrBlankPassword(){
        loginModule.login("standard_user","");
        loginModule.validateErrorMsg(Loginpageobjects.Expectedmessageforinvalidpassword);
    }

    @Test(priority = 4)
    public void validateSuccessfullLogin() {
        loginModule.login("standard_user","secret_sauce");
    }

}
