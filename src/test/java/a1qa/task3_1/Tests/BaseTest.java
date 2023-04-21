package a1qa.task3_1.Tests;

import a1qa.task3_1.Factory.WebDriverFactory;
import a1qa.task3_1.PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseTest {
    WebDriver driver = WebDriverFactory.initialize();

    @BeforeSuite
    public void setUp() {
        WebDriverFactory.initialize();
        PageFactory.initElements(driver, MainPage.class);
        PageFactory.initElements(driver, AlertsWindowsPage.class);
        PageFactory.initElements(driver, AlertsPage.class);
        PageFactory.initElements(driver, NestedFramesPage.class);
        PageFactory.initElements(driver, FramesPage.class);



    }

    @AfterSuite
    public void tearDown() {
//        WebDriverFactory.quitDriver();
    }



}
