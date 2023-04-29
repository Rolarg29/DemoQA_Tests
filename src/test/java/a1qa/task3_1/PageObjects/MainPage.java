package a1qa.task3_1.PageObjects;

import a1qa.task3_1.Utilities.Elements.BaseElement;
import a1qa.task3_1.Utilities.Logger.LoggerUtil;
import a1qa.task3_1.Utilities.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BaseForm{

    static LoggerUtil logger = new LoggerUtil(MainPage.class);
    public static By alertFrameWinButton = By.xpath("//h5[normalize-space()='Alerts, Frame & Windows']");
    public static By elementsButton = By.xpath("//h5[normalize-space()='Elements']");
    public static By toolsQaLogo = By.xpath("//img[contains(@src, 'oolsqa')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public static boolean toolsQaLogoDisplayed(){
        try {
            logger.debug("Waiting for Main Page to load");
            Waits.waitForPresence(toolsQaLogo);
            return BaseElement.isDisplayed(toolsQaLogo);
        }catch(Exception e){
            logger.error("An error occurred while loading the page: "+ e.getMessage());
            return false;
        }
    }
    public static void clickAlertsFramesWindowsButton(){
        try{
            logger.debug("Scrolling and clicking Alerts, frames and windows menu button");
            BaseElement.scrollTo(alertFrameWinButton);
            BaseElement.click(alertFrameWinButton);
        }catch(Exception e){
            logger.error("An error occurred while scrolling and clicking the Alerts, frames and windows menu;" + e.getMessage());
        }
    }
    public static void clickElementsButton(){
        try{
            logger.debug("Scrolling and clicking Elements menu button");
            BaseElement.scrollTo(elementsButton);
            BaseElement.click(elementsButton);
        }catch(Exception e){
            logger.error("An error occurred while scrolling and clicking the Elements menu;" + e.getMessage());
        }
    }
}
