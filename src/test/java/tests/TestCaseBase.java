package tests;

import modules.LoginModule;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestCaseBase {

    ChromeDriver c1;
    LoginModule loginModule;

    @BeforeMethod
    public void setup(){
        c1 = new ChromeDriver();
        c1.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        c1.get("https://www.saucedemo.com");
        c1.manage().window().maximize();
        loginModule = new LoginModule(c1);
    }

    @AfterMethod
    public void tearDown(){
        c1.close();
    }


}
