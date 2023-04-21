package a1qa.task3_1.PageObjects.AlertsTest;

import a1qa.task3_1.PageObjects.BaseForm;
import a1qa.task3_1.Utilities.BaseElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class AlertsPage extends BaseForm {

    @FindBy(xpath = "//span[normalize-space()='Click Button to see alert']")
    public static WebElement alertForm;

    @FindBy(xpath = "//span[normalize-space()='On button click, alert will appear after 5 seconds']")
    public static WebElement alert5SecsForm;

    @FindBy(xpath = "//span[normalize-space()='On button click, confirm box will appear']")
    public static WebElement alertConfirmForm;

    @FindBy(xpath = "//span[normalize-space()='On button click, prompt box will appear']")
    public static WebElement alertPromptForm;

    @FindBy(xpath = "//button[@id='alertButton']")
    public static WebElement alertButton;

    @FindBy(xpath = "//button[@id='confirmButton']")
    public static WebElement alertConfirmButton;

    @FindBy(xpath = "//span[@id='confirmResult']")
    public static WebElement alertConfirmResult;
//span[@id='promptResult']

    @FindBy(xpath = "//button[@id='promtButton']")
    public static WebElement alertPromptButton;

    @FindBy(xpath = "//span[@id='promptResult']")
    public static WebElement alertPromptResult;


    public AlertsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static boolean alertsFormsDisplayed() {
        return alertForm.isDisplayed() && alert5SecsForm.isDisplayed() && alertConfirmForm.isDisplayed() && alertPromptForm.isDisplayed();
    }

    public static void clickAlertButton(WebElement element) {
        BaseElement.click(element);
    }

    public static String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public static void clickOk() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static boolean alertClosed() {
        return AlertsPage.alertPromptButton.isEnabled();
    }

    public static String getResultText(WebElement element) {
        return BaseElement.getText(element);
    }

    public static String alertRandomText() {
        Alert alert = driver.switchTo().alert();

        Random random = new Random();
        StringBuilder builder = new StringBuilder();

        int length = 8; // set the length of the string
        String characters = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            builder.append(characters.charAt(index));
        }
        String randomString = builder.toString();
        alert.sendKeys(randomString);
        return randomString;
    }


}
