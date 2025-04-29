package ruthstepdef;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tests.TestCaseBase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RuthHooks {

    private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setup(){

    }

    @Before(order = 0)
    public void setUpConsoleCapture() {
        System.setOut(new PrintStream(consoleOutput));
    }
//    public static WebDriver getDriver() {
//        return driver;  // ✅ Provide access to WebDriver
//    }

    @After(order = 1)
    public void teardown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) TestCaseBase.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath("screenshot.png");
        }
        TestCaseBase.tearDown();
        System.out.println("🛑 Browser closed.");
    }

    @After(order = 0)
    public void attachConsoleLogs(Scenario scenario) {
        System.setOut(originalOut); // Reset back stdout
        String capturedLogs = consoleOutput.toString();
        scenario.attach(capturedLogs.getBytes(), "text/plain", "Console Logs");
    }

    @After(order = 2)
    public void attachSparkReportLink(Scenario scenario) {
        String reportPath = "file://" + System.getProperty("user.dir") + "/test-output/ExtentReport/SparkReport.html";
        scenario.attach(reportPath.getBytes(),
                "text/uri-list",
                "Spark Report"
        );
    }

    @AfterStep
    public void logStepResult(Scenario scenario) {
        if (scenario.isFailed()) {
//            ExtentCucumberAdapter.getCurrentStep().fail("❌ Step failed!" + scenario.getName());
            ExtentCucumberAdapter.addTestStepLog("❌ Step failed!" + scenario.getName());
        } else {
//            ExtentCucumberAdapter.getCurrentStep().pass("✅ Step passed.");
            ExtentCucumberAdapter.addTestStepLog("✅ Step passed.");

        }
    }
}
