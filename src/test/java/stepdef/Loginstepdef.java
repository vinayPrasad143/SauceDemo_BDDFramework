package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tests.TestCaseBase;

public class Loginstepdef {

    @Given("Open the chrome browser and Navigate to {string}")
    public void open_the_chrome_browser_and_navigate_to(String string) {
        TestCaseBase.setup(string);
    }
    @When("click on the Login button")
    public void click_on_the_login_button() {
        TestCaseBase.loginModule.clickLoginButton();
    }
    @Then("Verify the navigation of the home page")
    public void verify_the_navigation_of_the_home_page() {

    }
    @When("Enter {string} in the username field")
    public void enter_in_the_username_field(String string) {
        TestCaseBase.loginModule.enterUserName(string);
    }
    @When("Enter {string} in the password field")
    public void enter_in_the_password_field(String string) {
        TestCaseBase.loginModule.enterPassword(string);
    }
    @Then("Verify the display of the validation message {string}")
    public void verify_the_display_of_the_validation_message(String string) {
        String fromUI = TestCaseBase.loginModule.getErrorMsg();
        Assert.assertEquals(string, fromUI);
    }

}
