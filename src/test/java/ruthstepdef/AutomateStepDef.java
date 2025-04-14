package ruthstepdef;

import RuthPageObjects.AutomatePageObjects;
import RuthPageObjects.GiaAskPageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestCaseBase;

import java.time.Duration;
import java.util.Set;

public class AutomateStepDef {

    WebDriver driver;
    String originalWindow;
    Set<String> allWindows;
    @Given("I open the application and click on the tab link")
    public void i_open_the_application_and_click_on_the_tab_link() {
        TestCaseBase.automatemodule.clickOnAutomateTab();
        driver = TestCaseBase.driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }
    @When("I switch to the new tab")
    public void i_switch_to_the_new_tab() throws InterruptedException {
        originalWindow = driver.getWindowHandle();
        allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(40000);
    }
    @Then("I should be on {string}")
    public void i_should_be_on(String string) throws InterruptedException {
        driver = TestCaseBase.driver;
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains(string));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("URL doesn't match", currentUrl.contains(string));
        System.out.println("Landed on correct URL: " + currentUrl);
        Thread.sleep(20000);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(AutomatePageObjects.transcriptsHeaderText));
            TestCaseBase.automatemodule.validateHeaderText();
        } catch (Exception e) {
            System.out.println("Transcripts header Text was not visible: " + e.getMessage());
            Assert.fail("Test failed due to element not being visible");
        }
    }
    @Then("I close the new tab and switch back to the original tab")
    public void i_close_the_new_tab_and_switch_back_to_the_original_tab() {
        driver.close();
        driver.switchTo().window(originalWindow);
    }
}
