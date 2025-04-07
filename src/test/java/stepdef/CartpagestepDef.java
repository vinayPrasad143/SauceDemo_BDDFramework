package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.TestCaseBase;

public class CartpagestepDef {

    @Given("Open the chrome browser and navigate to the {string}")
    public void open_the_chrome_browser_and_navigate_to_the(String string) {
        TestCaseBase.setup(string);
    }
    @Given("enter the {string} in the username text field")
    public void enter_the_in_the_username_text_field(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("enter the {string} in the password text field")
    public void enter_the_in_the_password_text_field(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("click on the login button")
    public void click_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("Add Items to the cart")
    public void add_items_to_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("click on the Cart icon\\/button")
    public void click_on_the_cart_icon_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("verify the add items in the cart")
    public void verify_the_add_items_in_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
