package testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "ruthfeatures/AdvancedAnalysis.feature",
        glue = "ruthstepdef",
        dryRun = false,
        tags = "@advancedanalysis",
//        plugin = {"pretty",
//               "html:target/cucumber-reports.html",
//               "json:target/cucumber.json",
//               "tech.grasshopper.extentreports.cucumber7.adapter.ExtentCucumber7Adapter:"
//        },
//        monochrome = true,
          plugin = {"pretty", "html:target/cucumber-reports.html"},
          monochrome = true
     )
public class TestRunner {
}
