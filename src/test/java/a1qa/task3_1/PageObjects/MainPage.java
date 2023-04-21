package a1qa.task3_1.PageObjects;

import a1qa.task3_1.Utilities.BaseElement;
import a1qa.task3_1.Utilities.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseForm{

    @FindBy(xpath = "//h5[normalize-space()='Alerts, Frame & Windows']")
    public static WebElement alertFrameWinButton; //= By.xpath("//h5[normalize-space()='Alerts, Frame & Windows']");

    @FindBy(xpath = "//img[contains(@src, 'oolsqa')]")
    public static WebElement toolsQaLogo;//By.xpath("//img[contains(@src, 'oolsqa')]");
    //span[normalize-space()='Alerts']

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static boolean toolsQaLogoDisplayed(){
        Waits.waitForPresence(MainPage.toolsQaLogo);
        return toolsQaLogo.isDisplayed();
    }

    public static void clickAlertsFramesWindowsButton(){
        BaseElement.scrollTo(MainPage.alertFrameWinButton);
        BaseElement.click(MainPage.alertFrameWinButton);
    }

    public static void waitAFWButton(){
        Waits.waitForClickable(MainPage.alertFrameWinButton);
    }
}
