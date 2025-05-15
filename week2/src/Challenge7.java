import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

public class Challenge7 {

    public static String cleanDate(String date){
        return date.substring(3, 5);
    }

    public static void printResults(Map<String, Long> exports2019, Map<String, Long> exports2020 ){
        System.out.println("------------------------------------");
        System.out.println("Month | Value(2019) | Value(2020)");
        System.out.println("------------------------------------");
        for(String key2019: exports2019.keySet()){
            for(String key2020: exports2020.keySet()){
                if(key2019.equals(key2020)){
                    System.out.println(key2019 + " | " + exports2019.get(key2019) + " | " + exports2020.get(key2020));
                }
            }
        }
        System.out.println("------------------------------------");
    }
    public static void main(String[] args) throws Exception {

        record CovidData(String direction, String year, String date, String country, String value) {
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("week2\\src\\covid_and_trade.csv"))) {

            reader.readLine();
            String line;
            List<CovidData> data = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                List<String> row = QuotedFieldParser.parseQuotedLine(line);
                data.add(new CovidData(row.get(0), row.get(1), cleanDate(row.get(2)), row.get(4), row.get(8)));
            }

            //data 2019
            LinkedHashMap<String, Long> exportsIn2019EuropaByMonth = data.stream()
                    .filter(d -> d.direction().equals("Exports")
                    && d.year().equals("2019")
                    && d.country().equals("European Union (27)"))
                    .collect(Collectors.groupingBy(CovidData::date, LinkedHashMap::new, Collectors.summingLong(c -> Long.parseLong(c.value()))));
            
            //data 2020
            LinkedHashMap<String, Long> exportsIn2020EuropaByMonth = data.stream()
                    .filter(d -> d.direction().equals("Exports")
                    && d.year().equals("2020")
                    && d.country().equals("European Union (27)"))
                    .collect(Collectors.groupingBy(CovidData::date, LinkedHashMap::new, Collectors.summingLong(c -> Long.parseLong(c.value()))));

            printResults(exportsIn2019EuropaByMonth, exportsIn2020EuropaByMonth);

        } catch (FileNotFoundException e) {
            System.out.println("Sorry, we cannot locate file location");
        } catch (IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
}