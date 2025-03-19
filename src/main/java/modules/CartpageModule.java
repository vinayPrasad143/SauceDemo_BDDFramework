package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Cartpageobjects;
import pageobjects.Productspageobjects;

public class CartpageModule {

    WebDriver driver;
    public CartpageModule(WebDriver driver)
    {
        this.driver = driver;
    }
    public String getCartHeaderText()
    {
        driver.findElement(Cartpageobjects.cartPageHeaderText).isDisplayed();
        String actualText = driver.findElement(Cartpageobjects.cartPageHeaderText).getText();
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

        driver.findElement(Cartpageobjects.continueShopping).click();
        driver.findElement(Productspageobjects.Product3).click();
        driver.findElement(Productspageobjects.Container).click();
        driver.findElement(Cartpageobjects.checkOut).click();

    }
}
