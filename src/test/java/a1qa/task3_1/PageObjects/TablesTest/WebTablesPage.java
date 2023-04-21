package a1qa.task3_1.PageObjects.TablesTest;

import a1qa.task3_1.PageObjects.BaseForm;
import a1qa.task3_1.Utilities.BaseElement;
import a1qa.task3_1.Utilities.DDT.TableData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class WebTablesPage extends BaseForm {

    @FindBy(xpath = "//span[normalize-space()='Web Tables']")
    public static WebElement webTablesMenu;

    @FindBy(xpath = "//div[contains(text(),'Web Tables')]")
    public static WebElement webTablesForm;

    @FindBy(id = "addNewRecordButton")
    public static WebElement addTablesButton;

    @FindBy(id = "registration-form-modal")
    public static WebElement registrationForm;

    @FindBy(id = "submit")
    public static WebElement submitButton;

    @FindBy(id = "firstName")
    public static WebElement firstName;

    @FindBy(id = "lastName")
    public static WebElement lastName;

    @FindBy(id = "userEmail")
    public static WebElement email;

    @FindBy(id = "age")
    public static WebElement age;

    @FindBy(id = "salary")
    public static WebElement salary;

    @FindBy(id = "department")
    public static WebElement department;





    public WebTablesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static void clickWebTablesMenu(){
        BaseElement.scrollTo(webTablesMenu);
        BaseElement.click(webTablesMenu);
    }

    public static void clickAddButton(){
        BaseElement.scrollTo(addTablesButton);
        BaseElement.click(addTablesButton);
    }

    public static boolean webTablesOpen() {
        return webTablesForm.isDisplayed() && addTablesButton.isDisplayed();
    }

    public static boolean registrationFormOpen() {
        return registrationForm.isEnabled();
    }

    public static void fillRegistrationForm(String userNo){
        if (registrationFormOpen()&&Objects.equals(userNo, "1")){
            firstName.sendKeys(TableData.firstName1);
            lastName.sendKeys(TableData.lastname1);
            email.sendKeys(TableData.email1);
            age.sendKeys(TableData.age1);
            salary.sendKeys(TableData.salary1);
            department.sendKeys(TableData.department1);
        }
        if (registrationFormOpen()&&Objects.equals(userNo, "2")){
            firstName.sendKeys(TableData.firstName2);
            lastName.sendKeys(TableData.lastname2);
            email.sendKeys(TableData.email2);
            age.sendKeys(TableData.age2);
            salary.sendKeys(TableData.salary2);
            department.sendKeys(TableData.department2);
        }

    }

    public static void clickSubmitButton(){
        BaseElement.click(submitButton);
    }

}
