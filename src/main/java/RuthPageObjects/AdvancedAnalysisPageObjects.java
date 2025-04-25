package RuthPageObjects;

import org.openqa.selenium.By;

public class AdvancedAnalysisPageObjects {

                public static By advancedAnalysisTab = By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/nav/div/ul[1]/li[2]/a[1]/div");
                public static By collapseExpandButton = By.xpath("//*[@class=\"MuiButtonBase-root MuiAccordionSummary-root Mui-expanded MuiAccordionSummary-gutters css-3pzm2w\"]");
                public static String expectedHeaderText = "https://gia-demo.graphenesvc.com/projects/1/advanced-analysis";
                public static By HeaderText = By.xpath("//p[contains(text(),'TOPICS OF INTEREST')]");
                public static By countryFilter = By.xpath("(//div[@role='combobox'])[1]");
                public static By selectedCountryFilter = By.xpath("(//div[@role='combobox']//span)[1]");
                public static By categoryFilter = By.xpath("(//div[@role='combobox'])[2]");
                public static By selectedCategoryFilter = By.xpath("(//div[@role='combobox']//span)[2]");
                public static By timePeriodFilter = By.xpath("(//div[@role='combobox'])[3]");
                public static By selectedTimePeriodFilter = By.xpath("(//div[@role='combobox']//span)[3]");
                public static By respondentTypeFilter = By.xpath("(//div[@role='combobox'])[4]");
                public static By selectedRespondentTypeFilter = By.xpath("(//div[@role='combobox']//span)[4]");
                public static By applyFilterButton = By.xpath("//div[@aria-label='Apply filters to generate insights']//button[contains(@class,'MuiButton-contained')]");
                public static By topicsSelection = By.xpath("//div[contains(@class, 'flex') and contains(@class, 'cursor-pointer') and contains(@class, 'break-all')]");
                //div[@role='region']//div[contains(@class, 'cursor-pointer') and contains(@class, 'break-all')]--for Topics selection
                public static By defaultScreenMessage = By.xpath("//p[contains(text(), 'Get detailed insights')]");
                public static String expectedDefaultMessage = "Get detailed insights on trending topics";
                public static By parameterDisplayed = By.xpath("/*[@id=\"chat-container\"]/div/div/div/div[1]");
                public static By TOIName = By.xpath(".//span");
                public static By dataLoad = By.xpath("//div[contains(@class, 'p-4') and contains(@class, 'rounded-lg') and contains(@class, 'bg-brand-200')]");
                public static By dataDisplayed = By.xpath(".//p");
                public static By likeDisLikeCopyClicks = By.xpath("//button[@aria-label='Helpful' or @aria-label='Not helpful' or @aria-label='Copy text']");
                public static By VerifyResponseGenerated = By.xpath("//div[contains(@class,'wmde-markdown')]");
                public static String expectedCombination1 = "Country: Canada ; Category: Facial Cleanser ; Time period: 2023H2 ; Respondent type: Women";
                public static By helpfulIcon = By.xpath("//button[@aria-label='Helpful']");
                public static By helpfulIconHighlighted = By.xpath("//button[@aria-label='Helpful']//svg");
                public static By notHelpfulIcon = By.xpath("//button[@aria-label='Not helpful']");
                public static By notHelpfulIconHighlighted = By.xpath("(//*[@id=\"Filled\"])[2]");

}
