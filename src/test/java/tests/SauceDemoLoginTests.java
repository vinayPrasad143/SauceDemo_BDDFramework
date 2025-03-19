package tests;

import modules.LoginModule;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.*;

import java.time.Duration;
public class SauceDemoLoginTests extends TestCaseBase {

    //retryAnalyzer = ReTryTestcases.class --> if we want to run this to specific tests then we can use this
    @Test(priority = 1)
    public void validateLoginWithInvalidCredentials(){
        loginModule.login("vinay","xyz");
       //loginModule.validateErrorMsg(Loginpageobjects.Expectedmessage);
        Assert.assertEquals(loginModule.getErrorMsg(), Loginpageobjects.Expectedmessage);

    }
    @Test(priority = 2, retryAnalyzer = ReTryTestcases.class)
    public void validateLoginWithInvalidOrBlankUsername(){
        loginModule.login("","secret_sauce");
        //loginModule.validateErrorMsg(Loginpageobjects.Expectedmessageforinvaliduser);
        Assert.assertEquals(loginModule.getErrorMsg(),Loginpageobjects.Expectedmessageforinvaliduser);
    }

    @Test(priority = 3, retryAnalyzer = ReTryTestcases.class)
    public void validateLoginWithInvalidOrBlankPassword(){
        loginModule.login("standard_user","");
        //loginModule.validateErrorMsg(Loginpageobjects.Expectedmessageforinvalidpassword);
        Assert.assertEquals(loginModule.getErrorMsg(), Loginpageobjects.Expectedmessageforinvalidpassword);
    }

    @Test(priority = 4)
    public void validateSuccessfullLogin() {
        loginModule.login("standard_user","secret_sauce");
    }

}
