package pageobjects;

import org.openqa.selenium.By;

public class Checkoutinfopageobjects {

    public static By firstName = By.xpath("//*[@id=\"first-name\"]");
    public static By lastName = By.xpath("//*[@id=\"last-name\"]");
    public static By postalCode = By.xpath("//*[@id=\"postal-code\"]");
    public static By cancelButton = By.xpath("//*[@id=\"cancel\"]");
    public static By continueButton = By.xpath("//*[@id=\"continue\"]");

    public static By checkOutInfoPageValidation = By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    public static String expectedValue = "Checkout: Your Information";
}
