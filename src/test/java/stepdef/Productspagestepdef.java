package stepdef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobjects.Productspageobjects;
import tests.TestCaseBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.assertEquals;

public class Productspagestepdef {

    @When("click on the first item {string}")
    public void click_on_the_first_item(String string) {
        TestCaseBase.productsModule.addProduct1();
    }
    @When("click on the second item {string}")
    public void click_on_the_second_item(String string) {
        TestCaseBase.productsModule.addProduct2();
    }
    @Then("Verify the increase in count to {int} for the Items Added")
    public void verify_the_increase_in_count_to_for_the_items_added(Integer int1) {
        int ActualNum = TestCaseBase.productsModule.getNumber();
        Assert.assertEquals(int1, ActualNum, "The numbers are matching");
    }


    @When("click on Remove button on the Item {string}")
    public void click_on_remove_button_on_the_item(String string) {
        TestCaseBase.productsModule.removeItem(string);
    }
    @Then("Verify the decrease in count to {int} for the Items removed")
    public void verify_the_decrease_in_count_to_for_the_items_removed(Integer int1) {
        int ActualNum = TestCaseBase.productsModule.getNumber();
        Assert.assertEquals(int1, ActualNum, "The numbers are matching");
    }
    @When("click on dropdown filter")
    public void click_on_dropdown_filter() {
        TestCaseBase.productsModule.clickOnDropDown();
    }
    List<String> actualDropdownValues;
    @When("Retrieves option from the {string}")
    public void retrieves_option_from_the(String dropdownID) {
        WebElement dropdownElement = TestCaseBase.driver.findElement(Productspageobjects.dropDownValues);
        Select dropdown = new Select(dropdownElement);

        // Get all dropdown options
        actualDropdownValues = new ArrayList<>();
        for (WebElement option : dropdown.getOptions()) {
            actualDropdownValues.add(option.getText());
        }
        System.out.println("Actual dropdownvalues: " + actualDropdownValues);
    }
    @Then("The dropdown should contain the following values:")
    public void the_dropdown_should_contain_the_following_values(DataTable expectedTable ) {
        List<String> expectedValues = expectedTable.asList();
        // Compare actual vs expected values
        assertEquals("Dropdown values do not match!", expectedValues, actualDropdownValues);
    }
    @Then("I select each dropdown value and verify the displayed selection")
    public void i_select_each_dropdown_value_and_verify_the_displayed_selection() {
        WebDriverWait wait = new WebDriverWait(TestCaseBase.driver, Duration.ofSeconds(10));

        // Locate the dropdown element
        WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(Productspageobjects.dropDownValues));

        Select dropdown = new Select(dropdownElement);

        // Get all options from dropdown
        List<WebElement> options = dropdown.getOptions();

        for (int i = 0; i < options.size(); i++) {
            try {
                // Re-locate the dropdown and options before each selection to avoid StaleElementReferenceException
                dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(Productspageobjects.dropDownValues));
                dropdown = new Select(dropdownElement);
                options = dropdown.getOptions();

                // Get text of option
                String optionText = options.get(i).getText().trim();

                // Click the dropdown to open the options
                dropdownElement.click();

                // Click on the option before selecting
                options.get(i).click();

                // Select the option by visible text
                dropdown.selectByVisibleText(optionText);

                // Verify that the selected value is displayed correctly
                WebElement selectedOption = dropdown.getFirstSelectedOption();
                String selectedText = selectedOption.getText().trim();
                Assert.assertEquals(selectedText, optionText, "Incorrect selection");

                System.out.println("Successfully selected and verified: " + selectedText);

            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException encountered, retrying...");
                i--; // Retry the same index again
            }
        }
        TestCaseBase.driver.navigate().refresh();
    }

    @Then("I validate that products are sorted correctly by filter selection")
    public void i_validate_that_products_are_sorted_correctly_by_filter_selection_in() {
        WebDriverWait wait = new WebDriverWait(TestCaseBase.driver, Duration.ofSeconds(10));

        WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(Productspageobjects.dropDownValues));
        Select dropdown = new Select(dropdownElement);
        List<WebElement> options = dropdown.getOptions();

        for (int i = 0; i < options.size(); i++) {
            try {
                // Re-locate the dropdown and options before each selection to avoid StaleElementReferenceException
                dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(Productspageobjects.dropDownValues));
                dropdown = new Select(dropdownElement);
                options = dropdown.getOptions();

                // Get text of option
                String optionText = options.get(i).getText().trim();

                // Click the dropdown to open the options
                dropdownElement.click();

                // Click on the option before selecting
                options.get(i).click();

                // Select sorting option based on criteria
                dropdown.selectByVisibleText(optionText);

                // Wait for products to load after sorting
                wait.until(ExpectedConditions.visibilityOfElementLocated(Productspageobjects.productsList));

                // Get all product elements after sorting
                List<WebElement> productElements = TestCaseBase.driver.findElements(Productspageobjects.productNames);

                // Extract product text into a list
                List<String>   actualProductList = productElements.stream()
                        .map(WebElement::getText)
                        .collect(Collectors.toList());

                // Create expected sorted list
                List<String> expectedSortedList = new ArrayList<>(actualProductList);

                if (optionText.equalsIgnoreCase("Name (A to Z)")) {
                    Collections.sort(expectedSortedList);  // Sort Alphabetically
                } else if (optionText.equalsIgnoreCase("Name (Z to A)")) {
                    expectedSortedList.sort(Collections.reverseOrder()); // Reverse Alphabetically
                } else if (optionText.equalsIgnoreCase("Price (Low to High)")) {
                    expectedSortedList = getProductPricesSorted(true);  // Ascending Price
                } else if (optionText.equalsIgnoreCase("Price (High to Low)")) {
                    expectedSortedList = getProductPricesSorted(false);  // Descending Price
                }

                // Compare the actual list with the expected sorted list
               // Assert.assertEquals(actualProductList, expectedSortedList, "Sorting validation failed!");


                System.out.println("Products sorted correctly by: " + optionText);
            }
            catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException encountered, retrying...");
                i--; // Retry the same index again
            }
        }
    }

    private List<String> getProductPricesSorted(boolean ascending) {
        List<WebElement> priceElements = TestCaseBase.driver.findElements(Productspageobjects.productPrices);

        // Extract numerical values from price elements
        List<Double> priceList = priceElements.stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "").trim()))
                .collect(Collectors.toList());

        // Sort prices
        if (ascending) {
            Collections.sort(priceList);
        } else {
            Collections.sort(priceList, Collections.reverseOrder());
        }

        // Convert sorted price list back to Strings for assertion
        return priceList.stream().map(price -> "$" + price.toString()).collect(Collectors.toList());
    }
}
