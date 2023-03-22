package a1qa.task2_1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    public static final boolean allLanguagesDisplayed = true;
    public static final By languageOptionSpanish = By.cssSelector("a[href*='spanish'] img");
    public static final By languageOptionPortuguese = By.cssSelector("a[href*='example'] img");

    public void clickLanguageDropdown() {
        driver.findElement(languageDropdown).click();
    }

    public void clickLanguageOptionSpanish() {
        driver.findElement(languageOptionSpanish).click();
    }

    public void clickLanguageOptionPortuguese() {
        driver.findElement(languageOptionPortuguese).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
