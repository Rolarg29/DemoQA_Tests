package a1qa.task3_1.Factory;

import a1qa.task3_1.Factory.Manager.ChromeDriverManager;
import a1qa.task3_1.Factory.Manager.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverFactory {
    public static WebDriver driver;

    private WebDriverFactory() {
        throw new UnsupportedOperationException("Cannot instantiate utility class");
    }

    public static synchronized WebDriver initialize() {
        String browser = "firefox";
        if (driver == null) {
            switch (browser) {
                case "chrome":
                    ChromeDriverManager chromeDriverManager = new ChromeDriverManager();
                    driver =  chromeDriverManager.createDriver();
                    break;
                case "firefox":
                    FirefoxDriverManager firefoxDriverManager = new FirefoxDriverManager();
                    driver = firefoxDriverManager.createDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser: " + browser);
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static synchronized void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
