package testrunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/failed_scenarios.txt",
        glue = "ruthstepdef",
        dryRun = false,
//        tags = "@advancedanalysis",
//        plugin = {"pretty",
//               "html:target/cucumber-reports.html",
//               "json:target/cucumber.json",
//               "tech.grasshopper.extentreports.cucumber7.adapter.ExtentCucumber7Adapter:"
//        },
//        monochrome = true,
          plugin = {"pretty",
                  "html:target/cucumber-reports.html",
                  "json:target/cucumber.json",
                  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
          "rerun:target/failed_scenarios.txt"},
          monochrome = true
     )
public class FailedTestRunner extends AbstractTestNGCucumberTests {
}
