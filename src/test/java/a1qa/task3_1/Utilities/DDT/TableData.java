package a1qa.task3_1.Utilities.DDT;

import org.apache.commons.csv.CSVFormat;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class TableData {

    public TableData() {
    }

    @DataProvider(name = "tableData")
    public static Object[][] readCSV() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\roliz\\IdeaProjects\\r.ramirez\\src\\test\\java\\a1qa\\task3_1\\Utilities\\DDT\\tableData.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

        List<CSVRecord> records = csvParser.getRecords();
        int rowCount = records.size();
        int colCount = records.get(0).size();

        Object[][] data = new Object[rowCount][colCount];
        for (int i = 1; i < rowCount; i++) {
            CSVRecord record = records.get(i);
            for (int j = 0; j < colCount; j++) {
                data[i][j] = record.get(j);
            }
        }
        return data;
    }
     public static Object[][] data;

    static {
        try {
            data = readCSV();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String userNumber1 = (String) data[1][0];
    public static String firstName1 = (String) data[1][1];
    public static String lastname1 = (String) data[1][2];
    public static String email1 = (String) data[1][3];
    public static String age1 = (String) data[1][4];
    public static String salary1 = (String) data[1][5];
    public static String department1 = (String) data[1][6];

    public static String userNumber2 = (String) data[2][0];
    public static String firstName2 = (String) data[2][1];
    public static String lastname2 = (String) data[2][2];
    public static String email2 = (String) data[2][3];
    public static String age2 = (String) data[2][4];
    public static String salary2 = (String) data[2][5];
    public static String department2 = (String) data[2][6];



}
