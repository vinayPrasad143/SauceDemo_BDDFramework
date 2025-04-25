package RuthPageObjects;

import org.openqa.selenium.By;

public class ComparePageObjects {

    public static By compareTab = By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/nav/div/ul[1]/li[3]/a[1]/div");
    public static By HeaderText = By.xpath("//p[contains(text(),'TOPICS OF INTEREST')]");
    public static String expectedHeaderText = "https://gia-demo.graphenesvc.com/projects/1/comparison";
    public static By countryFilter = By.xpath("(//div[@role='combobox'])[2]");
    public static By selectedCountryFilter = By.xpath("(//div[@role='combobox']//span)[2]");
    public static By categoryFilter = By.xpath("(//div[@role='combobox'])[1]");
    public static By selectedCategoryFilter = By.xpath("(//div[@role='combobox']//span)[1]");
    public static By timePeriodFilter = By.xpath("(//div[@role='combobox'])[3]");
    public static By selectedTimePeriodFilter = By.xpath("(//div[@role='combobox']//span)[3]");
    public static By respondentTypeFilter = By.xpath("(//div[@role='combobox'])[4]");
    public static By selectedRespondentTypeFilter = By.xpath("(//div[@role='combobox']//span)[4]");
    public static By topicsOfInterests = By.xpath("//div[contains(@class, 'justify-between') and contains(@class, 'hover:cursor-pointer')]");
    public static By TOIName = By.xpath(".//span");
    public static By brandFilter = By.xpath("(//div[@role='combobox'])[5]");
    public static By selectedBrandFilter = By.xpath("(//div[@role='combobox']//span)[5]");
    public static By noDataMessage = By.xpath("//*[@id=\"chat-container\"]/div[3]/p");
    public static By dataLoad = By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div/div/div[2]/div[3]");
    public static By country2Filter = By.xpath("(//div[@role='combobox'])[6]");
    public static By selectedCountry2Filter = By.xpath("(//div[@role='combobox']//span)[6]");
    public static By timePeriod2Filter = By.xpath("(//div[@role='combobox'])[7]");
    public static By selectedTimePeriod2Filter = By.xpath("(//div[@role='combobox']//span)[7]");
    public static By respondentType2Filter = By.xpath("(//div[@role='combobox'])[8]");
    public static By selectedRespondentType2Filter = By.xpath("(//div[@role='combobox']//span)[8]");
    public static By brand2Filter = By.xpath("(//div[@role='combobox'])[9]");
    public static By selectedBrand2Filter = By.xpath("(//div[@role='combobox']//span)[9]");

}
