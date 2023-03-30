package a1qa.task2_1;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static a1qa.task2_1.BaseUtil.*;
import static a1qa.task2_1.HomePage.*;
import static a1qa.task2_1.SearchPage.*;


public class SteamTest {

    @BeforeSuite
    public void setUp() {
        WebDriverSingleton.initialize();
    }

    @Test
    public void testPrivacyPolicy(){
        //Privacy Policy open in a new tab
        visit(mainUrl);
        scrollToEnd();
        waitForClickable(privacyPolicyClick);
        click(privacyPolicyClick);
        switchTab();
        Assert.assertEquals(driver.getTitle(), policyTitle, "They are NOT the same");

        //Switch language elements list displayed
        selectLang(languages);
        Assert.assertTrue(allLanguagesDisplayed);

        //Policy revision signed this year
        scrollToEnd();
        String year = getText(revDate);
        Assert.assertTrue(textMatchBool(year, "2023"));
    }

    @Test
    public void gameSearch() {
        //Result page is open
        visit(mainUrl);
        type(gameName, searchBox);
        click(searchButton);
        Assert.assertEquals(page(), searchResultPage, "This is NOT the result page");

        //Search box on result contains searched name
        String resultSearchBox = attribute(innerSearchBox, "value");
        Assert.assertEquals(resultSearchBox, gameName, "This is NOT the same name as the search");

        //First name equals searched name
        String game1 = getText(firstResultName);
        String game2 = getText(secondResultName);
        Assert.assertEquals(game1, gameName, "The first result is different");

        //information saved in a json file
        gameData();
        jsonCreate();

        //Search box on result contains searched name
        type(game2, searchBox);
        click(searchButton);
        String resultSearchBox2 = attribute(innerSearchBox, "value");
        Assert.assertEquals(resultSearchBox2, game2, "This is NOT the same name as the search");

        //Result list contains 2 stored items from the previous search. All stored data matched
        Assert.assertTrue(compareData());
    }

    @AfterSuite
    public void tearDown(){
        WebDriverSingleton.quit();
    }

}
