package modules;

import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Checkoutcomcpletepageobjects;
import pageobjects.Checkoutoverviewpageobjects;
import pageobjects.Productspageobjects;

public class CheckoutOverviewPageModule {

    ChromeDriver c1;
    public CheckoutOverviewPageModule(ChromeDriver c1){
        this.c1 = c1;
    }

    public String getHeaderText()
    {
        c1.findElement(Checkoutoverviewpageobjects.CheckoutOverviewPageHeaderText).isDisplayed();
        String actualText = c1.findElement(Checkoutoverviewpageobjects.CheckoutOverviewPageHeaderText).getText();
        System.out.println(actualText);
        return actualText;
    }

    public void verifyTheNavigationToCheckOutOverviewPage()
    {
        String actualText = getHeaderText();
        System.out.println(actualText);
        if (Checkoutoverviewpageobjects.expectedValue.equals(actualText)){
            System.out.println("the user is navigating to CheckOutOverview page");
        }
        else {
            System.out.println("the user is not navigating to CheckOutOverview page");
        }
    }
    public void checkoutOverViewpageValidation(){

        c1.findElement(Checkoutoverviewpageobjects.finishButton).click();

    }
}
