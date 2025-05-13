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
            String line;
            List<List<String>> data = new ArrayList<>();
            String searchedCountry = "All";

            while((line = reader.readLine())!= null){
                List<String> row = QuotedFieldParser.parseQuotedLine(line);
                data.add(row);
            }
            
            data.stream()
                    .filter(d -> (d.get(0).equals("Imports")
                        || d.get(0).equals("Exports"))
                        && d.get(1).equals("2016")
                        && d.get(4).equals(searchedCountry))
                    .forEach(n -> System.out.println(n));
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