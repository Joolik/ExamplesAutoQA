package utils;

import java.util.Base64;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HelperFiles {

    public static String convertFileToBase64(String fullFileName) {
        String result = null;
        try {
            result = Base64.getEncoder().encodeToString(org.apache.commons.io.FileUtils.readFileToByteArray(new File(fullFileName)));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }


    public static  List<Map<String, String>> getRecordsFromCSVFile(String fullFileName) {
        List<Map<String, String>> listOfMap = new ArrayList<>();
        Reader reader = null;
        try {
            reader = new FileReader(fullFileName);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(reader);
            for (CSVRecord record : records) {
                listOfMap.add(record.toMap());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return listOfMap;
        }
    }
}
