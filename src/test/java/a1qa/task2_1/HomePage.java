package a1qa.task2_1;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    private static final WebDriver driver = WebDriverSingleton.driver;

    // Examples
    public static final String MainUrl = "https://store.steampowered.com/";
    public static final By privacyPolicyLink = By.xpath("//a[contains(text(),'Privacy Policy')]");
    private final By languageDropdown = By.id("language_pulldown");
    private final By languageOptionSpanish = By.cssSelector("a[href='/?l=spanish']");
    private final By languageOptionPortuguese = By.cssSelector("a[href='/?l=portuguese']");

    public void clickPrivacyPolicy() {
        driver.findElement(privacyPolicyLink).click();
    }

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
