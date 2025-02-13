package modules;

import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Productspageobjects;

public class ProductsModule {

    ChromeDriver c1;
    public ProductsModule(ChromeDriver c1){
        this.c1 = c1;
    }

    public String getHeaderText()
    {
        c1.findElement(Productspageobjects.verifyProductPageNavigation).isDisplayed();
        String actualText = c1.findElement(Productspageobjects.verifyProductPageNavigation).getText();
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

        c1.findElement(Productspageobjects.Product1).click();
        c1.findElement(Productspageobjects.Product2).click();
        c1.findElement(Productspageobjects.Container).click();

    }
}
