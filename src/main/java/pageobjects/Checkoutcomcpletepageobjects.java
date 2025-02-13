package pageobjects;

import org.openqa.selenium.By;

public class Checkoutcomcpletepageobjects {

   public static By backHome = By.xpath("//*[@id=\"back-to-products\"]");

   public static By navigationBar = By.xpath("//*[@id=\"react-burger-menu-btn\"]");

   public static By logOut = By.xpath("//*[@id=\"logout_sidebar_link\"]");

   public static By actualHeaderText = By.xpath("//*[@id=\"header_container\"]/div[2]/span");

   public static String expectedValue = "Checkout: Complete!";

}
