package a1qa.task3_1.PageObjects.IframesTest;

import a1qa.task3_1.PageObjects.BaseForm;
import a1qa.task3_1.Utilities.Browser;
import a1qa.task3_1.Utilities.Elements.BaseElement;
import a1qa.task3_1.Utilities.Logger.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BaseForm {

    private static final LoggerUtil logger = new LoggerUtil(FramesPage.class);
    private static final By frameForm = By.xpath("//div[contains(text(),'Frames')]");
    private static final By upperFrame = By.id("frame1");
    private static final By lowerFrame = By.id("frame2");

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public static boolean framesOpen() {
        logger.debug("Checking if Frames page is open");
        try {
            return BaseElement.isDisplayed(frameForm);
        } catch (Exception e) {
            logger.error("Error occurred while checking if Frames page is open: " + e.getMessage());
            return false;
        }
    }

    public static String upperFrameMessage(){
        try {
            logger.info("Switching to Upper Frame");
            BaseElement.scrollTo(BaseElement.findElement(upperFrame));
            Browser.switchToFrame(BaseElement.findElement(upperFrame));
            try {
                String iFrameMsg = BaseElement.findElement(By.id("sampleHeading")).getText();
                logger.info("Getting the text from upper frame: " + iFrameMsg);
                return iFrameMsg;

            }catch (Exception e) {
                logger.error("An error occurred while getting the message from the upper frame: " + e.getMessage());
                return "";
            }
        }catch (Exception e){
            logger.error("Error occurred while switching to upper frame: " + e.getMessage());
            return "";
        }finally {
            logger.info("Back to default content");
            Browser.switchToParentFrame();
        }
    }

    public static String lowerFrameMessage(){
        try {
            logger.info("Switching to Lower Frame");
            BaseElement.scrollTo(BaseElement.findElement(lowerFrame));
            Browser.switchToFrame(BaseElement.findElement(lowerFrame));
            try {
                BaseElement.scrollTo(By.id("sampleHeading"));
                String iFrameMsg = BaseElement.findElement(By.id("sampleHeading")).getText();
                logger.info("Getting the text from lower frame: " + iFrameMsg);
                return iFrameMsg;
            }catch (Exception e) {
                logger.error("An error occurred while getting the message from the lower frame: " + e.getMessage());
                return "";
            }
        } catch (Exception e) {
            logger.error("An error occurred while trying to get the message from the lower frame: " + e.getMessage());
            return "";
        }finally {
            logger.info("Back to default content");
            Browser.switchToParentFrame();
        }
    }
}
