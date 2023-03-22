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
        scrollToEnd();
        waitForClickable(privacyPolicyClick);
        click(privacyPolicyClick);
        switchTab();
        Assert.assertEquals(driver.getTitle(), policyTitle, "They are NOT the same");
        selectLang(languages);
        Assert.assertTrue(allLanguagesDisplayed);
//        getText(revDate);

    }

    @AfterSuite
    public void tearDown(){
//        WebDriverSingleton.quit();
    }

}
