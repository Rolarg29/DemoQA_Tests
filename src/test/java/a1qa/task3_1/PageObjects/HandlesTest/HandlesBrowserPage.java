package a1qa.task3_1.PageObjects.HandlesTest;

import a1qa.task3_1.PageObjects.AlertsTest.AlertsPage;
import a1qa.task3_1.PageObjects.BaseForm;
import a1qa.task3_1.Utilities.Elements.BaseElement;
import a1qa.task3_1.Utilities.Logger.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HandlesBrowserPage extends BaseForm {

    private static final LoggerUtil logger = new LoggerUtil(AlertsPage.class);
    private static final By browserWindowsHeader = By.xpath("//div[contains(@class,'main-header')]");
    private static final By browserWindowsMenu = By.xpath("//span[normalize-space()='Browser Windows']");
    private static final By newTabButton = By.id("tabButton");

    public HandlesBrowserPage(WebDriver driver) {
        super(driver);
    }

    public static void clickBrowserMenu(){
        try {
            logger.debug("Clicking 'Browser Windows Menu'");
            BaseElement.click(browserWindowsMenu);
        }catch (Exception e){
            logger.error("Failed to click 'Browser Windows Menu'; " + e.getMessage());
        }
    }

    public static boolean browserWindowOpen(){
        try{
            logger.info("Browser window opened correctly");
            return BaseElement.isDisplayed(browserWindowsHeader);
        }catch (Exception e){
            logger.error("Failed to open 'Browser Windows Page'; " + e.getMessage());
            return false;
        }
    }

    public static void clickNewTab(){
        try{
            logger.debug("Clicking New Tab button");
            BaseElement.click(newTabButton);
        }catch (Exception e){
            logger.error("Failed to click New Tab button; " + e.getMessage());
        }
    }
}
