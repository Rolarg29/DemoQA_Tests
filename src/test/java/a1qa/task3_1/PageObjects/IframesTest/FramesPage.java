package a1qa.task3_1.PageObjects.IframesTest;

import a1qa.task3_1.PageObjects.BaseForm;
import a1qa.task3_1.Utilities.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage extends BaseForm {

    @FindBy(xpath = "//div[contains(text(),'Frames')]")
    public static WebElement frameForm;

    @FindBy(id = "frame1Wrapper")
    public static WebElement upperFrameWrapper;

    @FindBy(id = "frame2Wrapper")
    public static WebElement lowerFrameWrapper;


    @FindBy(id = "frame1")
    public static WebElement upperFrame;

    @FindBy(id = "frame2")
    public static WebElement lowerFrame;



    public FramesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public static boolean framesOpen() {
        return frameForm.isDisplayed() && upperFrameWrapper.isDisplayed() && lowerFrameWrapper.isDisplayed();
    }

    public static String upperFrameMessage(){
        BaseElement.scrollTo(upperFrame);
        driver.switchTo().frame(upperFrame);
        String iFrameMsg = driver.findElement(By.id("sampleHeading")).getText();
        driver.switchTo().parentFrame();
        return iFrameMsg;
    }
    public static String lowerFrameMessage(){
        BaseElement.scrollTo(lowerFrame);
        driver.switchTo().frame(lowerFrame);
        BaseElement.scrollTo(driver.findElement(By.id("sampleHeading")));
        String iFrameMsg = driver.findElement(By.id("sampleHeading")).getText();
        driver.switchTo().parentFrame();
        return iFrameMsg;
    }



}
