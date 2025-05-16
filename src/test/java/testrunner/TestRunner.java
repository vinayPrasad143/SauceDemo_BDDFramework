package testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "ruthfeatures",
        glue = "ruthstepdef",
        dryRun = false,
        tags = "@advancedanalysis or @automate or @compare or @askgia or @qualdeepdive",
        plugin = {"pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"},
        monochrome = true
)
public class TestRunner {
}
//public class TestRunner extends AbstractTestNGCucumberTest{
//
//}
