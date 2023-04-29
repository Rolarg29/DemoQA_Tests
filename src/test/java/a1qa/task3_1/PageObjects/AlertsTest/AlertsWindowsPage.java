package a1qa.task3_1.PageObjects.AlertsTest;

import a1qa.task3_1.PageObjects.BaseForm;
import a1qa.task3_1.Utilities.Elements.BaseElement;
import a1qa.task3_1.Utilities.Logger.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsWindowsPage extends BaseForm {

    static LoggerUtil logger = new LoggerUtil(AlertsWindowsPage.class);
    public static By alertsButton = By.xpath("//span[normalize-space()='Alerts']");
    public static By nestedFramesButton = By.xpath("//span[normalize-space()='Nested Frames']");
    public static By framesButton = By.xpath("//span[normalize-space()='Frames']");

    public AlertsWindowsPage(WebDriver driver, LoggerUtil logger) {
        super(driver);
    }

    public static void clickAlertsMenu(){
        logger.info("Clicking on 'Alerts' menu");
        BaseElement.click(alertsButton);
    }

    public static void clickNestedFramesMenu(){
        logger.info("Clicking on 'Nested Frames' menu");
        BaseElement.scrollTo(nestedFramesButton);
        BaseElement.click(nestedFramesButton);
    }

    public static void clickFramesMenu(){
        logger.info("Clicking on 'Frames' menu");
        BaseElement.scrollTo(framesButton);
        BaseElement.click(framesButton);
    }
}
