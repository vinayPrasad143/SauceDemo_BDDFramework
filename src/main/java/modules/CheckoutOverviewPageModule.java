package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Checkoutcomcpletepageobjects;
import pageobjects.Checkoutoverviewpageobjects;
import pageobjects.Productspageobjects;

public class CheckoutOverviewPageModule {

    WebDriver driver;
    public CheckoutOverviewPageModule(WebDriver driver){
        this.driver = driver;
    }

    public String getHeaderText()
    {
        driver.findElement(Checkoutoverviewpageobjects.CheckoutOverviewPageHeaderText).isDisplayed();
        String actualText = driver.findElement(Checkoutoverviewpageobjects.CheckoutOverviewPageHeaderText).getText();
        System.out.println(actualText);
        return actualText;
    }

    public void verifyTheNavigationToCheckOutOverviewPage()
    {
        String actualText = getHeaderText();
        System.out.println(actualText);
        if (Checkoutoverviewpageobjects.expectedValue.equals(actualText)){
            System.out.println("the user is navigated to CheckOutOverview page");
        }
        else {
            System.out.println("the user is not navigated to CheckOutOverview page");
        }
    }
    public void checkoutOverViewpageValidation(){

        driver.findElement(Checkoutoverviewpageobjects.finishButton).click();

    }
}
