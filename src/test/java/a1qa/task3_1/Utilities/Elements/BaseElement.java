package a1qa.task3_1.Utilities.Elements;

import a1qa.task3_1.Factory.WebDriverFactory;
import org.openqa.selenium.*;
import java.util.List;
import java.util.Random;

public class BaseElement {
    public static WebDriver driver = WebDriverFactory.initialize();

    public BaseElement(WebDriver driver) {
        BaseElement.driver = WebDriverFactory.initialize();
    }
    static JavascriptExecutor js = (JavascriptExecutor) driver;

    //finds an element by any locator given
    public static WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
    public static List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    //Get the text of the element using a locator
    public static String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public static String getText(WebElement element) {
        return element.getText();
    }
    //type text in element or input
    public static void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }
    public static void clear(By locator) {
        driver.findElement(locator).clear();
    }

    //clicks on element
    public static void click(By locator) {
        driver.findElement(locator).click();

    }
    public static void click(WebElement element) {
        element.click();
    }

    public static boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public static boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
    public static boolean isEnabled(By locator) {
        return driver.findElement(locator).isEnabled();
    }

    public static void scrollToEnd() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollTo(By locator) {
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void scrollTo(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String alertRandomText() {
        Alert alert = driver.switchTo().alert();

        Random random = new Random();
        StringBuilder builder = new StringBuilder();

        int length = 10; // set the length of the string
        String characters = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            builder.append(characters.charAt(index));
        }
        String randomString = builder.toString();
        alert.sendKeys(randomString);
        return randomString;
    }
}

