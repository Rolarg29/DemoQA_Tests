package a1qa.task3_1.Utilities;

import a1qa.task3_1.Factory.WebDriverFactory;
import a1qa.task3_1.Factory.WebDriverSingleton;
import a1qa.task3_1.PageObjects.MainPage;
import a1qa.task3_1.Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseElement {
    static WebDriver driver = WebDriverFactory.initialize();

    public BaseElement(WebDriver driver) {
        BaseElement.driver = WebDriverFactory.initialize();
    }

    BaseElement baseElement = new BaseElement(driver);


    //finds an element by any locator given
    public static WebElement findElement(By locator) {
        return driver.findElement(locator);
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

    //clicks on element
    public static void click(By locator) {
        driver.findElement(locator).click();

    }
    public static void click(WebElement element) {
        element.click();

    }

    //initializes the browser into a website
    public static void visit(String url) {
        driver.get(url);
    }

    public static void scrollToEnd() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollTo(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollTo(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void switchTab() {
        String firstTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(firstTab)) {
                driver.switchTo().window(tab);
            }
        }
    }
}

