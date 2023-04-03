package a1qa.task2_1;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class SteamTest {

    @BeforeSuite
    public void setUp() {
        WebDriverSingleton.initialize();
    }

    @Test
    public void testPrivacyPolicy(){
        //Privacy Policy open in a new tab
        BaseUtil.visit(HomePage.mainUrl);
        BaseUtil.scrollToEnd();
        Waits.waitForClickable(HomePage.privacyPolicyClick);
        BaseUtil.click(HomePage.privacyPolicyClick);
        BaseUtil.switchTab();
        Assert.assertEquals(WebDriverSingleton.driver.getTitle(), HomePage.policyTitle, "They are NOT the same");

        //Switch language elements list displayed
        HomePage.selectLang(HomePage.languages);
        Assert.assertTrue(HomePage.allLanguagesDisplayed, "There are missing language elements");

        //Policy revision signed this year
        BaseUtil.scrollToEnd();
        String year = BaseUtil.getText(HomePage.revisionDate);
        Assert.assertTrue(BaseUtil.textMatchBool(year, "2023"), "There is NO policy signed by this year");
    }

    @Test
    public void gameSearch() {
        //Result page is open
        BaseUtil.visit(HomePage.mainUrl);
        BaseUtil.type(SearchPage.gameName, SearchPage.searchBox);
        BaseUtil.click(SearchPage.searchButton);
        Assert.assertEquals(BaseUtil.page(), SearchPage.searchResultPage, "This is NOT the result page");

        //Search box on result contains searched name
        String resultSearchBox = BaseUtil.attribute(SearchPage.innerSearchBox, "value");
        Assert.assertEquals(resultSearchBox, SearchPage.gameName, "This is NOT the same name as the search");

        //First name equals searched name
        String game1 = BaseUtil.getText(SearchPage.firstResultName);
        String game2 = BaseUtil.getText(SearchPage.secondResultName);
        Assert.assertEquals(game1, SearchPage.gameName, "The first result is different");

        //information saved in a json file
        SearchPage.gameData();
        SearchPage.jsonCreate();

        //Search box on result contains searched name
        BaseUtil.type(game2, SearchPage.searchBox);
        BaseUtil.click(SearchPage.searchButton);
        String resultSearchBox2 = BaseUtil.attribute(SearchPage.innerSearchBox, "value");
        Assert.assertEquals(resultSearchBox2, game2, "This is NOT the same name as the search");

        //Result list contains 2 stored items from the previous search. All stored data matched
        Assert.assertTrue(SearchPage.compareData(), "The data stored do not match the new result list");
    }

    @AfterSuite
    public void tearDown(){
        WebDriverSingleton.quit();
    }

}
