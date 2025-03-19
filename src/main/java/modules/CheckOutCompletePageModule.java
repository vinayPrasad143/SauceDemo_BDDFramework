package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Cartpageobjects;
import pageobjects.Checkoutcomcpletepageobjects;
import pageobjects.Productspageobjects;

public class CheckOutCompletePageModule {

    WebDriver driver;
    public CheckOutCompletePageModule(WebDriver driver)
    {
        this.driver = driver;
    }
    public String getCartHeaderText()
    {
        driver.findElement(Checkoutcomcpletepageobjects.actualHeaderText).isDisplayed();
        String actualText = driver.findElement(Checkoutcomcpletepageobjects.actualHeaderText).getText();
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


        driver.findElement(Checkoutcomcpletepageobjects.backHome).click();
        driver.findElement(Checkoutcomcpletepageobjects.navigationBar).click();
        driver.findElement(Checkoutcomcpletepageobjects.logOut).click();

    }
}
