package ruthstepdef;

import RuthModules.AskGiaModule;
import RuthPageObjects.GiaAskPageObjects;
import RuthPageObjects.LoginPageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import tests.TestCaseBase;
import utilities.WordUtility;

import java.time.Duration;
import java.util.List;


public class GiaAskStepDef {

    WebDriver driver;

    @Given("Enter the {string} in the query search box")
    public void enter_the_in_the_query_search_box(String string) {
        TestCaseBase.askgiamodule.enterQueryIntheQueryField(string);
    }
    @Given("Click on the search Query button")
    public void click_on_the_search_query_button() throws InterruptedException {
        TestCaseBase.askgiamodule.clickOnSearchQueryButton();
        Thread.sleep(10000);
    }
    @Then("Verify the display of the Response")
    public void verify_the_display_of_the_response() throws InterruptedException {

        try {
            driver = TestCaseBase.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.visibilityOfElementLocated(GiaAskPageObjects.queryResponse));
        } catch (Exception e) {
            System.out.println("response was not visible: " + e.getMessage());
            Assert.fail("Test failed due to element not being visible");
        }
        Thread.sleep(20000);
        System.out.println("Query generated");
    }
    @Then("click on the citations icon")
    public void click_on_the_citations_icon() throws InterruptedException {
        try {
            driver = TestCaseBase.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(GiaAskPageObjects.citationIcon));
            TestCaseBase.askgiamodule.clickOnCitationsIcon();
        } catch (Exception e) {
            System.out.println("citationIcon was not clickable: " + e.getMessage());
            Assert.fail("Test failed due to element not being clickable");
        }

        Thread.sleep(10000);
    }
    @Then("Verify the citations")
    public void verify_the_citations() throws InterruptedException {
        try {
            driver = TestCaseBase.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.visibilityOfElementLocated(GiaAskPageObjects.citationsDisplay));
            TestCaseBase.askgiamodule.verifyTheDisplayOfTheCitations();
        } catch (Exception e) {
            System.out.println("citations was not visible: " + e.getMessage());
            Assert.fail("Test failed due to element not being visible");
        }
            SoftAssert softAssert = new SoftAssert();

            // Locate all review containers that are clickable
            List<WebElement> reviewElements = driver.findElements(GiaAskPageObjects.clickToCheckCitations);

            for (int i = 0; i < reviewElements.size(); i++) {
                WebElement review = reviewElements.get(i);
                String expectedReview = review.getText().trim();
                String trimmedExpectedReview = expectedReview.split("\\.")[0];
                // Click the review to open the detailed popup
                review.click();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
                wait.until(ExpectedConditions.visibilityOfElementLocated(GiaAskPageObjects.highlightedTextInCitations));

                // Extract the highlighted text
                WebElement highlighted = driver.findElement(GiaAskPageObjects.highlightedTextInCitations);
                String actualHighlightedText = highlighted.getText().replace("R:", "").trim();

                // Assertion using SoftAssert
//                softAssert.assertTrue(actualHighlightedText.contains(trimmedExpectedReview),
//                        "Mismatch at review #" + (i + 1) + ": Expected to contain '" + trimmedExpectedReview + "', but got '" + actualHighlightedText + "'");
                softAssert.assertTrue(TestCaseBase.askgiamodule.areTextsSimilar(trimmedExpectedReview, actualHighlightedText),
                        "Mismatch at review #" + (i + 1) + ": Expected to contain '" + trimmedExpectedReview + "', but got '" + actualHighlightedText + "'");
                WebElement closeButton = driver.findElement(GiaAskPageObjects.closeIconOnCitations);
                closeButton.click();
            }

            // Final assert to report any soft failures
            softAssert.assertAll();
        }
    @Then("click on like icon and verify the like icon is highlighted or not")
    public void click_on_like_button_and_verify_the_like_button_is_highlighted_or_not() {
        Assert.assertTrue("Helpful icon is not displayed", TestCaseBase.askgiamodule.isHelpfulButtonDisplayed());
        Assert.assertTrue("Helpful icon is not enabled", TestCaseBase.askgiamodule.isHelpfulButtonEnabled());

        TestCaseBase.askgiamodule.clickHelpfulButton();
        System.out.println("Click on Helpful icon");
        // Optionally wait for DOM update
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        String iconClass = TestCaseBase.askgiamodule.getHelpfulIconClass();
        System.out.println("Post-click SVG class: " + iconClass);
        // Replace with your actual highlighted class if different
        Assert.assertTrue("Helpfull icon is not highlighted after click", iconClass.contains("fill-brand-dark"));

    }
    @Then("click on unlike icon and verify the unlike icon is highlighted or not")
    public void click_on_unlike_button_and_verify_the_unlike_button_is_highlighted_or_not() {
        Assert.assertTrue("NotHelpful icon is not displayed", TestCaseBase.askgiamodule.isNotHelpfulButtonDisplayed());
        Assert.assertTrue("NotHelpful icon is not enabled", TestCaseBase.askgiamodule.isNotHelpfulButtonEnabled());

        TestCaseBase.askgiamodule.clickOnNotHelpfulButton();
        System.out.println("Click on NotHelpful icon");

        // Optionally wait for DOM update
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        String iconClass = TestCaseBase.askgiamodule.getNotHelpfulIconClass();
        System.out.println("Post-click SVG class: " + iconClass);
        // Replace with your actual highlighted class if different
        Assert.assertTrue("NotHelpful Button is not highlighted after click", iconClass.contains("fill-brand-dark"));
    }

    @Then("click on the copy and verify that the copy of the response is copied to the word doc or not")
    public void click_on_the_copy_and_verify_that_the_copy_of_the_response_is_copied_to_the_word_doc_or_not(){
        String responseGenerated = TestCaseBase.advancedanalysismodule.copyGeneratedResponseFromCopyTextIcon();
        WordUtility.writeToWordDoc(responseGenerated, "D:\\Github_location\\seleniumlearning\\src\\main\\java\\Responses\\GeneratedResponseonAskGiapage.docx");
    }
}
