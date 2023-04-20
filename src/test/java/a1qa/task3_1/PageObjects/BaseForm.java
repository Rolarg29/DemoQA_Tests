package a1qa.task3_1.PageObjects;


import a1qa.task3_1.Factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseForm {


    //plantilla para las page objects
    public static String mainUrl = "https://demoqa.com/";
    protected static WebDriver driver;

    public BaseForm(WebDriver driver) {
        this.driver = WebDriverFactory.initialize();
        PageFactory.initElements(driver, this);
    }
}
