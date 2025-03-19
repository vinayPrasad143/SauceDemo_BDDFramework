package tests;

import modules.LoginModule;
import modules.ProductsModule;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.Productspageobjects;

import java.time.Duration;

public class SauceDemoOrderPlacementTests extends TestCaseBase{

    ProductsModule productModule;

    @BeforeMethod
    public void orderPlacement_PreReq(){
        loginModule.login("standard_user", "secret_sauce");
        productModule = new ProductsModule(driver);
    }

    @Test(priority = 5)
    public void productsPageValidation()
    {
        productModule.verifyTheNavigationToProductsPage();
        Assert.assertEquals(productModule.getHeaderText(), Productspageobjects.ExpectedHeadertext);
        productModule.addProducts();
    }

}
