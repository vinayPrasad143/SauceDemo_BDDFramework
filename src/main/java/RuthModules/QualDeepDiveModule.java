package RuthModules;

import RuthPageObjects.AugmentPageObjects;
import RuthPageObjects.QualDeepDivePageObjects;
import RuthPageObjects.WordCloudPageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class QualDeepDiveModule {

    WebDriver driver;
    WebDriverWait wait;
    public QualDeepDiveModule(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickQualDeepDiveTab()
    {
        driver.findElement(QualDeepDivePageObjects.qualDeepDiveTab).click();
    }

    public String getHeaderText()
    {
        driver.findElement(QualDeepDivePageObjects.HeaderText).isDisplayed();
        String actualText = driver.findElement(QualDeepDivePageObjects.HeaderText).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnCountryDropDown()
    {
        driver.findElement(QualDeepDivePageObjects.countryFilter).click();
    }

    public String validateTheSelectedCountryValue() {
        String actualText = driver.findElement(QualDeepDivePageObjects.selectedCountryFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnCategoryDropDown()
    {
        driver.findElement(QualDeepDivePageObjects.categoryFilter).click();
    }

    public String validateTheSelectedCategoryValue() {
        String actualText = driver.findElement(QualDeepDivePageObjects.selectedCategoryFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }
    public void clickOnTimePeriodDropDown()
    {
        driver.findElement(QualDeepDivePageObjects.timePeriodFilter).click();
    }

    public String validateTheSelectedTimePeriodValue() {
        String actualText = driver.findElement(QualDeepDivePageObjects.selectedTimePeriodFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnRespondentTypeDropDown()
    {
        driver.findElement(QualDeepDivePageObjects.respondentTypeFilter).click();
    }

    public String validateTheSelectedRespondentTypeValue() {
        String actualText = driver.findElement(QualDeepDivePageObjects.selectedRespondentTypeFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnBrandDropDown()
    {
        driver.findElement(QualDeepDivePageObjects.brandFilter).click();
    }

    public String validateTheSelectedBrandValue() {
        String actualText = driver.findElement(QualDeepDivePageObjects.selectedBrandFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnEachTOIAndSubTopicsAndValidateData(int startIndex, int endIndex) {
        List<WebElement> TOI = driver.findElements(QualDeepDivePageObjects.topicsOfInterests);

        for (WebElement item : TOI) {
            // Scroll into view (optional)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
            // Click on the item
            item.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            // Extract text from <span> inside the clicked element
            WebElement span = item.findElement(QualDeepDivePageObjects.toiNames);
            String itemName = span.getText().trim();
            System.out.println("Clicked item: " + itemName);
            WebElement value = item.findElement(QualDeepDivePageObjects.toiValues);
            String toiValue = value.getText().trim();
            int expectedCount1 = Integer.parseInt(toiValue.replaceAll("[^0-9]", ""));
            System.out.println("sentence count: " + expectedCount1);
            List<WebElement> subTopics = driver.findElements(QualDeepDivePageObjects.subTopics);
            for (WebElement subTopic: subTopics) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subTopic);
                // Click on the item
                subTopic.click();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }
                WebElement span1 = subTopic.findElement(QualDeepDivePageObjects.toiNames);
                String itemName1 = span1.getText().trim();
                System.out.println("Clicked sub topic item: " + itemName1);
                WebElement subtopicValue = subTopic.findElement(QualDeepDivePageObjects.toiValues);
                String subTopicValue = subtopicValue.getText().trim();
                int expectedCount = Integer.parseInt(subTopicValue.replaceAll("[^0-9]", ""));
                System.out.println("sub Topic sentence count: " + expectedCount);
                List<WebElement> allReviews = new ArrayList<>();

                while (true) {
                    // Collect reviews on the current page
                    List<WebElement> currentReviews = driver.findElements(QualDeepDivePageObjects.dataLoad);
                    allReviews.addAll(currentReviews);

                    // Try finding the "Next" button (► arrow button)
                    List<WebElement> nextButtons = driver.findElements(QualDeepDivePageObjects.paginationNextButton);

                    // If next button is not found or disabled, break loop
                    if (nextButtons.isEmpty()) {
                        break;
                    }

                    // Click next and wait for page to load
                    nextButtons.get(0).click();
                    new WebDriverWait(driver, Duration.ofSeconds(10))
                            .until(ExpectedConditions.stalenessOf(currentReviews.get(0)));
                }
                int totalReviews = allReviews.size();
                // Final assertion
                //Assert.assertEquals("Mismatch in total review count!", expectedCount, allReviews.size());
                if (totalReviews == expectedCount) {
                    System.out.println("Reviews count matching : expected count = " + expectedCount + " actual count = " + totalReviews);
                } else {
                    System.out.println(" Reviews count is mismatching : expected count = " + expectedCount + " actual count" + totalReviews);
                }

                try {
                    wait.until(ExpectedConditions.presenceOfElementLocated(QualDeepDivePageObjects.reviewsDataLoad));
                    System.out.println("✅ data loaded");
                    for (int i = startIndex; i <= endIndex; i++) {
                        String dynamicXPath = "(//div[@id='deepdive-container']//*[name()='svg'])[" + i + "]";
                        try {
                            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                                    .until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));

                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                            Thread.sleep(1000);
                            element.click();
                            if (i == 2) {
                                System.out.println("✅ Clicked on positive sentiment: " + i);
                                try {
                                    wait.until(ExpectedConditions.presenceOfElementLocated(QualDeepDivePageObjects.reviewsDataLoad));
                                    System.out.println("✅ data loaded");
                                } catch (TimeoutException e) {
                                    WebElement fallback = wait.until(ExpectedConditions.visibilityOfElementLocated(QualDeepDivePageObjects.noDataMessage));
                                    System.out.println("⚠️ no data validation message displayed as : " + fallback.getText());
                                }
                            } else if (i == 3) {
                                System.out.println("✅ Clicked on Neutral sentiment: " + i);
                                try {
                                    wait.until(ExpectedConditions.presenceOfElementLocated(QualDeepDivePageObjects.reviewsDataLoad));
                                    System.out.println("✅ data loaded");
                                } catch (TimeoutException e) {
                                    WebElement fallback = wait.until(ExpectedConditions.visibilityOfElementLocated(QualDeepDivePageObjects.noDataMessage));
                                    System.out.println("⚠️ no data validation message displayed as : " + fallback.getText());
                                }

                            } else {
                                System.out.println("✅ Clicked on Negative sentiment: " + i);
                                try {
                                    wait.until(ExpectedConditions.presenceOfElementLocated(QualDeepDivePageObjects.reviewsDataLoad));
                                    System.out.println("✅ data loaded");
                                } catch (TimeoutException e) {
                                    WebElement fallback = wait.until(ExpectedConditions.visibilityOfElementLocated(QualDeepDivePageObjects.noDataMessage));
                                    System.out.println("⚠️ no data validation message displayed as : " + fallback.getText());
                                }

                            }
                        } catch (Exception e) {
                            System.out.println("❌ Could not click SVG element with index: " + i + " - " + e.getMessage());
                        }
                    }
                } catch (TimeoutException e) {
                    WebElement fallback = wait.until(ExpectedConditions.visibilityOfElementLocated(QualDeepDivePageObjects.noDataMessage));
                    System.out.println("⚠️ no data validation message displayed as : " + fallback.getText());
                }
            }

        }
    }
}
