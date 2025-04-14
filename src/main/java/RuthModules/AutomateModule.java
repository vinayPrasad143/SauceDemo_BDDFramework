package RuthModules;

import RuthPageObjects.AutomatePageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class AutomateModule {

    WebDriver driver;
    WebDriverWait wait;

    public AutomateModule(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void clickOnAutomateTab()
    {
        driver.findElement(AutomatePageObjects.AutomateTab).click();
    }

    public void validateHeaderText(){
        driver.findElement(AutomatePageObjects.transcriptsHeaderText).isDisplayed();
    }


}
