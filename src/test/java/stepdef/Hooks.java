package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import tests.TestCaseBase;

public class Hooks {
    @Before
    public void setup(){

    }

    @After
    public void teardown(){
        TestCaseBase.tearDown();
    }
}
