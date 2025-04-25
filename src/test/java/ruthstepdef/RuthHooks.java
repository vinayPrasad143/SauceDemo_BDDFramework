package ruthstepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import tests.TestCaseBase;

public class RuthHooks {

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
