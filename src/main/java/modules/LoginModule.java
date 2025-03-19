package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Loginpageobjects;

public class LoginModule {

    WebDriver driver;
    public LoginModule(WebDriver driver){
        this.driver = driver;
    }

    public void enterUserName(String username){
        driver.findElement(Loginpageobjects.username).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(Loginpageobjects.psw).sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(Loginpageobjects.LoginButton).click();
    }

    public void login(String username, String password){
        driver.findElement(Loginpageobjects.username).sendKeys(username);
        driver.findElement(Loginpageobjects.psw).sendKeys(password);
        driver.findElement(Loginpageobjects.LoginButton).click();
    }

    public String getErrorMsg(){
        driver.findElement(Loginpageobjects.validationMessage).isDisplayed();
        String actualMessage = driver.findElement(Loginpageobjects.validationMessage).getText();
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
