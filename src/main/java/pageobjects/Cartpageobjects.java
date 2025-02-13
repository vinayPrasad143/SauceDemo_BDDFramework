package pageobjects;

import org.openqa.selenium.By;

public class Cartpageobjects {

    public static By checkOut = By.xpath("//*[@id=\"checkout\"]");
    public static By continueShopping = By.xpath("//*[@id=\"continue-shopping\"]");
    public static By cartPageHeaderText = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    public static String expectedcartText = "Your Cart";
}