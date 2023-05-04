package a1qa.task3_1.PageObjects.HandlesTest;

import a1qa.task3_1.PageObjects.BaseForm;
import a1qa.task3_1.Utilities.Browser;
import a1qa.task3_1.Utilities.Elements.BaseElement;
import a1qa.task3_1.Utilities.Logger.LoggerUtil;
import a1qa.task3_1.Utilities.Waits;
import org.openqa.selenium.By;

public class HandlesBrowserPage extends BaseForm {

    private static final LoggerUtil logger = new LoggerUtil(HandlesBrowserPage.class);
    private static final By browserWindowsHeader = By.xpath("//div[contains(text(),'Browser Windows')]");
    private static final By browserWindowsMenu = By.xpath("//span[normalize-space()='Browser Windows']");
    private static final By newTabButton = By.id("tabButton");
    private static final By newTabElement = By.id("sampleHeading");


    public HandlesBrowserPage() {
        super(driver);
        driver=BaseElement.driver;
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

    public static void openNewTab(){
        clickNewTab();
        try{
            logger.debug("Waiting New Tab to open");
            Waits.waitForNewTabOpens(2);
            Browser.switchTab();
        } catch (Exception e) {
            logger.error("Failed to open New Tab; " + e.getMessage());
        }
    }

    public static void closeNewTab(){
        try{
            logger.debug("Closing New tab an returning to previous 'Browser Window' page");
            Browser.switchBackAfterClosingTab();
        } catch (Exception e) {
            logger.error("Failed to close New Tab and switching back; " + e.getMessage());
        }
    }

    public static String newTabDisplayed(){
        try{
            logger.info("Waiting for New tab page to load");
            Waits.waitForPresence(newTabElement);
            return BaseElement.getText(newTabElement);
        } catch (Exception e) {
            logger.error("Failed to load New Tab, No elements displayed; " + e.getMessage());
            return " ";
        }
    }

}
