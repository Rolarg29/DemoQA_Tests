package a1qa.task2_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseUtil {
    static WebDriver driver = WebDriverSingleton.driver;

    //finds an element by any locator given
    public static WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    //returns a list of all elements with the given locator
    public static List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    //Get the text of the element
    public static String getText(WebElement element) {
        return element.getText();
    }

    //Get the text of the element using a locator
    public static String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    //type text in element or input
    public static void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    //clicks on element
    public static void click(By locator) {
        driver.findElement(locator).click();
    }

    //checks if element is displayed
    public static boolean isDisplayed(By locator) {
        try{
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    //initializes the browser into a website
    public static void visit(String url) {
        driver.get(url);
    }

    //wait for an element to be displayed
    public static void waitForElement(By locator) {//creado por mi
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Scrolls down to find element
    public static void scrollTo(By locator) {//creado por mi
        WebElement element = driver.findElement(locator);
        new Actions(driver)
                .scrollToElement(element)
                .perform();
    }
}
