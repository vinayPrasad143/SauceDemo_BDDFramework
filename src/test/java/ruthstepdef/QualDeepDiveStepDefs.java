package ruthstepdef;

import RuthPageObjects.QualDeepDivePageObjects;
import RuthPageObjects.WordCloudPageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestCaseBase;

import java.time.Duration;

public class QualDeepDiveStepDefs {

    WebDriver driver;
    @Given("Navigate to the DeepDive page")
    public void navigate_to_the_deep_dive_page() throws InterruptedException {
        driver = TestCaseBase.driver;
        TestCaseBase.qualdeepdivemodule.clickQualDeepDiveTab();
        Thread.sleep(20000);
        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
//            wait.until(ExpectedConditions.presenceOfElementLocated(WordCloudPageObjects.HeaderText));
//            TestCaseBase.augmentmodule.getHeaderText();
//            String fromUI = TestCaseBase.augmentmodule.getHeaderText();
//            System.out.println("Text from UI: "+ fromUI);
            String actualURL = TestCaseBase.driver.getCurrentUrl();
            System.out.println("Expected text: " + QualDeepDivePageObjects.expectedHeaderText);
            Assert.assertEquals("Navigated to DeepDive page", QualDeepDivePageObjects.expectedHeaderText, actualURL);
        } catch (Exception e) {
            System.out.println("DeepDive page header text was not visible: " + e.getMessage());
            Assert.fail("Test failed due to element not being visible");
        }
    }
    @When("select {string} from the country filter")
    public void select_from_the_country_filter(String string) throws InterruptedException {
        TestCaseBase.qualdeepdivemodule.clickOnCountryDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI1 = TestCaseBase.qualdeepdivemodule.validateTheSelectedCountryValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected countries are same", string, fromUI1);
        } catch (Exception e) {
            System.out.println("selected and expected countries are not same: " + e.getMessage());
            Assert.fail("selected and expected country values are not matching");
        }
    }
    @When("select {string} from the category filter")
    public void select_from_the_category_filter(String string) throws InterruptedException {
        TestCaseBase.qualdeepdivemodule.clickOnCategoryDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI2 = TestCaseBase.qualdeepdivemodule.validateTheSelectedCategoryValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected categories are same", string, fromUI2);
        } catch (Exception e) {
            System.out.println("selected and expected categories are not same: " + e.getMessage());
            Assert.fail("selected and expected category values are not matching");
        }
    }
    @When("select {string} from the Time period filter")
    public void select_from_the_time_period_filter(String string) throws InterruptedException {
        TestCaseBase.qualdeepdivemodule.clickOnTimePeriodDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI3 = TestCaseBase.qualdeepdivemodule.validateTheSelectedTimePeriodValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected Time periods are same", string, fromUI3);
        } catch (Exception e) {
            System.out.println("selected and expected Time periods are not same: " + e.getMessage());
            Assert.fail("selected and expected Time periods are not matching");
        }
    }
    @When("select {string} from the Respondent Type filter")
    public void select_from_the_respondent_type_filter(String string) throws InterruptedException {
        TestCaseBase.qualdeepdivemodule.clickOnRespondentTypeDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI3 = TestCaseBase.qualdeepdivemodule.validateTheSelectedRespondentTypeValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected Respondent Types are same", string, fromUI3);
        } catch (Exception e) {
            System.out.println("selected and expected Respondent Types are not same: " + e.getMessage());
            Assert.fail("selected and expected Respondent Types are not matching");
        }
    }
    @When("select {string} from the Brand filter")
    public void select_from_the_brand_filter(String string) throws InterruptedException {
        TestCaseBase.qualdeepdivemodule.clickOnBrandDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI3 = TestCaseBase.qualdeepdivemodule.validateTheSelectedBrandValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected Brands are same", string, fromUI3);
        } catch (Exception e) {
            System.out.println("selected and expected Brands are not same: " + e.getMessage());
            Assert.fail("selected and expected Brands are not matching");
        }
    }
    @Then("i should see the result for {string} and {string} and {string} and {string} and {string}")
    public void i_should_see_the_result_for_and_and_and_and(String string, String string2, String string3, String string4, String string5) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Validated combinations: " + string + "," + string2 + "," + string3 + "," + string4 + "," + string5);
        TestCaseBase.qualdeepdivemodule.clickOnEachTOIAndSubTopicsAndValidateData(2,4);
    }
}
