package tests;

import modules.LoginModule;
import modules.ProductsModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestCaseBase {

    public static WebDriver driver;
    public static LoginModule loginModule;
    public static ProductsModule productsModule;

    @BeforeMethod(alwaysRun = true)
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        loginModule = new LoginModule(driver);
    }

    public static void setup(String url){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        loginModule = new LoginModule(driver);
        productsModule = new ProductsModule(driver);
    }

    @AfterMethod(alwaysRun = true)
    public static void tearDown(){
        driver.close();
    }


}
