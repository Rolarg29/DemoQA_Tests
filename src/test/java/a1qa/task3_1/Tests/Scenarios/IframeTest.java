package a1qa.task3_1.Tests.Scenarios;

import a1qa.task3_1.PageObjects.*;
import a1qa.task3_1.Tests.BaseTest;
import a1qa.task3_1.Utilities.BaseElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest {

    @Test
    public void iFrameTest() {
        //step 1
        BaseElement.visit(BaseForm.mainUrl);
        Assert.assertTrue(MainPage.toolsQaLogoDisplayed(), "The element from Main Page is NOT displayed");

        //step 2
        MainPage.clickAlertsFramesWindowsButton();
        AlertsWindowsPage.clickNestedFramesMenu();
        Assert.assertTrue(NestedFramesPage.nestedFramesOpen(), "The Nested frame Page is NOT displayed");
        Assert.assertEquals(NestedFramesPage.parentFrameMsg(), "Parent frame");
        Assert.assertEquals(NestedFramesPage.childFrameMsg(), "Child Iframe");

        //step 3
        AlertsWindowsPage.clickFramesMenu();
        Assert.assertTrue(FramesPage.framesOpen(), "The Frames page is NOT displayed");
        Assert.assertEquals(FramesPage.upperFrameMessage(), FramesPage.lowerFrameMessage());








    }
}
