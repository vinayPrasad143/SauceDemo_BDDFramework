package tests;

import modules.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.Checkoutcomcpletepageobjects;
import pageobjects.Checkoutinfopageobjects;
import pageobjects.Checkoutoverviewpageobjects;

import java.time.Duration;

public class SauceDemoCheckOutCompletePageTests extends TestCaseBase{

    CheckOutCompletePageModule checkoutcompletepagemodule;
    CheckoutOverviewPageModule checkoutoverviewpagemodule;
    CheckoutInfoPageModule checkoutinfopagemodule;
    CartpageModule cartpageModule;
    ProductsModule productModule;

    @BeforeMethod
    public void checkOutCompletePage_PreReq(){

        loginModule.login("standard_user", "secret_sauce");
        productModule = new ProductsModule(driver);
        cartpageModule = new CartpageModule(driver);
        checkoutinfopagemodule = new CheckoutInfoPageModule(driver);
        checkoutoverviewpagemodule = new CheckoutOverviewPageModule(driver);
        checkoutcompletepagemodule = new CheckOutCompletePageModule(driver);
        productModule.addProducts();
        cartpageModule.cartPage();
        checkoutinfopagemodule.EnterValuesCheckOutInInfoPage();
        checkoutinfopagemodule.clickOnCancelButton();
        checkoutinfopagemodule.clickOnCheckOutButton();
        checkoutinfopagemodule.EnterValuesCheckOutInInfoPage();
        checkoutinfopagemodule.clickOnContinueButton();
        checkoutoverviewpagemodule.checkoutOverViewpageValidation();
    }

    @Test(priority = 9)
    public void checkOutCompletePageValidation(){

        checkoutcompletepagemodule.verifyTheNavigationToCheckOutCompletePage();
        Assert.assertEquals(checkoutcompletepagemodule.getCartHeaderText(), Checkoutcomcpletepageobjects.expectedValue);
        checkoutcompletepagemodule.CheckOutCompletePageValidation();
    }
}
