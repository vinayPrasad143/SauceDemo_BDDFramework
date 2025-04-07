package pageobjects;

import org.openqa.selenium.By;

public class Productspageobjects {

    public static By Product1 = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    public static By Product2 = By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]");
    public static By Container = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    public static By Product3 =  By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]");

    public static By verifyProductPageNavigation =  By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    public static String ExpectedHeadertext = "Products";

    public static By verifyTheNumberOfItemsPresentInTheCart= By.xpath("//span[@class=\"shopping_cart_badge\"]");

    public static Integer ExpectedNum = 2;

    public static By removeItem = By.xpath("//*[@id=\"remove-sauce-labs-fleece-jacket\"]");
    public static By dropDown = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");

    public static By dropDownValues =By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");

    public static By productsList =By.xpath("//*[@class=\"inventory_list\"]/div");

    public static By productNames =By.xpath("//*[@class=\"inventory_list\"]/div/div[2]/div/a");

    public static By productPrices =By.xpath("//*[@class=\"pricebar\"]/div");

}
