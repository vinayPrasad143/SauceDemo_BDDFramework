package testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        glue = "stepdef",
        dryRun = false,
//        tags = "@now"
//        plugin = {"pretty",
//               "html:target/cucumber-reports.html",
//               "json:target/cucumber.json",
//               "tech.grasshopper.extentreports.cucumber7.adapter.ExtentCucumber7Adapter:"
//        },
//        monochrome = true
          plugin = {"pretty", "html:target/cucumber-reports.html"},
          monochrome = true
     )
public class TestRunner {
}
