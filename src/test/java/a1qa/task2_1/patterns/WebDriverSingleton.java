package a1qa.task2_1.patterns;

import com.google.gson.Gson;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;

public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton() {}

    public static WebDriver getDriver() throws IOException {
        if(driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            Gson gson = new Gson();
            FileReader reader = new FileReader("C:\\Users\\roliz\\IdeaProjects\\r.ramirez\\src\\test\\java\\a1qa\\task2_1\\patterns\\config.json");
            ChromeOptionsData data = gson.fromJson(reader, ChromeOptionsData.class);
            for(String argument : data.arguments) {
                options.addArguments(argument);
            }
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    private static class ChromeOptionsData {
        public String[] arguments;
    }
}


