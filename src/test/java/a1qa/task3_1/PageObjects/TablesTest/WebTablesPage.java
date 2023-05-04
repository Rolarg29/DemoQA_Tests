package a1qa.task3_1.PageObjects.TablesTest;

import a1qa.task3_1.PageObjects.BaseForm;
import a1qa.task3_1.Utilities.DDT.TableData;
import a1qa.task3_1.Utilities.Elements.BaseElement;
import a1qa.task3_1.Utilities.Logger.LoggerUtil;
import a1qa.task3_1.Utilities.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import java.util.Objects;

public class WebTablesPage extends BaseForm {

    static LoggerUtil logger = new LoggerUtil(WebTablesPage.class);
    public static By webTablesMenu = By.xpath("//span[contains(text(),'Web Tables')]");
    public static By webTablesForm = By.xpath("//div[contains(text(),'Web Tables')]");
    public static By addTablesButton = By.id("addNewRecordButton");
    public static By registrationForm = By.id("registration-form-modal");
    public static By submitButton = By.id("submit");
    public static By firstName = By.id("firstName");
    public static By lastName = By.id("lastName");
    public static By email = By.id("userEmail");
    public static By age = By.id("age");
    public static By salary = By.id("salary");
    public static By department = By.id("department");
    public static By userNumber1Record = By.xpath("//div[normalize-space()='Jon']");
    public static By userNumber2Record = By.xpath("//div[normalize-space()='Buttercup']");
    public static By searchTable = By.id("searchBox");
    public static By deleteButton = By.xpath("//span[@title='Delete']");

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    public static void clickWebTablesMenu() {
        try {
            logger.debug("Scrolling to and clicking Web Tables menu");
            BaseElement.scrollTo(webTablesMenu);
            Waits.waitForClickable(webTablesMenu);
            BaseElement.click(webTablesMenu);
            logger.info("Clicked Web Tables menu");
        } catch (Exception e) {
            logger.error("An error occurred while clicking Web Tables menu: " + e.getMessage());
        }
    }

    public static void clickAddButton() {
        try {
            logger.debug("Clicking 'Add' button to insert new data into the table");
            BaseElement.scrollTo(addTablesButton);
            BaseElement.click(addTablesButton);
        } catch (Exception e) {
            logger.error("An error occurred while clicking on the 'Add' button: " + e.getMessage());
        }
    }

    public static boolean webTablesOpen() {
        logger.debug("Checking if web tables page is open");
        return BaseElement.isDisplayed(webTablesForm) && BaseElement.isDisplayed(addTablesButton);
    }

    public static boolean registrationFormOpen() {
        return BaseElement.isEnabled(registrationForm);
    }

    public static boolean registrationFormClosed() {
        return Waits.waitForInvisibleLocator(registrationForm);
    }


    public static void fillRegistrationForm(String userNo) {
        logger.info("Filling registration form");
        if (registrationFormOpen() && Objects.equals(userNo, "1")) {
            BaseElement.type(TableData.firstName1, firstName);
            BaseElement.type(TableData.lastname1, lastName);
            BaseElement.type(TableData.email1, email);
            BaseElement.type(TableData.age1, age);
            BaseElement.type(TableData.salary1, salary);
            BaseElement.type(TableData.department1, department);
        }

        if (registrationFormOpen() && Objects.equals(userNo, "2")) {
            BaseElement.type(TableData.firstName2, firstName);
            BaseElement.type(TableData.lastname2, lastName);
            BaseElement.type(TableData.email2, email);
            BaseElement.type(TableData.age2, age);
            BaseElement.type(TableData.salary2, salary);
            BaseElement.type(TableData.department2, department);
        }
    }

    public static void clickSubmitButton() {
        try {
            logger.debug("Clicking Submit button");
            BaseElement.click(submitButton);
        } catch (Exception e) {
            logger.error("An error occurred while clicking the Submit button: " + e.getMessage());
        }
    }

    public static boolean usersDataInTable() {
        logger.debug("Checking both users No.1 and No.2 from Data table are in the web table");
        return BaseElement.isDisplayed(userNumber1Record) && BaseElement.isDisplayed(userNumber2Record);
    }

    public static boolean userDeletedFromTable(By locator, String name) {
        logger.debug("Checking user ["+name+"] has been deleted from the Web table");
        try {
            boolean user =  BaseElement.isDisplayed(locator);
            if (user) {
                logger.error("An error occurred while deleting ["+name+"] user's row, the user has been found in the Web table");
            }
            logger.info("User ["+name+"] found in table: " + user);
            return !user;
        } catch (NoSuchElementException e) {
            logger.info("Deletion has been successful, user ["+name+"] NOT found");
            return true;
        }
    }

    public static void locateAndDeleteUserInTable(String userName, By userRecord){
        logger.debug("Locating ["+userName+"] user record in table to delete it" );
        try {
            String tableName = BaseElement.getText(userRecord);
            logger.info("Name of user found in table records: [" + tableName + "]");
            if (tableName.equals(userName)) {
                logger.info("Records in table matches username");
                logger.debug("Deleting record");
                BaseElement.type(tableName, searchTable);
                BaseElement.click(deleteButton);
                BaseElement.clear(searchTable);
            }
        } catch (NoSuchElementException e) {
            logger.error("An error occurred while locating use record in web table: " + e.getMessage());
        }
    }
}

