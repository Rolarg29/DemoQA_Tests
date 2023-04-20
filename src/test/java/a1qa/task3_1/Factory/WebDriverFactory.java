package a1qa.task3_1.Factory;

import a1qa.task3_1.Factory.Manager.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverFactory {
    public static WebDriver driver;

    private WebDriverFactory() {
        throw new UnsupportedOperationException("Cannot instantiate utility class");
    }

    public static synchronized WebDriver initialize() {
        String browser = "chrome";
        if (driver == null) {
            switch (browser) {
                case "chrome":
                    ChromeDriverManager chromeDriverManager = new ChromeDriverManager();
                    driver =  chromeDriverManager.createDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser: " + browser);
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
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
