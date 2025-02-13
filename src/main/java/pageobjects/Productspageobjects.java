package pageobjects;

import org.openqa.selenium.By;

public class Productspageobjects {

    public static By Product1 = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    public static By Product2 = By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]");
    public static By Container = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    public static By Product3 =  By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]");

    public static By verifyProductPageNavigation =  By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    public static String ExpectedHeadertext = "Products";
}
