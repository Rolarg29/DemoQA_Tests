package a1qa.task2_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseUtil {
    static WebDriver driver = WebDriverSingleton.driver;

    //finds an element by any locator given
    public static WebElement findElement(By locator) {
        return driver.findElement(locator);
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

    //initializes the browser into a website
    public static void visit(String url) {
        driver.get(url);
    }

    public static void waitForClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void scrollToEnd() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");    }


    public static void switchTab(){
        String firstTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(firstTab)) {
                driver.switchTo().window(tab);
            }
        }
    }

    public static String page(){
        return driver.getCurrentUrl();
    }

    public static boolean textMatchBool(String text, String patron){
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static String attribute(By locator, String text){
        return driver.findElement(locator).getAttribute(text);
    }


    public static String replaceAtt(By locator){
        String platformImg = attribute(locator, "class");
        switch (platformImg) {
            case "platform_img win" -> {
                return "Windows";
            }
            case "platform_img mac" -> {
                return "Mac";
            }
            case "platform_img linux" -> {
                return "Linux";
            }
            case "platform_img streamingvideoseries" -> {
                return "Streaming Video series";
            }
        }
        return platformImg;
    }
}
