package a1qa.task2_1.patterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    private WebDriver driver;

    // examples
    private final By searchBox = By.name("term");
    private final By searchButton = By.cssSelector("button[type='submit']");
    private final By searchResult = By.cssSelector("a.search_result_row");
    private final By searchResultName = By.cssSelector("span.title");
    private final By searchResultPlatform = By.cssSelector("span.search_name > b");
    private final By searchResultReleaseDate = By.cssSelector("div.search_released");
    private final By searchResultDescription = By.cssSelector("div.search_name > span");
    private final By searchResultPrice = By.cssSelector("div.search_price > div > div > span");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String searchTerm) {
        WebElement searchBoxElement = driver.findElement(searchBox);
        searchBoxElement.sendKeys(searchTerm);
        searchBoxElement.submit();
    }

    public void clickSearchResult(int index) {
        List<WebElement> searchResults = driver.findElements(searchResult);
        if (index < searchResults.size()) {
            searchResults.get(index).click();
        } else {
            throw new IllegalArgumentException("El índice de resultado de búsqueda está fuera de rango");
        }
    }

    public String getSearchResultName(int index) {
        List<WebElement> searchResults = driver.findElements(searchResult);
        if (index < searchResults.size()) {
            WebElement searchResultElement = searchResults.get(index);
            return searchResultElement.findElement(searchResultName).getText();
        } else {
            throw new IllegalArgumentException("El índice de resultado de búsqueda está fuera de rango");
        }
   }
}
