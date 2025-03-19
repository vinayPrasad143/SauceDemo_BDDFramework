package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.TestCaseBase;

public class Productspagestepdef {

    @When("click on the item {string}")
    public void click_on_the_item() {
        TestCaseBase.productsModule.addProduct1();

    }
    @Then("Verify the added Items")
    public void verify_the_added_items() {

    }
    @Then("Verify the increase in count to {int} for the Items Added")
    public void verify_the_increase_in_count_to_for_the_items_added(Integer int1) {

    }

    @When("click on the second item {string}")
    public void click_on_the_second_item(String string) {
        TestCaseBase.productsModule.addProduct2();
    }
    @When("click on Remove button on the Item {string}")
    public void click_on_remove_button_on_the_item(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Verify that the Items added to the cart are removed")
    public void verify_that_the_items_added_to_the_cart_are_removed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Verify the decrease in count to {int} for the Items removed")
    public void verify_the_decrease_in_count_to_for_the_items_removed(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("click on dropdown filter")
    public void click_on_dropdown_filter() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Verify the display of the {string}")
    public void verify_the_display_of_the(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
