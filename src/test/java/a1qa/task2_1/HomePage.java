package a1qa.task2_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static a1qa.task2_1.BaseUtil.findElement;


public class HomePage {

    // Home page and privacy policy links
    public static final String mainUrl = "https://store.steampowered.com/";
    public static final String policyTitle = "Privacy Policy Agreement";
    public static final By privacyPolicyClick = By.linkText("Privacy Policy");
    public static final By revDate = By.xpath("//div/div[7]/div[6]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/i[3]");

    //Privacy Policy Language list
    public static boolean allLanguagesDisplayed = false;
    public static final By spanish = By.cssSelector("a[href*='spanish'] img");
    public static final By portuguese = By.cssSelector("a[href*='portuguese'] img");
    public static final By english = By.cssSelector("a[href*='english'] img");
    public static final By french = By.cssSelector("a[href*='french'] img");
    public static final By german = By.cssSelector("a[href*='german'] img");
    public static final By italian = By.cssSelector("a[href*='italian'] img");
    public static final By russian= By.cssSelector("a[href*='russian'] img");
    public static final By japanese = By.cssSelector("a[href*='japanese'] img");
    public static final By brazilian = By.cssSelector("a[href*='brazilian'] img");
    public static final By[] languages = {spanish,french,german,italian,russian,japanese,portuguese,brazilian,english};

    //Revision date
//    public static WebElement revDate = driver.findElement(By.xpath("/html/body/div/div[7]/div[6]/div[1]/div/div[2]/div[2]/div/div[2]/i[3]"));


    public static void selectLang(By[] languages){
        for (By language : languages){
//            click(language);
            WebElement element =  findElement(language);
            allLanguagesDisplayed = element.isDisplayed();
        }
    }
}
