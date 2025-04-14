package RuthPageObjects;

import org.openqa.selenium.By;

public class GiaAskPageObjects {

    public static By AskGiaQueryTextBox = By.xpath("//input[@type=\"text\"]");
    public static By searchQuery =By.xpath("//button[@class=\"bg-brand-400 rounded-full w-7 h-7 flex justify-center items-center mt-1.5\"]");
    public static String queryNeedToAsk  = "What are the differences between respondent types?";
    public static By queryResponse =By.xpath("//*[@class=\"p-4 rounded-lg w-fit bg-brand-200\"]");
    public static By citationIcon = By.xpath("(//*[@class='fill-brand-gray-400 block group-hover:hidden'])[4]");
    public static By citationsDisplay = By.xpath("(//*[@id=\"root\"]/div/div/div/div[1]/div/div/div[2]/div/div[4]/div/div/div)[1]");
    public static By likeIcon = By.xpath("(//*[@class='fill-brand-gray-400 block group-hover:hidden'])[1]");
    public static By unlikeIcon = By.xpath("(//*[@class='fill-brand-gray-400 block group-hover:hidden'])[2]");
    public static By clickToCheckCitations = By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div/div/div[2]/div/div[4]/div/div/div[1]/p[1]");
    public static By previousButton = By.xpath("//*[@data-testid=\"SkipPreviousIcon\"]");
    public static By nextButton = By.xpath("//*[@data-testid=\"SkipNextIcon\"]");
}
