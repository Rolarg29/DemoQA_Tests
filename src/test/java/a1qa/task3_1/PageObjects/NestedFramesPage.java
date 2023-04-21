package a1qa.task3_1.PageObjects;

import a1qa.task3_1.Utilities.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramesPage extends BaseForm{

    @FindBy(xpath = "//div[contains(text(),'Nested Frames')]")
    public static WebElement nestedFrameForm;

    @FindBy(xpath = "//div[@id='frame1Wrapper']")
    public static WebElement nestedFrameWrapper;

    @FindBy(id = "frame1")
    public static WebElement parentFrameMsg;

    public NestedFramesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static boolean nestedFramesOpen() {
        return nestedFrameForm.isDisplayed() && nestedFrameWrapper.isDisplayed();
    }


    public static String parentFrameMsg(){
        BaseElement.scrollTo(parentFrameMsg);
        driver.switchTo().frame(parentFrameMsg);
        String iFrameMsg = driver.findElement(By.xpath("//body")).getText();
        driver.switchTo().parentFrame();
        return iFrameMsg;
    }

    public static String childFrameMsg(){
        driver.switchTo().frame(parentFrameMsg);
        driver.switchTo().frame(0);
        String iFrameMsg = driver.findElement(By.xpath("//p[normalize-space()='Child Iframe']")).getText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return iFrameMsg;
    }

}
