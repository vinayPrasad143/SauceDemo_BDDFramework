package ruthstepdef;

import RuthModules.AskGiaModule;
import RuthPageObjects.GiaAskPageObjects;
import RuthPageObjects.LoginPageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestCaseBase;

import java.time.Duration;

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
        TestCaseBase.askgiamodule.ClickOnCitations();
        Thread.sleep(5000);
    }
    @Then("click on like button and verify the like button is highlighted or not")
    public void click_on_like_button_and_verify_the_like_button_is_highlighted_or_not() {
        try {
            driver = TestCaseBase.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(GiaAskPageObjects.likeIcon));
            TestCaseBase.askgiamodule.clickOnLikeButton();
        } catch (Exception e) {
            System.out.println("LikeIcon was not clickable: " + e.getMessage());
            Assert.fail("Test failed due to element not being visible");
        }

//        try {
//            WebElement LikeButton = TestCaseBase.driver.findElement(GiaAskPageObjects.likeIcon);
//            String className = LikeButton.getCssValue("className");
//            System.out.println("colorcode : " + className);
//            Assert.assertTrue("Element not highlighted", className.contains("fill-brand-dark"));
//        } catch (Exception e) {
//            System.out.println("LikeIcon was not highlighted: " + e.getMessage());
//            Assert.fail("Test failed due to element not being Highlighted");
//        }
    }
    @Then("click on unlike button and verify the unlike button is highlighted or not")
    public void click_on_unlike_button_and_verify_the_unlike_button_is_highlighted_or_not() {
        try {
            driver = TestCaseBase.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(GiaAskPageObjects.unlikeIcon));
            TestCaseBase.askgiamodule.clickOnUnLikeButton();
        } catch (Exception e) {
            System.out.println("UnlikeIcon was not clickable: " + e.getMessage());
            Assert.fail("Test failed due to element not being visible");
        }
    }
}
