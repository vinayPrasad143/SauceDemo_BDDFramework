package RuthPageObjects;

import org.openqa.selenium.By;

public class LoginPageObjects {

    public static By loginEmailTB = By.xpath("//input[@type='email']");
    public static By loginPasswordTB =By.xpath("//input[@type='password']");
    public static By next_signInBut = By.xpath("//input[@type='submit']");
    public static By staySignedInNoBut = By.xpath("//input[@type='submit']");
    public static By grapheneLogin = By.xpath("//p[@class='login-name'][contains(text(),'Graphene')]/../a");
    public static By verifyHomePage = By.xpath("//*[@id=\"root\"]/div/div/div/header/div/div/span");
    public static By signInBut = By.xpath("//*[@id=\"idSIButton9\"]");
    public static String expectedHeaderText = "Welcome Vinayprasad";



}
