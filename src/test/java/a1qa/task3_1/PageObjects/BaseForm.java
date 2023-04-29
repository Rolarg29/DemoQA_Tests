package a1qa.task3_1.PageObjects;


import a1qa.task3_1.Factory.WebDriverFactory;
import a1qa.task3_1.PageObjects.AlertsTest.AlertsPage;
import a1qa.task3_1.Utilities.Logger.LoggerUtil;
import org.openqa.selenium.WebDriver;

public abstract class BaseForm {

    public static String mainUrl = "https://demoqa.com/";
    protected static WebDriver driver;
    protected static LoggerUtil logger;


    public BaseForm(WebDriver driver) {
        this.driver = WebDriverFactory.initialize();

    }
}
