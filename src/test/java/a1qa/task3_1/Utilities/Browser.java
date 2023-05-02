package a1qa.task3_1.Utilities;

import a1qa.task3_1.Utilities.Elements.BaseElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Browser {

    static WebDriver driver = BaseElement.driver;

    public static void visit(String url) {
        driver.get(url);
    }

    public static Alert switchToAlert(){
        return driver.switchTo().alert();
    }

    public static void switchTab() {
        String firstTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(firstTab)) {
                driver.switchTo().window(tab);
            }
        }
    }

    public static void switchToFrame(WebElement element){
        driver.switchTo().frame(element);
    }

    public static void switchToFrame(int index){
        driver.switchTo().frame(index);
    }

    public static void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }
}
