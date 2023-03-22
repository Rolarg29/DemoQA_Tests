package a1qa.task2_1;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static a1qa.task2_1.BaseUtil.*;
import static a1qa.task2_1.HomePage.*;


public class SteamTest {

    @BeforeSuite
    public void setUp() {
        WebDriverSingleton.initialize();
    }

    @Test
    public void testPrivacyPolicy(){
        visit(mainUrl);
        scrollTo(privacyPolicyLink);
        click(privacyPolicyClick);
        switchTab();
        selectLang(languages);
        Assert.assertEquals(driver.getTitle(), policyTitle, "The are NOT the same");
        Assert.assertTrue(allLanguagesDisplayed);

    }

    @AfterSuite
    public void tearDown(){
//        WebDriverSingleton.quit();
    }

}
