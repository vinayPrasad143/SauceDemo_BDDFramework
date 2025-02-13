package tests;

import modules.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageobjects.Checkoutcomcpletepageobjects;
import pageobjects.Checkoutoverviewpageobjects;

import java.time.Duration;

public class SauceDemoCheckOutCompletePageTests extends TestCaseBase{

    CheckOutCompletePageModule checkoutcompletepagemodule;
    CheckoutOverviewPageModule checkoutoverviewpagemodule;
    CheckoutInfoPageModule checkoutinfopagemodule;
    CartpageModule cartpageModule;
    ProductsModule productModule;

    public void setup1(){

        productModule = new ProductsModule(c1);
        cartpageModule = new CartpageModule(c1);
        checkoutinfopagemodule = new CheckoutInfoPageModule(c1);
        checkoutoverviewpagemodule = new CheckoutOverviewPageModule(c1);
        checkoutcompletepagemodule = new CheckOutCompletePageModule(c1);
    }

    @Test(priority = 9)
    public void checkOutCompletePageValidation(){

        setup1();
        loginModule.login("standard_user", "secret_sauce");
        productModule.verifyTheNavigationToProductsPage();
        productModule.addProducts();
        cartpageModule.verifyTheNavigationToCartPage();
        cartpageModule.cartPage();
        checkoutinfopagemodule.VerifyTheNavigationToCheckOutInfoPage();
        checkoutinfopagemodule.EnterValuesCheckOutInInfoPage();
        checkoutinfopagemodule.clickOnCancelButton();
        checkoutinfopagemodule.clickOnCheckOutButton();
        checkoutinfopagemodule.EnterValuesCheckOutInInfoPage();
        checkoutinfopagemodule.clickOnContinueButton();
        checkoutoverviewpagemodule.verifyTheNavigationToCheckOutOverviewPage();
        checkoutoverviewpagemodule.checkoutOverViewpageValidation();
        checkoutcompletepagemodule.verifyTheNavigationToCheckOutCompletePage();
        checkoutcompletepagemodule.CheckOutCompletePageValidation();
    }
}
