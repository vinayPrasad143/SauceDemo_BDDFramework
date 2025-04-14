package RuthModules;

import RuthPageObjects.GiaAskPageObjects;
import RuthPageObjects.LoginPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AskGiaModule {

    WebDriver driver;
    WebDriverWait wait;
    public AskGiaModule(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void enterQueryIntheQueryField(String string){
        driver.findElement(GiaAskPageObjects.AskGiaQueryTextBox).sendKeys(string);
    }
    public void clickOnSearchQueryButton(){
        driver.findElement(GiaAskPageObjects.searchQuery).click();
    }
    public void VerifyTheDisplayOfTheResponse()
    {
        driver.findElement(GiaAskPageObjects.queryResponse).isDisplayed();
    }
    public void clickOnCitationsIcon()
    {
        driver.findElement(GiaAskPageObjects.citationIcon).click();
    }

    public void verifyTheDisplayOfTheCitations(){

            driver.findElements(GiaAskPageObjects.citationsDisplay);
    }
    public void ClickOnCitations(){

        driver.findElement(GiaAskPageObjects.clickToCheckCitations);
    }


    public void clickOnLikeButton()
    {
        WebElement LikeButton = driver.findElement(GiaAskPageObjects.likeIcon);
        LikeButton.click();

    }
    public void clickOnUnLikeButton()
    {
        driver.findElement(GiaAskPageObjects.unlikeIcon).click();
    }

    public void clickOnPreviousButton()
    {
        driver.findElement(GiaAskPageObjects.previousButton).click();
    }

    public void clickOnNextButton()
    {
        driver.findElement(GiaAskPageObjects.nextButton).click();
    }

}
