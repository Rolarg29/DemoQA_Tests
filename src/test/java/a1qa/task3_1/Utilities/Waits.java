package a1qa.task3_1.Utilities;

import a1qa.task3_1.Factory.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Waits {
    static WebDriver driver = WebDriverFactory.initialize();

    private static final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((10)));

    public static void waitForClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForPresence(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public static void waitForPresence(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean waitForInvisible(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public static boolean waitForInvisibleLocator(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForFrame(By locator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    public static void waitForNewTabOpens(int num) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(num));    }
}

