package RuthModules;

import RuthPageObjects.AdvancedAnalysisPageObjects;
import RuthPageObjects.GiaAskPageObjects;
import RuthPageObjects.LoginPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AskGiaModule {

    WebDriver driver;
    WebDriverWait wait;
    public AskGiaModule(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void enterQueryIntheQueryField(String string){
        driver.findElement(GiaAskPageObjects.AskGiaQueryTextBox).sendKeys(string);
    }
    public void clickOnSearchQueryButton(){
        driver.findElement(GiaAskPageObjects.searchQuery).click();
    }
    public void VerifyTheDisplayOfTheResponse()
    {
        driver.findElement(GiaAskPageObjects.queryResponse).isDisplayed();
    }
    public void clickOnCitationsIcon()
    {
        driver.findElement(GiaAskPageObjects.citationIcon).click();
    }

    public void verifyTheDisplayOfTheCitations(){

            driver.findElements(GiaAskPageObjects.citationsDisplay);
    }
//    public void ClickOnCitations(){
//
//        driver.findElement(GiaAskPageObjects.clickToCheckCitations).click();
//    }


    public void clickOnLikeButton()
    {
        WebElement LikeButton = driver.findElement(GiaAskPageObjects.likeIcon);
        LikeButton.click();

    }
    public void clickOnUnLikeButton()
    {
        driver.findElement(GiaAskPageObjects.unlikeIcon).click();
    }

    public void clickOnPreviousButton()
    {
        driver.findElement(GiaAskPageObjects.previousButton).click();
    }

    public void clickOnNextButton()
    {
        driver.findElement(GiaAskPageObjects.nextButton).click();
    }

    public void clickHelpfulButton() {
        driver.findElement(GiaAskPageObjects.helpfulIcon).click();
    }

    public boolean isHelpfulButtonDisplayed() {
        return driver.findElement(GiaAskPageObjects.helpfulIcon).isDisplayed();
    }

    public boolean isHelpfulButtonEnabled() {
        return driver.findElement(GiaAskPageObjects.helpfulIcon).isEnabled();
    }

    public String getHelpfulIconClass() {
        return driver.findElement(GiaAskPageObjects.helpfulIconHighlighted).getAttribute("class");
    }

    public void clickOnNotHelpfulButton() {
        driver.findElement(GiaAskPageObjects.notHelpfulIcon).click();
    }

    public boolean isNotHelpfulButtonDisplayed() {
        return driver.findElement(GiaAskPageObjects.notHelpfulIcon).isDisplayed();
    }

    public boolean isNotHelpfulButtonEnabled() {
        return driver.findElement(GiaAskPageObjects.notHelpfulIcon).isEnabled();
    }

    public String getNotHelpfulIconClass() {
        return driver.findElement(GiaAskPageObjects.notHelpfulIconHighlighted).getAttribute("class");
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

//    public String getHighlightedPopupText() {
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement highlightedTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(GiaAskPageObjects.highlightedTextInCitations));
//
//            String highlightedText = highlightedTextElement.getText().trim();
//            System.out.println("Highlighted Text: " + highlightedText);
//            return highlightedText;
//        } catch (TimeoutException e) {
//            System.err.println("Highlighted text not found!");
//            return "";
//        }
//    }
//
//    public void clickOnEachCitationsAndGetTheCitationsText(){
//
//        List<WebElement> reviewCards = driver.findElements(GiaAskPageObjects.clickToCheckCitations);
//
//        for (WebElement card : reviewCards) {
//            // Click on the card
//            card.click();
//
//            // Get the review text inside it
//            String reviewText = card.findElement(GiaAskPageObjects.citationsText).getText();
//            System.out.println("Review: " + reviewText);
//
//            // Optional: wait for popup/modal if needed
//            // driver.findElement(By.id("detailed-popup")).isDisplayed();
//
//            break; // remove this if you want to loop all
//        }
//    }
//public void validateAllReviewTexts() {
//    List<WebElement> cards = driver.findElements(By.xpath("//div[contains(@class,'p-3') and contains(@class,'cursor-pointer')]"));
//
//    for (int i = 0; i < cards.size(); i++) {
//        // Refetch cards to avoid StaleElementReferenceException
//        cards = driver.findElements(GiaAskPageObjects.clickToCheckCitations);
//        WebElement card = cards.get(i);
//
//        // Get card text before click
//        String cardText = card.findElement(By.xpath(".//p[contains(@class, 'text-sm')]")).getText().trim();
//
//        // Click the card
//        card.click();
//
//        // Wait for the popup & get highlighted text
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement highlighted = wait.until(ExpectedConditions.visibilityOfElementLocated(GiaAskPageObjects.highlightedTextInCitations));
//
//        String popupText = highlighted.getText().trim();
//
//        // Validate
//        Assert.assertTrue("Mismatch in review text at index " + i, popupText.contains(cardText));
//
//        // Close the popup (you may need to adjust this locator)
//        WebElement closeBtn = driver.findElement(By.xpath("//button[contains(@aria-label,'close') or contains(@class, 'close')]"));
//        closeBtn.click();
//
//        // Optional wait to allow popup to close properly
//        Thread.sleep(500);
//    }
//}

}
