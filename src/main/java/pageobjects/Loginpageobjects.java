package pageobjects;

import org.openqa.selenium.By;

public class Loginpageobjects {

 public static String Expectedmessage = "Epic sadface: Username and password do not match any user in this service";
 public static String Expectedmessageforinvaliduser = "xyz Epic sadface: Username is required";
 public static String Expectedmessageforinvalidpassword = "xyz Epic sadface: Password is required";
 public static By username = By.xpath("//*[@id=\"user-name\"]");
 public static By psw =By.xpath("//*[@id=\"password\"]");
 public static By LoginButton = By.xpath("//*[@id=\"login-button\"]");
 public static By validationMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");
 public static By validationMessage1 = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");
 //public static By validationMessage12 = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");
}
