package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Cartpageobjects;
import pageobjects.Checkoutinfopageobjects;
import pageobjects.Productspageobjects;

public class CheckoutInfoPageModule {

    WebDriver driver;
    public CheckoutInfoPageModule(WebDriver driver){
        this.driver = driver;
    }

    public void EnterValuesCheckOutInInfoPage()
    {
        driver.findElement(Checkoutinfopageobjects.firstName).sendKeys("Vinay");
        driver.findElement(Checkoutinfopageobjects.lastName).sendKeys("Prasad");
        driver.findElement(Checkoutinfopageobjects.postalCode).sendKeys("12345");
    }

    public void clickOnCancelButton()
    {
        driver.findElement(Checkoutinfopageobjects.cancelButton).click();

    }
    public void clickOnCheckOutButton(){

        driver.findElement(Cartpageobjects.checkOut).click();

    }

    public void clickOnContinueButton(){

        driver.findElement(Checkoutinfopageobjects.continueButton).click();
    }

    public String getHaederText(){
        driver.findElement(Checkoutinfopageobjects.checkOutInfoPageValidation).isDisplayed();
        String actualValue = driver.findElement(Checkoutinfopageobjects.checkOutInfoPageValidation).getText();
        return actualValue;
    }
    public void VerifyTheNavigationToCheckOutInfoPage(){

        String actualValue = getHaederText();
        System.out.println(actualValue);
        if (Checkoutinfopageobjects.expectedValue.equals(actualValue)){
            System.out.println("the user is navigating to CheckOutInfo page");
        }
        else {
            System.out.println("the user is not navigating to CheckOutInfo page");
        }

    }
}
