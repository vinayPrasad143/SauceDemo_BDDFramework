package tests;

import RuthModules.*;
import modules.LoginModule;
import modules.ProductsModule;
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
    public static LoginModule loginModule;
    public static ProductsModule productsModule;
    public static RuthLoginModule ruthloginmodule;
    public static AskGiaModule askgiamodule;
    public static AutomateModule automatemodule;
    public static AugmentModule augmentmodule;
    public static WordCloudModule wordcloudmodule;
    public static CompareModule comparemodule;
    public static AdvancedAnalysisModule advancedanalysismodule;
    public static QualDeepDiveModule qualdeepdivemodule;

    @BeforeMethod(alwaysRun = true)
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        loginModule = new LoginModule(driver);
    }
    @BeforeMethod(alwaysRun = true)
    public static void setup(String url){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
//         Optional: run incognito to avoid cache/storage-related popups
        options.addArguments("--incognito");
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://gia-demo.graphenesvc.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        loginModule = new LoginModule(driver);
        productsModule = new ProductsModule(driver);
        ruthloginmodule = new RuthLoginModule(driver);
        askgiamodule = new AskGiaModule(driver);
        automatemodule = new AutomateModule(driver);
        augmentmodule = new AugmentModule(driver);
        wordcloudmodule = new WordCloudModule(driver);
        comparemodule = new CompareModule(driver);
        advancedanalysismodule = new AdvancedAnalysisModule(driver);
        qualdeepdivemodule = new QualDeepDiveModule(driver);

    }

    @AfterMethod(alwaysRun = true)
    public static void tearDown(){
        driver.close();
    }


}
