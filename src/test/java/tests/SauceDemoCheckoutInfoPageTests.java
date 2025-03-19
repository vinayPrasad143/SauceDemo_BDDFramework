package tests;

import modules.CartpageModule;
import modules.CheckoutInfoPageModule;
import modules.LoginModule;
import modules.ProductsModule;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.Checkoutinfopageobjects;

import java.time.Duration;

public class SauceDemoCheckoutInfoPageTests extends TestCaseBase {


    CheckoutInfoPageModule checkoutinfopagemodule;
    CartpageModule cartpageModule;
    ProductsModule productModule;

    @BeforeMethod
    public void checkOutInfoPage_PreReq(){
        loginModule.login("standard_user", "secret_sauce");
        productModule = new ProductsModule(driver);
        cartpageModule = new CartpageModule(driver);
        checkoutinfopagemodule = new CheckoutInfoPageModule(driver);
        productModule.addProducts();
        cartpageModule.cartPage();
    }

    @Test(priority = 7)
    public void checkOutInfoPageValidation(){

        checkoutinfopagemodule.VerifyTheNavigationToCheckOutInfoPage();
        Assert.assertEquals(checkoutinfopagemodule.getHaederText(), Checkoutinfopageobjects.expectedValue);
        checkoutinfopagemodule.EnterValuesCheckOutInInfoPage();
        checkoutinfopagemodule.clickOnCancelButton();
        checkoutinfopagemodule.clickOnCheckOutButton();
        checkoutinfopagemodule.EnterValuesCheckOutInInfoPage();
        checkoutinfopagemodule.clickOnContinueButton();
    }
}
