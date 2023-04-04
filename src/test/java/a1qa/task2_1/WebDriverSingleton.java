package a1qa.task2_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;


public class WebDriverSingleton {
    public static WebDriver driver = null;
    static String configFilePath = "src/test/java/a1qa/task2_1/json_files/config.json";
    public static JSONObject config;

    static {
        try {
            config = ConfigDataFromJSONFile.ConfigReader.readConfig(configFilePath);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
    static JSONArray chromeBrowser = (JSONArray) config.get("chromeBrowser");
    static JSONObject chromeOptions = (JSONObject) chromeBrowser.get(0);
    static JSONArray options = (JSONArray) chromeOptions.get("options");
    static String name = (String) chromeOptions.get("name");
    public static String browserName = name;

    public WebDriverSingleton() {
    }

    public static void initialize(){
        if(driver == null){
            switch (browserName) {
                case "Chrome" -> {

                    // Create a new ChromeOptions object with the specified options
                    ChromeOptions chromeOpts = new ChromeOptions();
                    for (Object option : options) {
                        chromeOpts.addArguments((String) option);
                    }
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOpts);
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


