package RuthModules;

import RuthPageObjects.AdvancedAnalysisPageObjects;
import RuthPageObjects.ComparePageObjects;
import RuthPageObjects.GiaAskPageObjects;
import RuthPageObjects.WordCloudPageObjects;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class AdvancedAnalysisModule {

    WebDriver driver;
    WebDriverWait wait;
    public AdvancedAnalysisModule(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickOnAdvancedAnalysisTab()
    {
        driver.findElement(AdvancedAnalysisPageObjects.advancedAnalysisTab).click();
    }

    public String getHeaderText()
    {
        driver.findElement(AdvancedAnalysisPageObjects.HeaderText).isDisplayed();
        String actualText = driver.findElement(AdvancedAnalysisPageObjects.HeaderText).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnCountryDropDown()
    {
        driver.findElement(AdvancedAnalysisPageObjects.countryFilter).click();
    }

    public String validateTheSelectedCountryValue() {
        String actualText = driver.findElement(AdvancedAnalysisPageObjects.selectedCountryFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnCategoryDropDown()
    {
        driver.findElement(AdvancedAnalysisPageObjects.categoryFilter).click();
    }

    public String validateTheSelectedCategoryValue() {
        String actualText = driver.findElement(AdvancedAnalysisPageObjects.selectedCategoryFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }
    public void clickOnTimePeriodDropDown()
    {
        driver.findElement(AdvancedAnalysisPageObjects.timePeriodFilter).click();
    }

    public String validateTheSelectedTimePeriodValue() {
        String actualText = driver.findElement(AdvancedAnalysisPageObjects.selectedTimePeriodFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnRespondentTypeDropDown()
    {
        driver.findElement(AdvancedAnalysisPageObjects.respondentTypeFilter).click();
    }

    public String validateTheSelectedRespondentTypeValue() {
        String actualText = driver.findElement(AdvancedAnalysisPageObjects.selectedRespondentTypeFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }
    public void validateTheCollapseExpandButton() throws InterruptedException {
        List<WebElement> accordions = driver.findElements(AdvancedAnalysisPageObjects.collapseExpandButton);

        for (WebElement accordion : accordions) {
            wait.until(ExpectedConditions.elementToBeClickable(accordion)).click();
            sleep(1000);
            accordion.click();
            sleep(500);
        }
    }

    public void clicksOnEachTopicsAndVerifyDataLoad() throws InterruptedException {
        List<WebElement> TOI = driver.findElements(AdvancedAnalysisPageObjects.topicsSelection);

        for (WebElement topic : TOI) {
            topic.click();
            // Add wait or validation if needed
            Thread.sleep(5000);// Optional pause for visibility

            // Extract text from <span> inside the clicked element
            WebElement span = topic.findElement(AdvancedAnalysisPageObjects.TOIName);
            String itemName = span.getText().trim();
            System.out.println("Clicked item: " + itemName);
            try {
                WebElement dataLoaded = driver.findElement(AdvancedAnalysisPageObjects.dataLoad);
                wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedAnalysisPageObjects.dataLoad));
                WebElement p = dataLoaded.findElement(AdvancedAnalysisPageObjects.dataDisplayed);
                System.out.println(p.getText());
                System.out.println("✅ data loaded");
            }
            catch (TimeoutException e) {
                WebElement fallback = wait.until(ExpectedConditions.visibilityOfElementLocated(AdvancedAnalysisPageObjects.defaultScreenMessage));
                System.out.println("⚠️ no data validation message displayed as : " + fallback.getText());
            }
        }

    }

//    public String copyGeneratedResponseFromCopyTextIcon() {
//        List<WebElement> buttons = driver.findElements(AdvancedAnalysisPageObjects.likeDisLikeCopyClicks);
//        String copiedText = "";
//
//        for (int i = 0; i < buttons.size(); i++) {
//            buttons.get(i).click();
//            if (i==0) {
//
//            }
//            if (i == 2) {
//                copiedText = driver.findElement(AdvancedAnalysisPageObjects.VerifyResponseGenerated).getText();
//            }
//        }
//        return copiedText;
//    }

    public void clickHelpfulButton() {
        driver.findElement(AdvancedAnalysisPageObjects.helpfulIcon).click();
    }

    public boolean isHelpfulButtonDisplayed() {
        return driver.findElement(AdvancedAnalysisPageObjects.helpfulIcon).isDisplayed();
    }

    public boolean isHelpfulButtonEnabled() {
        return driver.findElement(AdvancedAnalysisPageObjects.helpfulIcon).isEnabled();
    }

    public String getHelpfulIconClass() {
        return driver.findElement(AdvancedAnalysisPageObjects.helpfulIconHighlighted).getAttribute("class");
    }

    public void clickOnNotHelpfulButton() {
        driver.findElement(AdvancedAnalysisPageObjects.notHelpfulIcon).click();
    }

    public boolean isNotHelpfulButtonDisplayed() {
        return driver.findElement(AdvancedAnalysisPageObjects.notHelpfulIcon).isDisplayed();
    }

    public boolean isNotHelpfulButtonEnabled() {
        return driver.findElement(AdvancedAnalysisPageObjects.notHelpfulIcon).isEnabled();
    }

    public String getNotHelpfulIconClass() {
        return driver.findElement(AdvancedAnalysisPageObjects.notHelpfulIconHighlighted).getAttribute("class");
    }

    public String copyGeneratedResponseFromCopyTextIcon() {
        List<WebElement> buttons = driver.findElements(AdvancedAnalysisPageObjects.likeDisLikeCopyClicks);
        String copiedText = "";

        for (int i = 0; i < buttons.size(); i++) {
            if (i==0) {

            }
            if (i == 2) {
                buttons.get(i).click();
                copiedText = driver.findElement(AdvancedAnalysisPageObjects.VerifyResponseGenerated).getText();
            }
        }
        return copiedText;
    }
}
