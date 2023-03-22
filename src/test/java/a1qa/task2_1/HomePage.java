package a1qa.task2_1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static a1qa.task2_1.BaseUtil.click;


public class HomePage {
    private static final WebDriver driver = WebDriverSingleton.driver;

    // Examples
    public static final String mainUrl = "https://store.steampowered.com/";
    public static final String mainTitle = "Welcome to Steam";
    public static final String policyTitle = "Privacy Policy Agreement";
    public static final By privacyPolicyLink = By.xpath("//a[contains(text(),'Privacy Policy')]");
    public static final By privacyPolicyClick = By.linkText("Privacy Policy");
    public static final By privacyTitle = By.xpath("//div[contains(text(),'Privacy Policy Agreement')]");

    public static final By languageDropdown = By.id("languages");
    public static boolean allLanguagesDisplayed = false;
    public static final By spanish = By.cssSelector("a[href*='spanish'] img");
    public static final By portuguese = By.cssSelector("a[href*='portuguese'] img");
    public static final By english = By.cssSelector("a[href*='english'] img");
    public static final By french = By.cssSelector("a[href*='french'] img");
    public static final By german = By.cssSelector("a[href*='german'] img");
    public static final By italian = By.cssSelector("a[href*='italian'] img");
    public static final By russian= By.cssSelector("a[href*='russian'] img");
    public static final By japanese = By.cssSelector("a[href*='japanese'] img");
    public static final By brazilian = By.cssSelector("a[href*='brazilian'] img");
    public static final By[] languages = {spanish,french,german,italian,russian,japanese,portuguese,brazilian,english};


    public void clickLanguageDropdown() {
        driver.findElement(languageDropdown).click();
    }


    public static void selectLang(By[] languages){
        for (By language : languages){
//            click(language);
            WebElement element =  driver.findElement(language);
            allLanguagesDisplayed = element.isDisplayed();
        }
    }


    public String getPageTitle() {
        return driver.getTitle();
    }
}
