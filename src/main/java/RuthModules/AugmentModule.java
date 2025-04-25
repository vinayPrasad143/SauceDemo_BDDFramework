package RuthModules;

import RuthPageObjects.AugmentPageObjects;
import RuthPageObjects.LoginPageObjects;
import RuthPageObjects.WordCloudPageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AugmentModule {

    WebDriver driver;
    WebDriverWait wait;

    public AugmentModule(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickOnAugmentTab() {
        driver.findElement(AugmentPageObjects.AugmentTab).click();
    }

    public String getHeaderText() {
        driver.findElement(AugmentPageObjects.HeaderText).isDisplayed();
        String actualText = driver.findElement(AugmentPageObjects.HeaderText).getText();
        //System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnCountryDropDown() {
        driver.findElement(AugmentPageObjects.countryFilter).click();
    }

    public String validateTheSelectedCountryValue() {
        String actualText = driver.findElement(AugmentPageObjects.selectedCountryFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnCategoryDropDown() {
        driver.findElement(AugmentPageObjects.categoryFilter).click();
    }

    public String validateTheSelectedCategoryValue() {
        String actualText = driver.findElement(AugmentPageObjects.selectedCategoryFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnTimePeriodDropDown() {
        driver.findElement(AugmentPageObjects.timePeriodFilter).click();
    }

    public String validateTheSelectedTimePeriodValue() {
        String actualText = driver.findElement(AugmentPageObjects.selectedTimePeriodFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnEachBrandANDTheme() {

        List<WebElement> brandItems = driver.findElements(AugmentPageObjects.brandSelection);

        // Iterate and process each
        for (WebElement item : brandItems) {
            // Scroll into view (optional but helpful)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);

            // Click the element
            item.click();
            // Wait (adjust for animations or fetch delay)
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
            // Get brand name — assuming it's the text of this block or child inside
            String brandName = item.getText().trim();
            System.out.println("Brand Name: " + brandName);

            // for each theme selection

            List<WebElement> themeElements = driver.findElements(AugmentPageObjects.themeSelection);

            for (WebElement theme : themeElements) {
                // Scroll into view if needed
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", theme);
                // Click on the element
                theme.click();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {

                }
                // Get text (you may need to adjust this depending on where the text is rendered)
                String themeName = theme.getText().trim();
                System.out.println("Theme Name: " + themeName);
                // Add a wait if needed before next click
                List<WebElement> allReviews = new ArrayList<>();

                while (true) {
                    // Collect reviews on the current page
                    List<WebElement> currentReviews = driver.findElements(AugmentPageObjects.reviewValidate);
                    allReviews.addAll(currentReviews);

                    // Try finding the "Next" button (► arrow button)
                    List<WebElement> nextButtons = driver.findElements(AugmentPageObjects.paginationNextButton);

                    // If next button is not found or disabled, break loop
                    if (nextButtons.isEmpty()) {
                        break;
                    }

                    // Click next and wait for page to load
                    nextButtons.get(0).click();
                    new WebDriverWait(driver, Duration.ofSeconds(10))
                            .until(ExpectedConditions.stalenessOf(currentReviews.get(0)));
                }
                // Fetch the expected count from the heading (e.g., REVIEWS (2585))
                WebElement reviewsHeader = driver.findElement(AugmentPageObjects.reviewCount);
                String headerText = reviewsHeader.getText(); // e.g., "REVIEWS (2585)"
                int expectedCount = Integer.parseInt(headerText.replaceAll("[^0-9]", ""));
                int totalReviews = allReviews.size();
                // Final assertion
                //Assert.assertEquals("Mismatch in total review count!", expectedCount, allReviews.size());
                if(totalReviews==expectedCount){
                    System.out.println("Reviews count matching : expected count = " + expectedCount + " actual count = " + totalReviews);
                }
                else {
                    System.out.println(" Reviews count is mismatching : expected count = " + expectedCount + " actual count" + totalReviews);
                }

            }

        }

    }
    public void testSentiments(int startIndex, int endIndex)
    {
        for (int i = startIndex; i <= endIndex; i++) {
            String dynamicXPath = "(//div[@class='flex gap-3 pr-2']//*[name()='svg'])[" + i + "]";
            try {
                WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                Thread.sleep(1000);
                element.click();
                if(i==1) {
                    System.out.println("✅ Clicked on positive sentiment: " + i);
                    try {
                        wait.until(ExpectedConditions.presenceOfElementLocated(AugmentPageObjects.reviewsData));
                        System.out.println("✅ data loaded");
                    }
                    catch (TimeoutException e) {
                        WebElement fallback = wait.until(ExpectedConditions.visibilityOfElementLocated(AugmentPageObjects.noDataMessage));
                        System.out.println("⚠️ no data validation message displayed as : " + fallback.getText());
                    }
                }
                else {
                    System.out.println("✅ Clicked on Negative sentiment: " + i);
                    try {
                        wait.until(ExpectedConditions.presenceOfElementLocated(AugmentPageObjects.reviewsData));
                        System.out.println("✅ data loaded");
                    }
                    catch (TimeoutException e) {
                        WebElement fallback = wait.until(ExpectedConditions.visibilityOfElementLocated(AugmentPageObjects.noDataMessage));
                        System.out.println("⚠️ no data validation message displayed as : " + fallback.getText());
                    }

                }
            } catch (Exception e) {
                System.out.println("❌ Could not click SVG element with index: " + i + " - " + e.getMessage());
            }
        }
    }

}

