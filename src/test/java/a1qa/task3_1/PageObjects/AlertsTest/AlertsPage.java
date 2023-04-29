package a1qa.task3_1.PageObjects.AlertsTest;

import a1qa.task3_1.PageObjects.BaseForm;
import a1qa.task3_1.Tests.Scenarios.AlertsTest;
import a1qa.task3_1.Utilities.Elements.BaseElement;
import a1qa.task3_1.Utilities.Logger.LoggerUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BaseForm {

    static LoggerUtil logger = new LoggerUtil(AlertsPage.class);
    public static By alertForm = By.xpath("//div[contains(text(),'Alerts')]");
    public static By alertButton = By.id("alertButton");
    public static By alertConfirmButton = By.xpath("//button[@id='confirmButton']");
    public static By alertConfirmResult = By.xpath("//span[@id='confirmResult']");
    public static By alertPromptButton = By.id("promtButton");
    public static By alertPromptResult = By.id("promptResult");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public static boolean alertFormDisplayed(By locator) {
        logger.info("Checking if alert form is displayed");
        return BaseElement.isDisplayed(locator);
    }

    public static void clickAlertButton(By locator) {
        logger.debug("Clicking alert button with locator: " + locator.toString());
        BaseElement.click(locator);
    }

    public static String getAlertText() {
        logger.info("Switching to alert and getting its text");
        Alert alert = BaseElement.switchToAlert();
        return alert.getText();
    }

    public static String randomTextForAlert(){
        String randomText = BaseElement.alertRandomText();
        logger.info("Random text generated for alert: " + randomText);
        return randomText;
    }

    public static void clickOk() {
        logger.info("Clicking OK button in alert");
        Alert alert = BaseElement.switchToAlert();
        alert.accept();
    }

    public static boolean alertClosed() {
        logger.info("Checking if prompt alert is closed");
        return BaseElement.findElement(alertPromptButton).isEnabled();
    }

    public static String getResultText(By locator) {
        logger.debug("Getting text from element with locator: " + locator.toString());
        return BaseElement.getText(locator);
    }
}

