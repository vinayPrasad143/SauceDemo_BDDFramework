package RuthPageObjects;

import org.openqa.selenium.By;

public class AugmentPageObjects {

    public static By AugmentTab = By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/nav/div/ul[1]/li[6]/a[1]/div");
    public static By HeaderText = By.xpath("//*[contains(text(),'Share of Positive Reviews')]");
    public static String expectedHeaderText = "Share of Positive Reviews";
    public static By countryFilter = By.xpath("(//div[@role='combobox'])[1]");
    public static By selectedCountryFilter = By.xpath("(//div[@role='combobox']//span)[1]");
    public static By categoryFilter = By.xpath("(//div[@role='combobox'])[2]");
    public static By selectedCategoryFilter = By.xpath("(//div[@role='combobox']//span)[2]");
    public static By timePeriodFilter = By.xpath("(//div[@role='combobox'])[3]");
    public static By selectedTimePeriodFilter = By.xpath("(//div[@role='combobox']//span)[3]");
    public static By brandSelection = By.xpath("(//div[contains(@class,'p-2 flex justify-between items-center cursor-pointer rounded-md')])");
    public static By themeSelection = By.xpath("//*[@class=\"h-[50px]\"]");
    public static By reviewValidate = By.xpath("//div[contains(@class,'line-clamp-2') and contains(@class,'text-sm') and @aria-label]");
    public static By reviewCount = By.xpath("//div[contains(@class,'font-semibold') and contains(text(),'REVIEWS')]");
    public static By paginationNextButton = By.xpath("//button[@aria-label='Go to next page' and not(@disabled)]");
    public static By reviewsData = By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div/div/div[2]/div[2]/div[2]");
    public static By noDataMessage = By.xpath("//*[@id=\"chat-container\"]/div[3]/p");

}
