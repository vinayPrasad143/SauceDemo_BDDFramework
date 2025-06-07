package ruthstepdef;

import RuthModules.RuthLoginModule;
import RuthPageObjects.LoginPageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
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
        System.out.println("User navigates to Ruth Login page");
    }
    @When("Enter {string} in the username field")
    public void enter_in_the_username_field(String username) {

        TestCaseBase.ruthloginmodule.enterUserName(username);
        System.out.println("user enters the username");
    }
    @When("click on the Next button")
    public void click_on_the_next_button() {
        driver = TestCaseBase.driver;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            wait.until(ExpectedConditions.elementToBeClickable(LoginPageObjects.next_signInBut));
            TestCaseBase.ruthloginmodule.clickOnNextButton();
            System.out.println("user clicks on Next Button");
        } catch (Exception e) {
            System.out.println("Next button was not clickable: " + e.getMessage());
            Assert.fail("Test failed due to element not being clickable");
        }
    }
    @When("Enter {string} in the password field")
    public void enter_in_the_password_field(String password) throws InterruptedException {
        TestCaseBase.ruthloginmodule.enterPassword(password);
        Thread.sleep(2000);
        System.out.println("user enters the Password");
    }
    @When("click on the SignIn button")
    public void click_on_the_sign_in_button() throws InterruptedException {
        driver = TestCaseBase.driver;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            wait.until(ExpectedConditions.elementToBeClickable(LoginPageObjects.signInBut));
            TestCaseBase.ruthloginmodule.clickOnSignInButton();
            System.out.println("user clicks on SignIn Button");
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
            System.out.println("user clicked on No button from stay signedIn page");
        } catch (Exception e) {
            System.out.println("SignIn button was not clickable: " + e.getMessage());
            Assert.fail("Test failed due to element not being clickable");
        }
        Thread.sleep(30000);
    }
    @Then("Verify the navigation of the ASKGIA page by comparing with the Home page URL")
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
        Assert.assertEquals(fromUI, LoginPageObjects.expectedHeaderText,"Navigated to Home page");
        Thread.sleep(10000);
        System.out.println("ActualText from UI: "+ fromUI + " ExpectedText " + LoginPageObjects.expectedHeaderText + " Both the texts are matching");
        System.out.println("Navigated to AskGia page");
    }

    @When("click on the GrapheneLogo")
    public void click_on_the_graphene_logo() {
        driver = TestCaseBase.driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(LoginPageObjects.grapheneLogin));
        TestCaseBase.ruthloginmodule.clickOnGrapheneLogo();
        System.out.println("Clicks on Graphene Logo");
    }

}
