package a1qa.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.sql.DriverManager.getDriver;

public class Base {
    private WebDriver driver;
    public Base(WebDriver driver) {
        this.driver = driver;
    }

    //webdriver setup
    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    //finds an element by any locator given
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    //returns a list of all elements with the given locator
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    //Get the text of the element
    public String getText(WebElement element) {
        return element.getText();
    }

    //Get the text of the element using a locator
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    //type text in element or input
    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    //clicks on element
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    //checks if element is displayed
    public boolean isDisplayed(By locator) {
        try{
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    //initializes the browser into a website
    public void visit(String url) {
        driver.get(url);
    }

    //wait for an element to be displayed
    public void waitForElement(By locator) {//creado por mi
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Scrolls down to find element
    public void scrollTo(By locator) {//creado por mi
        WebElement element = driver.findElement(locator);
        new Actions(driver)
                .scrollToElement(element)
                .perform();
    }
}
