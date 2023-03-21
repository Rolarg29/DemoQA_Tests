package a1qa.task2_1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver = WebDriverSingleton.driver;

    // Examples
    public static final String MainUrl = "https://store.steampowered.com/";
    private static final By privacyPolicyLink = By.cssSelector("a[href='/privacy/']");
    private final By languageDropdown = By.id("language_pulldown");
    private final By languageOptionSpanish = By.cssSelector("a[href='/?l=spanish']");
    private final By languageOptionPortuguese = By.cssSelector("a[href='/?l=portuguese']");

    public void scrollToPrivacyPolicy() {
        WebElement element = driver.findElement(privacyPolicyLink);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

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
