package ruthstepdef;

import RuthPageObjects.AdvancedAnalysisPageObjects;
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
import utilities.WordUtility;

import java.time.Duration;

public class AdvancedAnalysisStepDef {

    WebDriver driver;
    @Given("Navigate to the AdvancedAnalysis page")
    public void navigate_to_the_advanced_analysis_page() throws InterruptedException {
        driver = TestCaseBase.driver;
        TestCaseBase.advancedanalysismodule.clickOnAdvancedAnalysisTab();
        Thread.sleep(20000);
        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
//            wait.until(ExpectedConditions.presenceOfElementLocated(WordCloudPageObjects.HeaderText));
//            TestCaseBase.augmentmodule.getHeaderText();
//            String fromUI = TestCaseBase.augmentmodule.getHeaderText();
//            System.out.println("Text from UI: "+ fromUI);
            String actualURL = TestCaseBase.driver.getCurrentUrl();
            System.out.println("Expected text: " + AdvancedAnalysisPageObjects.expectedHeaderText);
            Assert.assertEquals("Navigated to Advanced Analysis page", AdvancedAnalysisPageObjects.expectedHeaderText, actualURL);
        } catch (Exception e) {
            System.out.println("Advanced Analysis page header text was not visible: " + e.getMessage());
            Assert.fail("Test failed due to element not being visible");
        }
    }
    @Given("Verify the functionality of the collapse and expand of Trending Topics section")
    public void verify_the_functionality_of_the_collapse_and_expand_of_trending_topics_section() throws InterruptedException {
        TestCaseBase.advancedanalysismodule.validateTheCollapseExpandButton();
    }

    @Then("User should see the insight section text {string} for default screen when nothing is selected on Topics section")
    public void user_should_see_the_insight_section_text(String string) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AdvancedAnalysisPageObjects.defaultScreenMessage));
        String actualText = textElement.getText();
        Assert.assertEquals("Text content mismatch!", string, actualText);
    }
    @When("select {string} from the country dropdown filter")
    public void select_from_the_country_dropdown_filter(String string) throws InterruptedException {
        TestCaseBase.advancedanalysismodule.clickOnCountryDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI1 = TestCaseBase.advancedanalysismodule.validateTheSelectedCountryValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected countries are same", string, fromUI1);
        } catch (Exception e) {
            System.out.println("selected and expected countries are not same: " + e.getMessage());
            Assert.fail("selected and expected country values are not matching");
        }
    }
    @When("select {string} from the category dropdown filter")
    public void select_from_the_category_dropdown_filter(String string) throws InterruptedException {
        TestCaseBase.advancedanalysismodule.clickOnCategoryDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI2 = TestCaseBase.advancedanalysismodule.validateTheSelectedCategoryValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected categories are same", string, fromUI2);
        } catch (Exception e) {
            System.out.println("selected and expected categories are not same: " + e.getMessage());
            Assert.fail("selected and expected category values are not matching");
        }
    }
    @When("select {string} from the Time period dropdown filter")
    public void select_from_the_time_period_dropdown_filter(String string) throws InterruptedException {
        TestCaseBase.advancedanalysismodule.clickOnTimePeriodDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI3 = TestCaseBase.advancedanalysismodule.validateTheSelectedTimePeriodValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected Time periods are same", string, fromUI3);
        } catch (Exception e) {
            System.out.println("selected and expected Time periods are not same: " + e.getMessage());
            Assert.fail("selected and expected Time periods are not matching");
        }
    }
    @When("select {string} from the Respondent Type dropdown filter")
    public void select_from_the_respondent_type_dropdown_filter(String string) throws InterruptedException {
        TestCaseBase.advancedanalysismodule.clickOnRespondentTypeDropDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(@data-value,'" + string + "')]")));
        Thread.sleep(2000);
        option.click();
        try {
            String fromUI3 = TestCaseBase.advancedanalysismodule.validateTheSelectedRespondentTypeValue();
            System.out.println("expected selected value: " + string);
            Assert.assertEquals("selected and expected Respondent Types are same", string, fromUI3);
        } catch (Exception e) {
            System.out.println("selected and expected Respondent Types are not same: " + e.getMessage());
            Assert.fail("selected and expected Respondent Types are not matching");
        }
    }
    @Then("user should see the result for for all the Topics for {string} and {string} and {string} and {string} combination")
    public void user_should_see_the_result_for_all_the_Topics_for_and_and_and(String string, String string2, String string3, String string4) throws InterruptedException {
        System.out.println("Validated combinations: " + string + "," + string2 + "," + string3 + "," + string4);
        TestCaseBase.advancedanalysismodule.clicksOnEachTopicsAndVerifyDataLoad();
    }

    @Then("I click all feedback buttons and save the third feedback to a Word file")
    public void clickFeedbackAndSaveToWord() {
        String responseGenerated = TestCaseBase.advancedanalysismodule.clickOnLikeDislikeAndCopyGeneratedResponseFromCopyTextIcon();
        WordUtility.writeToWordDoc(responseGenerated, "D:\\Github_location\\seleniumlearning\\src\\main\\java\\Responses\\GeneratedResponse.docx");
    }

    @Then("^user should see filter summary as \"([^\"]*) ; Category: ([^\"]*) ; Time period: ([^\"]*) ; Respondent type: ([^\"]*)\"$")
    public void validateFilterSummary(String country, String category, String timePeriod, String respondentType) {
        String expectedText = String.format("%s ; Category: %s ; Time period: %s ; Respondent type: %s",
                country, category, timePeriod, respondentType);

        WebElement summaryElement = driver.findElement(By.xpath("//div[contains(@class,'italic')]"));
        String actualText = summaryElement.getText().trim();

        Assert.assertEquals("Filter summary does not match!", expectedText, actualText);
    }
}
