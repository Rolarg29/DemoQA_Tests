package a1qa.task2_1;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigDataFromJSONFile {

    public class ConfigReader {
        public static JSONObject readConfig(String configFilePath) throws IOException, ParseException {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(configFilePath));
            return (JSONObject) obj;
        }
    }
}
