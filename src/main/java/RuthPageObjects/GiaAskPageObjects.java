package RuthPageObjects;

import org.openqa.selenium.By;

public class GiaAskPageObjects {

    public static By AskGiaQueryTextBox = By.xpath("//input[@type=\"text\"]");
    public static By searchQuery =By.xpath("//button[@class=\"bg-brand-400 rounded-full w-7 h-7 flex justify-center items-center mt-1.5\"]");
    public static String queryNeedToAsk  = "What are the differences between respondent types?";
    public static By queryResponse =By.xpath("//*[@class=\"p-4 rounded-lg w-fit bg-brand-200\"]");
    public static By citationIcon = By.xpath("//button[@aria-label='View sources']");
    public static By citationsDisplay = By.xpath("(//*[@id=\"root\"]/div/div/div/div[1]/div/div/div[2]/div/div[4]/div/div/div)[1]");
    public static By likeIcon = By.xpath("(//*[@class='fill-brand-gray-400 block group-hover:hidden'])[1]");
    public static By unlikeIcon = By.xpath("(//*[@class='fill-brand-gray-400 block group-hover:hidden'])[2]");
    public static By clickToCheckCitations = By.xpath("//div[contains(@class, 'p-3') and contains(@class, 'rounded-md') and contains(@class, 'cursor-pointer')]");
    public static By citationsText = By.xpath(".//p[contains(@class, 'text-sm')]");
    public static By previousButton = By.xpath("//*[@data-testid=\"SkipPreviousIcon\"]");
    public static By nextButton = By.xpath("//*[@data-testid=\"SkipNextIcon\"]");
    public static By helpfulIcon = By.xpath("//button[@aria-label='Helpful']");
    public static By helpfulIconHighlighted = By.xpath("(//*[@id=\"Filled\"])[1]");
    public static By notHelpfulIcon = By.xpath("//button[@aria-label='Not helpful']");
    public static By notHelpfulIconHighlighted = By.xpath("(//*[@id=\"Filled\"])[2]");
    public static By closeIconOnCitations = By.xpath("//*[@data-testid=\"CloseIcon\"]");
    public static By highlightedTextInCitations = By.xpath("//div[@id='detailed-popup']//p[contains(@class,'bg-yellow-400')]");
    public static String expectedHeaderText = "https://gia-demo.graphenesvc.com/projects/1/ask-gia";
}
