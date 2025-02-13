package modules;

import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Cartpageobjects;
import pageobjects.Productspageobjects;

public class CartpageModule {

    ChromeDriver c1;
    public CartpageModule(ChromeDriver c1)
    {
        this.c1 = c1;
    }
    public String getCartHeaderText()
    {
        c1.findElement(Cartpageobjects.cartPageHeaderText).isDisplayed();
        String actualText = c1.findElement(Cartpageobjects.cartPageHeaderText).getText();
        System.out.println("Actual text :" +actualText);
        return actualText;
    }

    public void verifyTheNavigationToCartPage()
    {
        String actualText = getCartHeaderText();
        System.out.println("Expected Text : " + Cartpageobjects.expectedcartText);
        if (Cartpageobjects.expectedcartText.equals(actualText)){
            System.out.println("the user is navigating to Carts page");
        }
        else {
            System.out.println("the user is not navigating to Cart page");
        }
    }
    public void cartPage(){

        c1.findElement(Cartpageobjects.continueShopping).click();
        c1.findElement(Productspageobjects.Product3).click();
        c1.findElement(Productspageobjects.Container).click();
        c1.findElement(Cartpageobjects.checkOut).click();

    }
}
