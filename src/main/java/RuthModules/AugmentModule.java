package RuthModules;

import RuthPageObjects.AugmentPageObjects;
import RuthPageObjects.LoginPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AugmentModule {

    WebDriver driver;
    WebDriverWait wait;
    public AugmentModule(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickOnAugmentTab()
    {
        driver.findElement(AugmentPageObjects.AugmentTab).click();
    }

    public String getHeaderText()
    {
        driver.findElement(AugmentPageObjects.HeaderText).isDisplayed();
        String actualText = driver.findElement(AugmentPageObjects.HeaderText).getText();
        //System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnCountryDropDown()
    {
        driver.findElement(AugmentPageObjects.countryFilter).click();
    }

    public String validateTheSelectedCountryValue() {
        String actualText = driver.findElement(AugmentPageObjects.selectedCountryFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }

    public void clickOnCategoryDropDown()
    {
        driver.findElement(AugmentPageObjects.categoryFilter).click();
    }

    public String validateTheSelectedCategoryValue() {
        String actualText = driver.findElement(AugmentPageObjects.selectedCategoryFilter).getText();
        System.out.println("Actual text: " + actualText);
        return actualText;
    }
    public void clickOnTimePeriodDropDown()
    {
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

            }

        }
    }
}

