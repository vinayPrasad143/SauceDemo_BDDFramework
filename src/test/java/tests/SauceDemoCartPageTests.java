package tests;

import modules.CartpageModule;
import modules.LoginModule;
import modules.ProductsModule;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceDemoCartPageTests extends TestCaseBase {

    CartpageModule cartpageModule;
    ProductsModule productModule;

    public void setup1(){
        productModule = new ProductsModule(c1);
        cartpageModule = new CartpageModule(c1);
    }

    @Test(priority = 6)
    public void cartPageValidation(){

        loginModule.login("standard_user", "secret_sauce");
        setup1();
        productModule.verifyTheNavigationToProductsPage();
        productModule.addProducts();
        cartpageModule.verifyTheNavigationToCartPage();
        cartpageModule.cartPage();
    }
}
