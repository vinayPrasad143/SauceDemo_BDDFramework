package modules;

import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Cartpageobjects;
import pageobjects.Checkoutcomcpletepageobjects;
import pageobjects.Productspageobjects;

public class CheckOutCompletePageModule {

    ChromeDriver c1;
    public CheckOutCompletePageModule(ChromeDriver c1)
    {
        this.c1 = c1;
    }
    public String getCartHeaderText()
    {
        c1.findElement(Checkoutcomcpletepageobjects.actualHeaderText).isDisplayed();
        String actualText = c1.findElement(Checkoutcomcpletepageobjects.actualHeaderText).getText();
        System.out.println(actualText);
        return actualText;
    }

    public void verifyTheNavigationToCheckOutCompletePage()
    {
        String actualText = getCartHeaderText();
        System.out.println(actualText);
        if (Checkoutcomcpletepageobjects.expectedValue.equals(actualText)){
            System.out.println("the user is navigating to Carts page");
        }
        else {
            System.out.println("the user is not navigating to Cart page");
        }
    }
    public void CheckOutCompletePageValidation(){


        c1.findElement(Checkoutcomcpletepageobjects.backHome).click();
        c1.findElement(Checkoutcomcpletepageobjects.navigationBar).click();
        c1.findElement(Checkoutcomcpletepageobjects.logOut).click();

    }
}
