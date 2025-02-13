package modules;

import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Loginpageobjects;

public class LoginModule {

    ChromeDriver c1;
    public LoginModule(ChromeDriver c1){
        this.c1 = c1;
    }


    public void login(String username, String password){
        c1.findElement(Loginpageobjects.username).sendKeys(username);
        c1.findElement(Loginpageobjects.psw).sendKeys(password);
        c1.findElement(Loginpageobjects.LoginButton).click();
    }

    public String getErrorMsg(){
        c1.findElement(Loginpageobjects.validationMessage).isDisplayed();
        String actualMessage = c1.findElement(Loginpageobjects.validationMessage).getText();
        return actualMessage;
    }

    public void validateErrorMsg(String expectedMsg){
        String errorMsg = getErrorMsg();
        System.out.println(errorMsg);
        if(Loginpageobjects.Expectedmessage.equals(errorMsg)){
            System.out.println("message displayed is correct.....");
        }else{
            System.out.println("message displayed is not correct " + expectedMsg + " is the correct message");
        }
    }

}
