package RuthModules;

import RuthPageObjects.AugmentPageObjects;
import RuthPageObjects.WordCloudPageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WordCloudModule {

    WebDriver driver;
    WebDriverWait wait;
    public WordCloudModule(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickOnWordCloudTab()
    {
        driver.findElement(WordCloudPageObjects.wordCloudTab).click();
    }

    public String getHeaderText()
    {
        driver.findElement(WordCloudPageObjects.HeaderText).isDisplayed();
        String actualText = driver.findElement(WordCloudPageObjects.HeaderText).getText();
       // System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnCountryDropDown()
    {
        driver.findElement(WordCloudPageObjects.countryFilter).click();
    }

    public String validateTheSelectedCountryValue() {
        String actualText = driver.findElement(WordCloudPageObjects.selectedCountryFilter).getText();
       // System.out.println("Actual selected country value: " + actualText);
        return actualText;
    }

    public void clickOnCategoryDropDown()
    {
        driver.findElement(WordCloudPageObjects.categoryFilter).click();
    }

    public String validateTheSelectedCategoryValue() {
        String actualText = driver.findElement(WordCloudPageObjects.selectedCategoryFilter).getText();
       // System.out.println("Actual text: " + actualText);
        return actualText;
    }
    public void clickOnTimePeriodDropDown()
    {
        driver.findElement(WordCloudPageObjects.timePeriodFilter).click();
    }

    public String validateTheSelectedTimePeriodValue() {
        String actualText = driver.findElement(WordCloudPageObjects.selectedTimePeriodFilter).getText();
       // System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnRespondentTypeDropDown()
    {
        driver.findElement(WordCloudPageObjects.respondentTypeFilter).click();
    }

    public String validateTheSelectedRespondentTypeValue() {
        String actualText = driver.findElement(WordCloudPageObjects.selectedRespondentTypeFilter).getText();
      //  System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnBrandDropDown()
    {
        driver.findElement(WordCloudPageObjects.brandFilter).click();
    }

    public String validateTheSelectedBrandValue() {
        String actualText = driver.findElement(WordCloudPageObjects.selectedBrandFilter).getText();
      //  System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnEachTopicsOfInterests(int startIndex, int endIndex) {
        List<WebElement> TOI = driver.findElements(WordCloudPageObjects.topicsOfInterests);

        for (WebElement item : TOI) {
            // Scroll into view (optional)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);

            // Click on the item
            item.click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
            // Extract text from <span> inside the clicked element
            WebElement span = item.findElement(WordCloudPageObjects.TOIName);
            String itemName = span.getText().trim();
            System.out.println("Selected Topic: " + itemName);

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(WordCloudPageObjects.dataLoad));
                System.out.println("✅ data loaded for "+ itemName);
                for (int i = startIndex; i <= endIndex; i++) {
                    String dynamicXPath = "(//div[@id='chat-container']//*[name()='svg'])[" + i + "]";
                    try {
                        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                                .until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));

                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                        Thread.sleep(1000);
                        element.click();
                        if(i==2) {
                            System.out.println("✅ Clicked on positive sentiment icon");
                            Thread.sleep(1000);
                            try {
                                wait.until(ExpectedConditions.presenceOfElementLocated(WordCloudPageObjects.dataLoad));
                                System.out.println("✅ data loaded for positive sentiment");
                            }
                            catch (TimeoutException e) {
                                WebElement fallback = wait.until(ExpectedConditions.visibilityOfElementLocated(WordCloudPageObjects.noDataMessage));
                                System.out.println("⚠️ no data validation message displayed as : " + fallback.getText() + "positive sentiment");
                            }
                        }
                        else if(i==3) {
                            System.out.println("✅ Clicked on Neutral sentiment icon");
                            Thread.sleep(1000);
                            try {
                                wait.until(ExpectedConditions.presenceOfElementLocated(WordCloudPageObjects.dataLoad));
                                System.out.println("✅ data loaded for Neutral sentiment");
                            }
                            catch (TimeoutException e) {
                                WebElement fallback = wait.until(ExpectedConditions.visibilityOfElementLocated(WordCloudPageObjects.noDataMessage));
                                System.out.println("⚠️ no data validation message displayed as : " + fallback.getText() + "Neutral sentiment");
                            }

                        }
                        else {
                            System.out.println("✅ Clicked on Negative sentiment");
                            Thread.sleep(1000);
                            try {
                                wait.until(ExpectedConditions.presenceOfElementLocated(WordCloudPageObjects.dataLoad));
                                System.out.println("✅ data loaded for Negative sentiment");
                            }
                            catch (TimeoutException e) {
                                WebElement fallback = wait.until(ExpectedConditions.visibilityOfElementLocated(WordCloudPageObjects.noDataMessage));
                                System.out.println("⚠️ no data validation message displayed as : " + fallback.getText() + "Negative sentiment");
                            }

                        }
                    } catch (Exception e) {
                        System.out.println("❌ Could not click SVG element with index: " + i + " - " + e.getMessage());
                    }
                }
            } catch (TimeoutException e) {
                WebElement fallback = wait.until(ExpectedConditions.visibilityOfElementLocated(WordCloudPageObjects.noDataMessage));
                System.out.println("⚠️ no data validation message displayed as : " + fallback.getText() + " for " + itemName);
            }

        }
    }

}
