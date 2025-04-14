package ruthstepdef;

import RuthPageObjects.ComparePageObjects;
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

public class CompareStepDef {

    WebDriver driver;
    @Given("Navigate to the Compare page")
    public void navigate_to_the_compare_page() throws InterruptedException {
        driver = TestCaseBase.driver;
        TestCaseBase.comparemodule.clickOnCompareTab();
        Thread.sleep(20000);
        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
//            wait.until(ExpectedConditions.presenceOfElementLocated(ComparePageObjects.HeaderText));
//            TestCaseBase.augmentmodule.getHeaderText();
//            String fromUI = TestCaseBase.augmentmodule.getHeaderText();
//            System.out.println("Text from UI: "+ fromUI);
            String actualURL = TestCaseBase.driver.getCurrentUrl();
            System.out.println("Expected text: " + ComparePageObjects.expectedHeaderText);
            Assert.assertEquals("Navigated to Word Cloud page", ComparePageObjects.expectedHeaderText, actualURL);
        } catch (Exception e) {
            System.out.println("Compare page header text was not visible: " + e.getMessage());
            Assert.fail("Test failed due to element not being visible");
        }
    }
    @When("select {string} from the first country dropdown")
    public void select_from_the_first_country_dropdown(String string) throws InterruptedException {
        TestCaseBase.comparemodule.clickOnCountry1DropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI1 = TestCaseBase.comparemodule.validateTheSelectedCountry1Value();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected countries are same", string, fromUI1);
        } catch (Exception e) {
            System.out.println("selected and expected countries are not same: " + e.getMessage());
            Assert.fail("selected and expected country values are not matching");
        }
    }
    @When("select {string} from the first category dropdown")
    public void select_from_the_first_category_dropdown(String string) throws InterruptedException {
        TestCaseBase.comparemodule.clickOnCategoryDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI2 = TestCaseBase.comparemodule.validateTheSelectedCategoryValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected categories are same", string, fromUI2);
        } catch (Exception e) {
            System.out.println("selected and expected categories are not same: " + e.getMessage());
            Assert.fail("selected and expected category values are not matching");
        }
    }
    @When("select {string} from the first Time period dropdown")
    public void select_from_the_first_time_period_dropdown(String string) throws InterruptedException {
        TestCaseBase.comparemodule.clickOnTimePeriod1DropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI3 = TestCaseBase.comparemodule.validateTheSelectedTimePeriod1Value();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected Time periods are same", string, fromUI3);
        } catch (Exception e) {
            System.out.println("selected and expected Time periods are not same: " + e.getMessage());
            Assert.fail("selected and expected Time periods are not matching");
        }
    }
    @When("select {string} from the first Respondent Type dropdown")
    public void select_from_the_first_respondent_type_dropdown(String string) throws InterruptedException {
        TestCaseBase.comparemodule.clickOnRespondentType1DropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI3 = TestCaseBase.comparemodule.validateTheSelectedRespondentType1Value();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected Respondent Types are same", string, fromUI3);
        } catch (Exception e) {
            System.out.println("selected and expected Respondent Types are not same: " + e.getMessage());
            Assert.fail("selected and expected Respondent Types are not matching");
        }
    }
    @When("select {string} from the first Brand dropdown")
    public void select_from_the_first_brand_dropdown(String string) throws InterruptedException {
        TestCaseBase.comparemodule.clickOnBrand1DropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI3 = TestCaseBase.comparemodule.validateTheSelectedBrand1Value();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected Brands are same", string, fromUI3);
        } catch (Exception e) {
            System.out.println("selected and expected Brands are not same: " + e.getMessage());
            Assert.fail("selected and expected Brands are not matching");
        }
    }
    @When("select {string} from the second country dropdown")
    public void select_from_the_second_country_dropdown(String string) throws InterruptedException {
        TestCaseBase.comparemodule.clickOnCountry2DropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI1 = TestCaseBase.comparemodule.validateTheSelectedCountry2Value();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected countries are same", string, fromUI1);
        } catch (Exception e) {
            System.out.println("selected and expected countries are not same: " + e.getMessage());
            Assert.fail("selected and expected country values are not matching");
        }
    }
    @When("select {string} from the second Time period dropdown")
    public void select_from_the_second_time_period_dropdown(String string) throws InterruptedException {
        TestCaseBase.comparemodule.clickOnTimePeriod2DropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI3 = TestCaseBase.comparemodule.validateTheSelectedTimePeriod2Value();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected Time periods are same", string, fromUI3);
        } catch (Exception e) {
            System.out.println("selected and expected Time periods are not same: " + e.getMessage());
            Assert.fail("selected and expected Time periods are not matching");
        }
    }
    @When("select {string} from the second Respondent Type dropdown")
    public void select_from_the_second_respondent_type_dropdown(String string) throws InterruptedException {
        TestCaseBase.comparemodule.clickOnRespondentType2DropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI3 = TestCaseBase.comparemodule.validateTheSelectedRespondentType2Value();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected Respondent Types are same", string, fromUI3);
        } catch (Exception e) {
            System.out.println("selected and expected Respondent Types are not same: " + e.getMessage());
            Assert.fail("selected and expected Respondent Types are not matching");
        }
    }
    @When("select {string} from the second Brand dropdown")
    public void select_from_the_second_brand_dropdown(String string) throws InterruptedException {
        TestCaseBase.comparemodule.clickOnBrand2DropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI3 = TestCaseBase.comparemodule.validateTheSelectedBrand2Value();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected Brands are same", string, fromUI3);
        } catch (Exception e) {
            System.out.println("selected and expected Brands are not same: " + e.getMessage());
            Assert.fail("selected and expected Brands are not matching");
        }
    }
    @Then("should see the result for {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void should_see_the_result_for_and_and_and_and_and_and_and_and(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Validated combinations: " + string + "," + string2 + "," + string3 + "," + string4 + "," + string5 + "," + string6 + "," + string7 + "," + string8 + "," + string9);
        TestCaseBase.comparemodule.clickOnEachTopicsOfInterests();
    }
}
