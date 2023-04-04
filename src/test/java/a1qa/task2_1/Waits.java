package a1qa.task2_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    static WebDriver driver = WebDriverSingleton.driver;

    public static void waitForClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((long) WebDriverSingleton.config.get("explicit_wait_time")));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
