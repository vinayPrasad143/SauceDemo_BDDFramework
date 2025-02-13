package modules;

import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Cartpageobjects;
import pageobjects.Checkoutinfopageobjects;
import pageobjects.Productspageobjects;

public class CheckoutInfoPageModule {

    ChromeDriver c1;
    public CheckoutInfoPageModule(ChromeDriver c1){
        this.c1 = c1;
    }

    public void EnterValuesCheckOutInInfoPage()
    {
        c1.findElement(Checkoutinfopageobjects.firstName).sendKeys("Vinay");
        c1.findElement(Checkoutinfopageobjects.lastName).sendKeys("Prasad");
        c1.findElement(Checkoutinfopageobjects.postalCode).sendKeys("12345");
    }

    public void clickOnCancelButton()
    {
        c1.findElement(Checkoutinfopageobjects.cancelButton).click();

    }
    public void clickOnCheckOutButton(){

        c1.findElement(Cartpageobjects.checkOut).click();

    }

    public void clickOnContinueButton(){

        c1.findElement(Checkoutinfopageobjects.continueButton).click();
    }

    public String getHaederText(){
        c1.findElement(Checkoutinfopageobjects.checkOutInfoPageValidation).isDisplayed();
        String actualValue = c1.findElement(Checkoutinfopageobjects.checkOutInfoPageValidation).getText();
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
