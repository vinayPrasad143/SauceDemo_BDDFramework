package ruthstepdef;

import RuthPageObjects.WordCloudPageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
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
            Assert.assertEquals(actualURL, WordCloudPageObjects.expectedHeaderText,"Navigated to Word Cloud page");
            System.out.println("Expected Url: " + WordCloudPageObjects.expectedHeaderText + " Actual Url " + actualURL + " User navigates to Wordcloud page properly");
        } catch (Exception e) {
            System.out.println("Word cloud page header text was not visible: " + e.getMessage());
            Assert.fail("Test failed due to element not being visible");
        }

    }
    @When("select {string} from the country dropdown")
    public void select_from_the_country_dropdown(String string) throws InterruptedException {
        TestCaseBase.wordcloudmodule.clickOnCountryDropDown();
        System.out.println("User click's on Country dropdown");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI1 = TestCaseBase.wordcloudmodule.validateTheSelectedCountryValue();
            //System.out.println("expected selected country value: " + string);
            Assert.assertEquals(fromUI1, string,"selected and expected countries are same");
            System.out.println("Actual selected country value: " + fromUI1 + " expected country value: " + string + " selected and expected country values are matching");
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
           // System.out.println("expected selected category value: " + string);
            Assert.assertEquals(fromUI2, string,"selected and expected categories are same");
            System.out.println("Actual selected category value: " + fromUI2 + " expected category value: " + string + " selected and expected category values are matching");
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
           // System.out.println("expected selected value: " + string);
            Assert.assertEquals(fromUI3, string,"selected and expected Time periods are same");
            System.out.println("Actual selected Time period value: " + fromUI3 + " expected Time period value: " + string + " selected and expected Time Period values are matching");
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
            //System.out.println("expected selected value: " + string);
            Assert.assertEquals(fromUI3, string,"selected and expected Respondent Types are same");
            System.out.println("Actual selected Respondent Type value: " + fromUI3 + " expected Respondent Type value: " + string + " selected and expected Respondent Type values are matching");
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
            String fromUI4 = TestCaseBase.wordcloudmodule.validateTheSelectedBrandValue();
            //System.out.println("expected selected value: " + string);
            Assert.assertEquals(fromUI4, string,"selected and expected Brands are same");
            System.out.println("Actual selected Brand value: " + fromUI4 + " expected Brand value: " + string + " selected and expected Brand values are matching");
        } catch (Exception e) {
            System.out.println("selected and expected Brands are not same: " + e.getMessage());
            Assert.fail("selected and expected Brands are not matching");
        }
    }
    @Then("should see the result for the selected filter combination {string} and {string} and {string} and {string} and {string} and verify the sentiment icons are clickable and data loading fine")
    public void should_see_the_result_for_and_and(String string, String string2, String string3, String string4, String string5) throws InterruptedException {

        Thread.sleep(5000);
        System.out.println("Validated combinations: " + string + "," + string2 + "," + string3 + "," + string4 + "," + string5);
        TestCaseBase.wordcloudmodule.clickOnEachTopicsOfInterests(2,4);
        System.out.println("The data is loading fine as expected for all the combinations, sentiments are clickable and data loading fine");
    }
}
