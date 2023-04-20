package a1qa.task3_1.PageObjects;

import a1qa.task3_1.Utilities.BaseElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsWindowsPage extends BaseForm {

    @FindBy(xpath = "//span[normalize-space()='Alerts']")
    public static WebElement alertsButton;

    public AlertsWindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static void clickAlertsButton(){
//        BaseElement.scrollTo(AlertsWindowsPage.alertsButton);
        BaseElement.click(AlertsWindowsPage.alertsButton);
    }
}
