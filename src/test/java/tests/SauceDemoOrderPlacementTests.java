package tests;

import modules.LoginModule;
import modules.ProductsModule;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceDemoOrderPlacementTests extends TestCaseBase{

    ProductsModule productModule;

    public void setup1(){
        productModule = new ProductsModule(c1);
    }

    @Test(priority = 5)
    public void productsPageValidation()
    {
        loginModule.login("standard_user", "secret_sauce");
        setup1();
        productModule.verifyTheNavigationToProductsPage();
        productModule.addProducts();
    }

}
