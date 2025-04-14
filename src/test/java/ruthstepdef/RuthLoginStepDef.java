package ruthstepdef;

import RuthModules.RuthLoginModule;
import RuthPageObjects.LoginPageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;
import tests.TestCaseBase;

import java.time.Duration;

public class RuthLoginStepDef {
    WebDriver driver;

    @Given("Open the chrome browser and Navigate to {string}")
    public void open_the_chrome_browser_and_navigate_to(String string) {
        TestCaseBase.setup(string);
    }
    @When("Enter {string} in the username field")
    public void enter_in_the_username_field(String string) {

        TestCaseBase.ruthloginmodule.enterUserName(string);
    }
    @When("click on the Next button")
    public void click_on_the_next_button() {
        driver = TestCaseBase.driver;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            wait.until(ExpectedConditions.elementToBeClickable(LoginPageObjects.next_signInBut));
            TestCaseBase.ruthloginmodule.clickOnNextButton();
        } catch (Exception e) {
            System.out.println("Next button was not clickable: " + e.getMessage());
            Assert.fail("Test failed due to element not being clickable");
        }
    }
    @When("Enter {string} in the password field")
    public void enter_in_the_password_field(String string) throws InterruptedException {
        TestCaseBase.ruthloginmodule.enterPassword(string);
        Thread.sleep(2000);
    }
    @When("click on the SignIn button")
    public void click_on_the_sign_in_button() throws InterruptedException {
        driver = TestCaseBase.driver;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            wait.until(ExpectedConditions.elementToBeClickable(LoginPageObjects.signInBut));
            TestCaseBase.ruthloginmodule.clickOnSignInButton();
//            Alert a = driver.switchTo().alert();
//            a.accept();
        } catch (Exception e) {
            System.out.println("SignIn button was not clickable: " + e.getMessage());
            Assert.fail("Test failed due to element not being clickable");
        }
        Thread.sleep(15000);

    }
    @When("Click on stay signedIn no button")
    public void click_on_stay_signed_in_no_button() throws InterruptedException {
        driver = TestCaseBase.driver;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            wait.until(ExpectedConditions.elementToBeClickable(LoginPageObjects.staySignedInNoBut));
            TestCaseBase.ruthloginmodule.clickOnStaySignInButton();
        } catch (Exception e) {
            System.out.println("SignIn button was not clickable: " + e.getMessage());
            Assert.fail("Test failed due to element not being clickable");
        }
        Thread.sleep(30000);
    }
    @Then("Verify the navigation of the ASKGIA page")
    public void verify_the_navigation_of_the_ASKGIA_page() throws InterruptedException {
        driver = TestCaseBase.driver;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
            wait.until(ExpectedConditions.presenceOfElementLocated(LoginPageObjects.verifyHomePage));
            TestCaseBase.ruthloginmodule.verifyHomepage();
        } catch (Exception e) {
            System.out.println("verified and navigated to home page: " + e.getMessage());
            Assert.fail("Test failed due to element not being visible");
        }
        String fromUI = TestCaseBase.ruthloginmodule.getHeaderText();
        System.out.println("Text from UI "+ fromUI);
        Assert.assertEquals("Navigated to Home page", LoginPageObjects.expectedHeaderText, fromUI);
        Thread.sleep(10000);
    }

    @When("click on the GrapheneLogo")
    public void click_on_the_graphene_logo() {
        driver = TestCaseBase.driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(LoginPageObjects.grapheneLogin));
        TestCaseBase.ruthloginmodule.clickOnGrapheneLogo();
    }

}
