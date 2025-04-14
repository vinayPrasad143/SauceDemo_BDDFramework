package ruthstepdef;

import RuthPageObjects.WordCloudPageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestCaseBase;

import java.time.Duration;

public class WordCloudStepDef {

    WebDriver driver;
    @Given("Navigate to the Word cloud page")
    public void navigate_to_the_Word_Cloud_page() throws InterruptedException {
        driver = TestCaseBase.driver;
        TestCaseBase.wordcloudmodule.clickOnWordCloudTab();
        Thread.sleep(20000);
        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
//            wait.until(ExpectedConditions.presenceOfElementLocated(WordCloudPageObjects.HeaderText));
//            TestCaseBase.augmentmodule.getHeaderText();
//            String fromUI = TestCaseBase.augmentmodule.getHeaderText();
//            System.out.println("Text from UI: "+ fromUI);
            String actualURL = TestCaseBase.driver.getCurrentUrl();
            System.out.println("Expected text: " + WordCloudPageObjects.expectedHeaderText);
            Assert.assertEquals("Navigated to Word Cloud page", WordCloudPageObjects.expectedHeaderText, actualURL);
        } catch (Exception e) {
            System.out.println("Word cloud page header text was not visible: " + e.getMessage());
            Assert.fail("Test failed due to element not being visible");
        }

    }
    @When("select {string} from the country dropdown")
    public void select_from_the_country_dropdown(String string) throws InterruptedException {
        TestCaseBase.wordcloudmodule.clickOnCountryDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI1 = TestCaseBase.wordcloudmodule.validateTheSelectedCountryValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected countries are same", string, fromUI1);
        } catch (Exception e) {
            System.out.println("selected and expected countries are not same: " + e.getMessage());
            Assert.fail("selected and expected country values are not matching");
        }
    }
    @When("select {string} from the category dropdown")
    public void select_from_the_category_dropdown(String string) throws InterruptedException {
        TestCaseBase.wordcloudmodule.clickOnCategoryDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI2 = TestCaseBase.wordcloudmodule.validateTheSelectedCategoryValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected categories are same", string, fromUI2);
        } catch (Exception e) {
            System.out.println("selected and expected categories are not same: " + e.getMessage());
            Assert.fail("selected and expected category values are not matching");
        }
    }
    @When("select {string} from the Time period dropdown")
    public void select_from_the_time_period_dropdown(String string) throws InterruptedException {
        TestCaseBase.wordcloudmodule.clickOnTimePeriodDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI3 = TestCaseBase.wordcloudmodule.validateTheSelectedTimePeriodValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected Time periods are same", string, fromUI3);
        } catch (Exception e) {
            System.out.println("selected and expected Time periods are not same: " + e.getMessage());
            Assert.fail("selected and expected Time periods are not matching");
        }
    }

    @When("select {string} from the Respondent Type dropdown")
    public void select_from_the_Respondent_Type_dropdown(String string) throws InterruptedException {
        TestCaseBase.wordcloudmodule.clickOnRespondentTypeDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI3 = TestCaseBase.wordcloudmodule.validateTheSelectedRespondentTypeValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected Respondent Types are same", string, fromUI3);
        } catch (Exception e) {
            System.out.println("selected and expected Respondent Types are not same: " + e.getMessage());
            Assert.fail("selected and expected Respondent Types are not matching");
        }
    }

    @When("select {string} from the Brand dropdown")
    public void select_from_the_Brand_dropdown(String string) throws InterruptedException {
        TestCaseBase.wordcloudmodule.clickOnBrandDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI3 = TestCaseBase.wordcloudmodule.validateTheSelectedBrandValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected Brands are same", string, fromUI3);
        } catch (Exception e) {
            System.out.println("selected and expected Brands are not same: " + e.getMessage());
            Assert.fail("selected and expected Brands are not matching");
        }
    }
    @Then("should see the result for {string} and {string} and {string} and {string} and {string}")
    public void should_see_the_result_for_and_and(String string, String string2, String string3, String string4, String string5) throws InterruptedException {

        Thread.sleep(5000);
        System.out.println("Validated combinations: " + string + "," + string2 + "," + string3 + "," + string4 + "," + string5);
        TestCaseBase.wordcloudmodule.clickOnEachTopicsOfInterests(2,4);
        TestCaseBase.wordcloudmodule.checkForDataLoading();
    }
}
