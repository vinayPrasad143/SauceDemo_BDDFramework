package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import tests.TestCaseBase;

public class Hooks {
    @Before
    public void setup(){

    }
//    public static WebDriver getDriver() {
//        return driver;  // ✅ Provide access to WebDriver
//    }

    @After
    public void teardown(){
        TestCaseBase.tearDown();
    }
}
