package a1qa.task3_1.Tests;

import a1qa.task3_1.Factory.WebDriverFactory;
import a1qa.task3_1.Utilities.Logger.LoggerUtil;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class BaseTest {
    static LoggerUtil logger = new LoggerUtil(BaseTest.class);

    @BeforeSuite
    public void setUp() {
        WebDriverFactory.initialize();
        System.setProperty("log4j2.xml", "src/main/resources/log4j2.xml");
    }
    @BeforeTest
    public void testStart(ITestContext context){
        String testName = context.getCurrentXmlTest().getName();
        logger.info("STARTING TEST: " + testName.toUpperCase());
    }

    @AfterTest
    public void testEnd(ITestContext context){
        String testName = context.getCurrentXmlTest().getName();
        logger.info("FINISHING TEST: " + testName);
    }

    @AfterSuite
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
