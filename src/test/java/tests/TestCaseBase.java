package tests;

import RuthModules.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestCaseBase {

    public static WebDriver driver;
    public static RuthLoginModule ruthloginmodule;
    public static AskGiaModule askgiamodule;
    public static AutomateModule automatemodule;
    public static AugmentModule augmentmodule;
    public static WordCloudModule wordcloudmodule;
    public static CompareModule comparemodule;
    public static AdvancedAnalysisModule advancedanalysismodule;
    public static QualDeepDiveModule qualdeepdivemodule;

    @BeforeMethod(alwaysRun = true)
    public static void setup(String url) {
        ChromeOptions options = getChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://gia-demo.graphenesvc.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        ruthloginmodule = new RuthLoginModule(driver);
        askgiamodule = new AskGiaModule(driver);
        automatemodule = new AutomateModule(driver);
        augmentmodule = new AugmentModule(driver);
        wordcloudmodule = new WordCloudModule(driver);
        comparemodule = new CompareModule(driver);
        advancedanalysismodule = new AdvancedAnalysisModule(driver);
        qualdeepdivemodule = new QualDeepDiveModule(driver);
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new"); // or "--headless" for older Chrome
        options.addArguments("--window-size=1920,1080"); // Optional: useful for layout
        options.addArguments("disable-infobars");  //Hides the message "Chrome is being controlled by automated test software" that appears below the address bar.
        options.addArguments("--disable-notifications"); // Disables pop-up browser notifications like "This site wants to show notifications."
        options.addArguments("--disable-save-password-bubble"); //Stops the prompt that asks users to save passwords when logging in.
        options.addArguments("--incognito"); //Optional: run incognito to avoid cache/storage-related popups
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false); //Disables the Credential Service, which may try to autofill or suggest credentials.
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    @AfterMethod(alwaysRun = true)
    public static void tearDown() {
        driver.close();
    }


}
