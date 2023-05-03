package a1qa.task3_1.Tests.Scenarios;

import a1qa.task3_1.PageObjects.BaseForm;
import a1qa.task3_1.PageObjects.HandlesTest.HandlesBrowserPage;
import a1qa.task3_1.PageObjects.MainPage;
import a1qa.task3_1.Tests.BaseTest;
import a1qa.task3_1.Utilities.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlesTest extends BaseTest {

    @Test
    public void handlesTest(){
        //step 1
        Browser.visit(BaseForm.mainUrl);
        Assert.assertTrue(MainPage.toolsQaLogoDisplayed(), "The element from Main Page is NOT displayed");

        //step 2
        MainPage.clickAlertsFramesWindowsButton();
        HandlesBrowserPage.clickBrowserMenu();
        Assert.assertTrue(HandlesBrowserPage.browserWindowOpen());

        //step 3
        HandlesBrowserPage.clickNewTab();
    }
}
