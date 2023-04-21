package a1qa.task3_1.Tests.Scenarios;

import a1qa.task3_1.PageObjects.BaseForm;
import a1qa.task3_1.PageObjects.MainPage;
import a1qa.task3_1.PageObjects.TablesTest.WebTablesPage;
import a1qa.task3_1.Tests.BaseTest;
import a1qa.task3_1.Utilities.BaseElement;
import a1qa.task3_1.Utilities.DDT.TableData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

public class TablesTest extends BaseTest {

    @Test
    public void tablesTest() throws IOException {
        //step 1
        BaseElement.visit(BaseForm.mainUrl);
        Assert.assertTrue(MainPage.toolsQaLogoDisplayed(), "The element from Main Page is NOT displayed");

        //step 2
        MainPage.clickElementsButton();
        WebTablesPage.clickWebTablesMenu();
        Assert.assertTrue(WebTablesPage.webTablesOpen(), "The Web Tables page is NOT open");

        //step 3
        //User Number 1
        WebTablesPage.clickAddButton();
        Assert.assertTrue(WebTablesPage.registrationFormOpen(), "The registration form is NOT enabled");
        WebTablesPage.fillRegistrationForm(TableData.userNumber1);
        WebTablesPage.clickSubmitButton();

        //User Number 2
        WebTablesPage.clickAddButton();
        WebTablesPage.fillRegistrationForm(TableData.userNumber2);
        WebTablesPage.clickSubmitButton();




    }
}
