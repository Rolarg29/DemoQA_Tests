package a1qa.task2_1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static a1qa.task2_1.HomePage.*;


public class SteamTest {

    @BeforeSuite
    public void setUp() {
        WebDriverSingleton.initialize();
    }

    @Test
    public void testPrivacyPolicy(){
        BaseUtil.visit(MainUrl);
//        HomePage.scrollToPrivacyPolicy();
        BaseUtil.scrollTo(privacyPolicyLink);
    }

    @AfterSuite
    public void tearDown(){
//        WebDriverSingleton.quit();
    }

}
