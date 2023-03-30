package a1qa.task2_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverSingleton {
    public static WebDriver driver = null;
    public static String browserName = "chrome";

    public static void initialize(){
        if(driver == null){
            switch (browserName) {
                case "chrome" -> {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("--lang=en");
                    options.addArguments("--incognito");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
            }
        }
        assert driver != null;
        driver.manage().window().maximize();
    }
    public static void quit(){
        driver.quit();
        driver = null;
    }
}


