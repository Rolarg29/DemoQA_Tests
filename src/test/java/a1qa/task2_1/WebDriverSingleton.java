package a1qa.task2_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class WebDriverSingleton {
    public static WebDriver driver = null;
    public static String browserName = "chrome";

    public static void initialize(){
        if(driver == null){
            if(browserName.equalsIgnoreCase("chrome")){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--lang=en");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);

            }
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    public static void quit(){
        driver.quit();
        driver = null;
    }
    public static void close(){
        driver.close();
        driver = null;
    }
}


