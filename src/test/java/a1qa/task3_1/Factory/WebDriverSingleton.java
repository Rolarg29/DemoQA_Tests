package a1qa.task3_1.Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import static a1qa.task3_1.Config.ConfigManager.configuration;

public class WebDriverSingleton {
    public static WebDriver driver;

    private WebDriverSingleton() {
        // private constructor --> prevent external instantiation
    }

    public static void initialize() {
        String browser = "chrome";
        if (driver == null) {
            switch (browser) {
                case "chrome" -> {
//                     Create a new ChromeOptions object with the specified options
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);

                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                default -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new FirefoxDriver();
                }
            }

        }
        driver.manage().window().maximize();
    }
    public static void quit(){
        driver.quit();
        driver = null;
    }
}

