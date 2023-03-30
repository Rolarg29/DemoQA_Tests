package a1qa.task2_1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static a1qa.task2_1.BaseUtil.*;

public class SearchPage {

    // Elements
    public static final By searchBox = By.id("store_nav_search_term");
    public static final String gameName = "Dota 2";
    public static final By searchButton = By.cssSelector("img[src='https://store.akamai.steamstatic.com/public/images/blank.gif']");
    public static final String searchResultPage = "https://store.steampowered.com/search/?term=Dota+2";
    public static final By innerSearchBox = By.xpath("//div[@class='searchbar_left']//input[@id='term']");
    public static final By firstResultName = By.xpath("//div[@id='search_resultsRows']//a[1]//div[@class='responsive_search_name_combined']//div[1]//span[@class='title']");
    public static final By secondResultName = By.xpath("//div[@id='search_resultsRows']//a[2]//div[@class='responsive_search_name_combined']//div[1]//span[@class='title']");


    //Data from results (1)
    public static final By searchResultName = By.xpath("//span[@class='title']");
    public static final By searchResultPlatformOne = By.xpath("//span[contains(@class,'platform_img')]");
    public static final By searchResultPlatformTwo = By.xpath("//span[contains(@class,'platform_img')][2]");
    public static final By searchResultPlatformThree = By.xpath("//span[contains(@class,'platform_img')][3]");
    public static String[] platformName = {replaceAtt(searchResultPlatformOne), replaceAtt(searchResultPlatformTwo), replaceAtt(searchResultPlatformThree)};
    public static final By searchResultReleaseDate = By.xpath("//div[contains(@class,'search_released')]");
    public static final By searchResultReview = By.xpath("//span[contains(@class,'search_review_summary')]");
    public static final By searchResultPrice = By.xpath("//div[contains(@class,'search_price')]");

    //Data from results (2)
    public static final By searchResultName2 = By.xpath("//a[2]//span[@class='title']");
    public static final By searchResultPlatform2 = By.xpath("//a[2]//span[contains(@class,'platform_img')]");
    public static final By searchResultReleaseDate2 = By.xpath("//a[2]//div[contains(@class,'search_released')]");
    public static final By searchResultReview2 = By.xpath("//a[2]//span[contains(@class,'search_review_summary')]");
    public static final By searchResultPrice2 = By.xpath("//a[2]//div[contains(@class,'search_price')]");


    public static JSONArray datos = new JSONArray();

    public static void gameData() {
        JSONObject result1 = new JSONObject();
        result1.put("name", getText(searchResultName));
        result1.put("platform", Arrays.toString(platformName));
        result1.put("releaseDate", getText(searchResultReleaseDate));
        result1.put("reviewSummaryResult", attribute(searchResultReview, "data-tooltip-html").replaceAll("<br>", " "));
        result1.put("price", getText(searchResultPrice));

        JSONObject result2 = new JSONObject();
        result2.put("name", getText(searchResultName2));
        result2.put("platform", replaceAtt(searchResultPlatform2));
        result2.put("releaseDate", getText(searchResultReleaseDate2));
        result2.put("reviewSummaryResult", attribute(searchResultReview2, "data-tooltip-html").replaceAll("<br>", " "));
        result2.put("price", getText(searchResultPrice2));

        datos.add(result1);
        datos.add(result2);
    }

        // Escribir los datos en un archivo JSON
    public static void jsonCreate(){
        try (FileWriter fileWriter = new FileWriter("gameResults.json")) {
            fileWriter.write(datos.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean compareData() {
        // Leer el archivo JSON
        JSONArray jsonArray = null;
        try {
            JSONParser parser = new JSONParser();
            jsonArray = (JSONArray) parser.parse(new FileReader("gameResults.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean firstMatches = false;
        boolean secondMatches = false;

        //New search data -> Data 2 Player Profiles
        String firstName = getText(searchResultName);
        String firstPlatform = replaceAtt(searchResultPlatformOne);
        String firstReleaseDate = getText(searchResultReleaseDate);
        String firstReview = attribute(searchResultReview, "data-tooltip-html").replaceAll("<br>", " ");
        String firstPrice = getText(searchResultPrice);

        //Dota 2
        String secondName = getText(searchResultName2);
        By secondResultPlatformOne = By.xpath("//a[2]//span[contains(@class,'platform_img')]");
        By secondResultPlatformTwo = By.xpath("//a[2]//span[contains(@class,'platform_img')][2]");
        By secondResultPlatformThree = By.xpath("//a[2]//span[contains(@class,'platform_img')][3]");
        String[] secondPlatform = {replaceAtt(secondResultPlatformOne), replaceAtt(secondResultPlatformTwo), replaceAtt(secondResultPlatformThree)};
        String secondReleaseDate = getText(searchResultReleaseDate2);
        String secondReview = attribute(searchResultReview2, "data-tooltip-html").replaceAll("<br>", " ");
        String secondPrice = getText(searchResultPrice2);

        assert jsonArray != null;
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
            String name = (String) jsonObject.get("name");
            String platform = (String) jsonObject.get("platform");
            String releaseDate = (String) jsonObject.get("releaseDate");
            String reviewSummaryResult = (String) jsonObject.get("reviewSummaryResult");
            String price = (String) jsonObject.get("price");

            //comparison between first object and new web data
        if ((firstName.equals(name) || secondName.equals(name)) &&
            (Arrays.toString(secondPlatform).equals(platform) || firstPlatform.equals(platform)) &&
            (secondReleaseDate.equals(releaseDate) || firstReleaseDate.equals(releaseDate)) &&
            (secondReview.equals(reviewSummaryResult) || firstReview.equals(reviewSummaryResult)) &&
            (secondPrice.equals(price)) || firstPrice.equals(price)) {
            // Los datos coinciden
//            System.out.println("Datos coinciden para el primer objeto");
            firstMatches = true;
        } else {
            // Los datos no coinciden
            System.out.println("Datos no coinciden para el primer objeto");
        }

        JSONObject jsonObject2 = (JSONObject) jsonArray.get(1);
            name = (String) jsonObject2.get("name");
            platform = (String) jsonObject2.get("platform");
            releaseDate = (String) jsonObject2.get("releaseDate");
            reviewSummaryResult = (String) jsonObject2.get("reviewSummaryResult");
            price = (String) jsonObject2.get("price");

        //comparison between second object and new web data
        if ((firstName.equals(name) || secondName.equals(name)) &&
                (Arrays.toString(secondPlatform).equals(platform) || firstPlatform.equals(platform)) &&
                (secondReleaseDate.equals(releaseDate) || firstReleaseDate.equals(releaseDate)) &&
                (secondReview.equals(reviewSummaryResult) || firstReview.equals(reviewSummaryResult)) &&
                (secondPrice.equals(price)) || firstPrice.equals(price)) {
            // Los datos coinciden
//            System.out.println("Datos coinciden para el primer objeto");
            secondMatches = true;
        } else {
            // Los datos no coinciden
            System.out.println("Datos no coinciden para el primer objeto");

        }

        return firstMatches = secondMatches = true;
    }

}