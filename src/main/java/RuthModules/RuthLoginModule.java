package RuthModules;

import RuthPageObjects.LoginPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.Loginpageobjects;
import pageobjects.Productspageobjects;

import java.time.Duration;


public class RuthLoginModule {

    WebDriver driver;
    WebDriverWait wait;
    public RuthLoginModule(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void enterUserName(String username){

        driver.findElement(LoginPageObjects.loginEmailTB).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(LoginPageObjects.loginPasswordTB).sendKeys(password);
    }
    public void clickOnNextButton(){
        driver.findElement(LoginPageObjects.next_signInBut).click();
    }

    public void clickOnStaySignInButton(){
        driver.findElement(LoginPageObjects.staySignedInNoBut).click();
    }

    public void clickOnGrapheneLogo(){
        driver.findElement(LoginPageObjects.grapheneLogin).click();
    }

    public void verifyHomepage()
    {
        driver.findElement(LoginPageObjects.verifyHomePage).isDisplayed();
    }

    public void clickOnSignInButton(){
        driver.findElement(LoginPageObjects.signInBut).click();
    }

    public String getHeaderText()
    {
        driver.findElement(LoginPageObjects.verifyHomePage).isDisplayed();
        String actualText = driver.findElement(LoginPageObjects.verifyHomePage).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }





}
