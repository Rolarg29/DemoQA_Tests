package a1qa.task3_1.PageObjects;

import a1qa.task3_1.Utilities.Elements.BaseElement;
import a1qa.task3_1.Utilities.Logger.LoggerUtil;
import a1qa.task3_1.Utilities.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BaseForm{

    public static By alertFrameWinButton = By.xpath("//h5[normalize-space()='Alerts, Frame & Windows']");

    public static By elementsButton = By.xpath("//h5[normalize-space()='Elements']");

    public static By toolsQaLogo = By.xpath("//img[contains(@src, 'oolsqa')]");

    public MainPage(WebDriver driver, LoggerUtil logger) {
        super(driver);
    }

    public static boolean toolsQaLogoDisplayed(){
        Waits.waitForPresence(toolsQaLogo);
        return BaseElement.isDisplayed(toolsQaLogo);
    }
    public static void clickAlertsFramesWindowsButton(){
        BaseElement.scrollTo(alertFrameWinButton);
        BaseElement.click(alertFrameWinButton);
    }
    public static void clickElementsButton(){
        BaseElement.scrollTo(elementsButton);
        BaseElement.click(elementsButton);
    }

}
