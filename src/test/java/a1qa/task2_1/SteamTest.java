package a1qa.task2_1;

import a1qa.task2_1.patterns.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;


public class SteamTest {
    WebDriver driver;

    {
        try {
            driver = WebDriverSingleton.getDriver();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SteamTest() throws IOException {
    }


    @BeforeSuite
    public void setUp() {
    driver.get("google.com");
    }

    @Test
    public void testPrivacyPolicy(){
    }

}
