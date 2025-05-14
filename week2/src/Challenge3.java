import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Challenge3 {
    public static void main(String[] args) throws Exception {

        try(BufferedReader reader = new BufferedReader(new FileReader("week2\\src\\covid_and_trade.csv"))){

            System.out.println("That file exists!");
            reader.readLine();
            String line;

            List<CsvRows> data = new ArrayList<>();
            String searchedCountry = "All";

            while((line = reader.readLine())!= null){
                List<String> row = QuotedFieldParser.parseQuotedLine(line);
                data.add(new CsvRows(row.get(0), row.get(1), row.get(4), row.get(8)));
            }
            
            data.stream()
                    .filter(d -> (d.getDirection().equals("Imports")
                        || d.getDirection().equals("Exports"))
                        && d.getYear().equals("2016")
                        && d.getCountry().equals(searchedCountry))
                    .forEach(n -> System.out.println(n.getValue()));
            
            System.out.println(CsvRows.numberOfRows);
        }
        catch(FileNotFoundException error){
            System.out.println("Sorry, we cannot locate file location");
        }
        catch(IOException error){
            System.out.println("Somethong went wrong");
            error.printStackTrace();
        }
    }
}