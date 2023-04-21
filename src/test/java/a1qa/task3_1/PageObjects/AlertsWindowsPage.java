package a1qa.task3_1.PageObjects;

import a1qa.task3_1.Utilities.BaseElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsWindowsPage extends BaseForm {

    @FindBy(xpath = "//span[normalize-space()='Alerts']")
    public static WebElement alertsButton;

    @FindBy(xpath = "//span[normalize-space()='Nested Frames']")
    public static WebElement nestedFramesButton;

    @FindBy(xpath = "//span[normalize-space()='Frames']")
    public static WebElement framesButton;


    public AlertsWindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static void clickAlertsMenu(){
        BaseElement.click(AlertsWindowsPage.alertsButton);
    }

    public static void clickNestedFramesMenu(){
        BaseElement.scrollTo(nestedFramesButton);
        BaseElement.click(nestedFramesButton);
    }

    public static void clickFramesMenu(){
        BaseElement.scrollTo(framesButton);
        BaseElement.click(framesButton);
    }


}
