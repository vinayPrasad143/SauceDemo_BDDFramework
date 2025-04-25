package RuthPageObjects;

import org.openqa.selenium.By;

public class QualDeepDivePageObjects {

    public static By qualDeepDiveTab = By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/nav/div/ul[1]/li[5]/a[1]/div");
    public static By HeaderText = By.xpath("//p[contains(text(),'TOPICS OF INTEREST')]");
    public static String expectedHeaderText = "https://gia-demo.graphenesvc.com/projects/1/deepdive";
    public static By countryFilter = By.xpath("(//div[@role='combobox'])[1]");
    public static By selectedCountryFilter = By.xpath("(//div[@role='combobox']//span)[1]");
    public static By categoryFilter = By.xpath("(//div[@role='combobox'])[2]");
    public static By selectedCategoryFilter = By.xpath("(//div[@role='combobox']//span)[2]");
    public static By timePeriodFilter = By.xpath("(//div[@role='combobox'])[3]");
    public static By selectedTimePeriodFilter = By.xpath("(//div[@role='combobox']//span)[3]");
    public static By respondentTypeFilter = By.xpath("(//div[@role='combobox'])[4]");
    public static By selectedRespondentTypeFilter = By.xpath("(//div[@role='combobox']//span)[4]");
    public static By brandFilter = By.xpath("(//div[@role='combobox'])[5]");
    public static By selectedBrandFilter = By.xpath("(//div[@role='combobox']//span)[5]");
    public static By dataLoad = By.xpath("//div[contains(@class, 'bg-white') and contains(@class, 'border-b-') and contains(@class, 'flex')][.//p[@class='ml-2']]");
    public static By paginationNextButton = By.xpath("//button[@aria-label='Go to next page' and not(@disabled)]");
    public static By subTopics = By.xpath("//div[contains(@class, 'items-center') and contains(@class, 'rounded-md') and contains(@class, 'break-all mb-1.5')]");
    public static By topicsOfInterests = By.xpath("//div[@class='col-span-1 pt-4']//div[contains(@class, 'flex items-center')]");
    public static By noDataMessage = By.xpath("//span[contains(@class, 'text-gray-400') and contains(text(), 'No data available')]");
    public static By reviewsDataLoad = By.xpath("//div[contains(@class, 'bg-white') and contains(@class, 'border-b-') and contains(@class, 'flex')][.//p[@class='ml-2']][1]");
    public static By toiValues = By.xpath(".//span[contains(@class, 'text-xs')]");
    public static By toiNames = By.xpath(".//div[contains(@class, 'truncate')]//span");
    public static By positiveSentiment = By.xpath("//span[contains(@class, 'bg-brand-red-default'");
    public static By negativeSentiment = By.xpath("//span[contains(@class, 'bg-brand-green-default')]");
    public static By neutralSentiment = By.xpath("//span[contains(@class, 'bg-purple')]");

}
