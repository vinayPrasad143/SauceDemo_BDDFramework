package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Productspageobjects;

public class ProductsModule {

    WebDriver driver;
    public ProductsModule(WebDriver driver){
        this.driver = driver;
    }

    public String getHeaderText()
    {
        driver.findElement(Productspageobjects.verifyProductPageNavigation).isDisplayed();
        String actualText = driver.findElement(Productspageobjects.verifyProductPageNavigation).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void verifyTheNavigationToProductsPage()
    {
        String actualText = getHeaderText();
        System.out.println("Expected text : " + Productspageobjects.ExpectedHeadertext);
        if (Productspageobjects.ExpectedHeadertext.equals(actualText)){
            System.out.println("the user is navigating to products page");
        }
        else {
            System.out.println("the user is not navigating to products page");
        }
    }
    public void addProducts(){

        driver.findElement(Productspageobjects.Product1).click();
        driver.findElement(Productspageobjects.Product2).click();
        driver.findElement(Productspageobjects.Container).click();

    }

    public void addProduct1()
    {
        driver.findElement(Productspageobjects.Product1).click();
    }
    public void addProduct2()
    {
        driver.findElement(Productspageobjects.Product2).click();
    }

    public void clickOnContainer()
    {
        driver.findElement(Productspageobjects.Container).click();
    }

}
