package a1qa.task3_1.Tests.Scenarios;

import a1qa.task3_1.PageObjects.BaseForm;
import a1qa.task3_1.PageObjects.MainPage;
import a1qa.task3_1.PageObjects.TablesTest.WebTablesPage;
import a1qa.task3_1.Tests.BaseTest;
import a1qa.task3_1.Utilities.Elements.BaseElement;
import a1qa.task3_1.Utilities.DDT.TableData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TablesTest extends BaseTest {

    @Test
    public void tablesTest() {
        //step 1 -Main page open
        BaseElement.visit(BaseForm.mainUrl);
        Assert.assertTrue(MainPage.toolsQaLogoDisplayed(), "The element from Main Page is NOT displayed");

        //step 2 - Web tables page open
        MainPage.clickElementsButton();
        WebTablesPage.clickWebTablesMenu();
        Assert.assertTrue(WebTablesPage.webTablesOpen(), "The Web Tables page is NOT open");

        //step 3 - Registration form appeared
        WebTablesPage.clickAddButton();
        Assert.assertTrue(WebTablesPage.registrationFormOpen(), "The registration form is NOT enabled");

        //step 4
        //User number 1
        WebTablesPage.fillRegistrationForm(TableData.userNumber1);
        WebTablesPage.clickSubmitButton();
        //User Number 2
        WebTablesPage.clickAddButton();
        WebTablesPage.fillRegistrationForm(TableData.userNumber2);
        //Submit form
        WebTablesPage.clickSubmitButton();
        //Registration form closed
        Assert.assertTrue(WebTablesPage.registrationFormClosed());
        //Data of users has appeared on table
        Assert.assertTrue(WebTablesPage.usersDataInTable());

        //step 5

        WebTablesPage.locateAndDeleteUserInTable(TableData.firstName1, WebTablesPage.userNumber1Record);
        WebTablesPage.locateAndDeleteUserInTable(TableData.firstName2, WebTablesPage.userNumber2Record);
        Assert.assertTrue(WebTablesPage.userDeletedFromTable(WebTablesPage.userNumber1Record, TableData.firstName1));
        Assert.assertTrue(WebTablesPage.userDeletedFromTable(WebTablesPage.userNumber2Record, TableData.firstName2));


    }
}
