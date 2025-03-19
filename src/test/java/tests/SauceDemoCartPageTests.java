package tests;

import modules.CartpageModule;
import modules.LoginModule;
import modules.ProductsModule;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.Cartpageobjects;

import java.time.Duration;

public class SauceDemoCartPageTests extends TestCaseBase {

    CartpageModule cartpageModule;
    ProductsModule productModule;

    @BeforeMethod
    public void cartPage_PreReq(){
        loginModule.login("standard_user", "secret_sauce");
        productModule = new ProductsModule(driver);
        cartpageModule = new CartpageModule(driver);
        productModule.verifyTheNavigationToProductsPage();
        productModule.addProducts();
    }

    @Test(priority = 6)
    public void cartPageValidation(){
        cartpageModule.verifyTheNavigationToCartPage();
        Assert.assertEquals(cartpageModule.getCartHeaderText(), Cartpageobjects.expectedcartText);
        cartpageModule.cartPage();
    }
}
