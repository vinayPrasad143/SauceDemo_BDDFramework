package RuthModules;

import RuthPageObjects.ComparePageObjects;
import RuthPageObjects.WordCloudPageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CompareModule {

    WebDriver driver;
    WebDriverWait wait;
    public CompareModule(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickOnCompareTab()
    {
        driver.findElement(ComparePageObjects.compareTab).click();
    }

    public String getHeaderText()
    {
        driver.findElement(ComparePageObjects.HeaderText).isDisplayed();
        String actualText = driver.findElement(ComparePageObjects.HeaderText).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }
    public void clickOnCountry1DropDown()
    {
        driver.findElement(ComparePageObjects.countryFilter).click();
    }

    public String validateTheSelectedCountry1Value() {
        String actualText = driver.findElement(ComparePageObjects.selectedCountryFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnCategoryDropDown()
    {
        driver.findElement(ComparePageObjects.categoryFilter).click();
    }

    public String validateTheSelectedCategoryValue() {
        String actualText = driver.findElement(ComparePageObjects.selectedCategoryFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }
    public void clickOnTimePeriod1DropDown()
    {
        driver.findElement(ComparePageObjects.timePeriodFilter).click();
    }

    public String validateTheSelectedTimePeriod1Value() {
        String actualText = driver.findElement(ComparePageObjects.selectedTimePeriodFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnRespondentType1DropDown()
    {
        driver.findElement(ComparePageObjects.respondentTypeFilter).click();
    }

    public String validateTheSelectedRespondentType1Value() {
        String actualText = driver.findElement(ComparePageObjects.selectedRespondentTypeFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnBrand1DropDown()
    {
        driver.findElement(ComparePageObjects.brandFilter).click();
    }

    public String validateTheSelectedBrand1Value() {
        String actualText = driver.findElement(ComparePageObjects.selectedBrandFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }
    public void clickOnCountry2DropDown()
    {
        driver.findElement(ComparePageObjects.country2Filter).click();
    }

    public String validateTheSelectedCountry2Value() {
        String actualText = driver.findElement(ComparePageObjects.selectedCountry2Filter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnTimePeriod2DropDown()
    {
        driver.findElement(ComparePageObjects.timePeriod2Filter).click();
    }

    public String validateTheSelectedTimePeriod2Value() {
        String actualText = driver.findElement(ComparePageObjects.selectedTimePeriod2Filter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnRespondentType2DropDown()
    {
        driver.findElement(ComparePageObjects.respondentType2Filter).click();
    }

    public String validateTheSelectedRespondentType2Value() {
        String actualText = driver.findElement(ComparePageObjects.selectedRespondentType2Filter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnBrand2DropDown()
    {
        driver.findElement(ComparePageObjects.brand2Filter).click();
    }

    public String validateTheSelectedBrand2Value() {
        String actualText = driver.findElement(ComparePageObjects.selectedBrand2Filter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnEachTopicsOfInterests() {
        List<WebElement> TOI = driver.findElements(ComparePageObjects.topicsOfInterests);

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
            WebElement span = item.findElement(ComparePageObjects.TOIName);
            String itemName = span.getText().trim();
            System.out.println("Clicked item: " + itemName);

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(ComparePageObjects.dataLoad));

                System.out.println("✅ data loaded");
            }
            catch (TimeoutException e) {
                WebElement fallback = wait.until(ExpectedConditions.visibilityOfElementLocated(ComparePageObjects.noDataMessage));
                System.out.println("⚠️ no data validation message displayed as : " + fallback.getText());
            }

        }
    }
}
