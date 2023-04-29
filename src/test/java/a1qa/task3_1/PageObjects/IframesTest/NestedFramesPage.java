package a1qa.task3_1.PageObjects.IframesTest;

import a1qa.task3_1.PageObjects.BaseForm;
import a1qa.task3_1.Utilities.Elements.BaseElement;
import a1qa.task3_1.Utilities.Logger.LoggerUtil;
import a1qa.task3_1.Utilities.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage extends BaseForm {

    static LoggerUtil logger = new LoggerUtil(NestedFramesPage.class);
    public static By nestedFrameForm = By.xpath("//div[contains(text(),'Nested Frames')]");
    public static By parentFrameMsg = By.id("frame1");

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    public static boolean nestedFramesOpen() {
        logger.debug("Checking if the Nested Frames page is open");
        try {
            return BaseElement.isDisplayed(nestedFrameForm);
        } catch (Exception e) {
            logger.error("An error occurred while checking if the nested frames form is displayed: " + e.getMessage());
            return false;
        }    }

    public static String parentFrameMsg(){
        logger.debug("Switching to Parent Frame to get the text of the Parent frame");
        try{
            logger.info("Inside Parent Frame");
            Waits.waitForClickable(parentFrameMsg);
            BaseElement.scrollTo(parentFrameMsg);
            BaseElement.switchToFrame(BaseElement.findElement(parentFrameMsg));
            try {
                logger.info("Getting the text from parent frame");
                String iFrameMsg = BaseElement.findElement(By.xpath("//body")).getText();
                BaseElement.switchToParentFrame();
                return iFrameMsg;
            }catch (Exception e){
                logger.error("An error occurred while getting the text from the parent frame: " + e.getMessage());
                return "";
            }
        }catch (Exception e){
            logger.error("An error occurred while switching to the parent frame: " + e.getMessage());
            return "";
        } finally {
            logger.info("Back to default content");
            BaseElement.switchToParentFrame();
        }
    }

    public static String childFrameMsg(){
        try {
            logger.debug("Switching to Parent Frame to get the text of the Child frame");
            BaseElement.switchToFrame(BaseElement.findElement(parentFrameMsg));
            try {
                logger.debug("Switching to Child Frame");
                BaseElement.switchToFrame(0);
                try {
                    logger.info("Getting the text from child frame");
                    return BaseElement.findElement(By.xpath("//p[normalize-space()='Child Iframe']")).getText();
                }catch (Exception e) {
                    logger.error("An error occurred while getting the text from the child frame: " + e.getMessage());
                    return "";
                }
            }catch (Exception e){
                logger.error("An error occurred while switching to the child frame: " + e.getMessage());
                return "";
            }
        }catch (Exception e){
            logger.error("An error occurred while switching to the parent frame: " + e.getMessage());
            return "";
        }finally {
            logger.info("Back to default content");
            BaseElement.switchToParentFrame();
            BaseElement.switchToParentFrame();
        }
    }

}
