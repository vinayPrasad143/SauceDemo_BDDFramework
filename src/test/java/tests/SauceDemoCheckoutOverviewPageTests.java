package tests;

import modules.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.Checkoutinfopageobjects;
import pageobjects.Checkoutoverviewpageobjects;

import java.time.Duration;

public class SauceDemoCheckoutOverviewPageTests extends TestCaseBase {

    CheckoutOverviewPageModule checkoutoverviewpagemodule;
    CheckoutInfoPageModule checkoutinfopagemodule;
    CartpageModule cartpageModule;
    ProductsModule productModule;

    @BeforeMethod
    public void checkOutOverviewPage_PreReq(){

        loginModule.login("standard_user", "secret_sauce");
        productModule = new ProductsModule(driver);
        cartpageModule = new CartpageModule(driver);
        checkoutinfopagemodule = new CheckoutInfoPageModule(driver);
        checkoutoverviewpagemodule = new CheckoutOverviewPageModule(driver);
        productModule.addProducts();
        cartpageModule.cartPage();
        checkoutinfopagemodule.EnterValuesCheckOutInInfoPage();
        checkoutinfopagemodule.clickOnContinueButton();
    }

    @Test(priority = 8)
    public void checkoutOverviewPageValidation(){

        checkoutoverviewpagemodule.verifyTheNavigationToCheckOutOverviewPage();
        Assert.assertEquals(checkoutoverviewpagemodule.getHeaderText(), Checkoutoverviewpageobjects.expectedValue);
        checkoutoverviewpagemodule.checkoutOverViewpageValidation();
    }
}
