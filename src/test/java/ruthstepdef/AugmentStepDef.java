package ruthstepdef;

import RuthPageObjects.AugmentPageObjects;
import RuthPageObjects.LoginPageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestCaseBase;

import java.time.Duration;

public class AugmentStepDef {
    WebDriver driver;
    @Given("Navigate to the Augment page")
    public void navigate_to_the_augment_page() throws InterruptedException {
        driver = TestCaseBase.driver;
        TestCaseBase.augmentmodule.clickOnAugmentTab();
        Thread.sleep(15000);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
            wait.until(ExpectedConditions.presenceOfElementLocated(AugmentPageObjects.HeaderText));
            TestCaseBase.augmentmodule.getHeaderText();
            String fromUI = TestCaseBase.augmentmodule.getHeaderText();
            System.out.println("Text from UI: "+ fromUI);
            System.out.println("Expected text: " + AugmentPageObjects.expectedHeaderText);
            Assert.assertEquals(fromUI, AugmentPageObjects.expectedHeaderText,"Navigated to Augment page");
        } catch (Exception e) {
            System.out.println("Augment page header text was not visible: " + e.getMessage());
            Assert.fail("Test failed due to element not being visible");
        }

    }
    @When("I select {string} from the country dropdown")
    public void i_select_from_the_country_dropdown(String string) {
        TestCaseBase.augmentmodule.clickOnCountryDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        option.click();
        try {
            String fromUI1 = TestCaseBase.augmentmodule.validateTheSelectedCountryValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals(fromUI1, string,"selected and expected countries are same");
        } catch (Exception e) {
            System.out.println("selected and expected countries are not same: " + e.getMessage());
            Assert.fail("selected and expected country values are not matching");
        }
    }
    @When("I select {string} from the category dropdown")
    public void i_select_from_the_category_dropdown(String string) {
        TestCaseBase.augmentmodule.clickOnCategoryDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        option.click();
        try {
            String fromUI2 = TestCaseBase.augmentmodule.validateTheSelectedCategoryValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals(fromUI2, string,"selected and expected categories are same");
        } catch (Exception e) {
            System.out.println("selected and expected categories are not same: " + e.getMessage());
            Assert.fail("selected and expected category values are not matching");
        }
    }
    @When("I select {string} from the Time period dropdown")
    public void i_select_from_the_time_period_dropdown(String string) {
        TestCaseBase.augmentmodule.clickOnTimePeriodDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        option.click();
        try {
            String fromUI3 = TestCaseBase.augmentmodule.validateTheSelectedTimePeriodValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals(fromUI3, string,"selected and expected Time periods are same");
        } catch (Exception e) {
            System.out.println("selected and expected Time periods are not same: " + e.getMessage());
            Assert.fail("selected and expected Time periods are not matching");
        }
    }
    @Then("I should see the result for {string} and {string} and {string} by selecting each themes for all the Topics of interests")
    public void i_should_see_the_result_for_and_and(String string, String string2, String string3) {

        System.out.println("Validated combinations: " + string + "," + string2 + "," + string3);
        TestCaseBase.augmentmodule.testSentiments(1,2);
        TestCaseBase.augmentmodule.clickOnEachBrandANDTheme();

    }
}
