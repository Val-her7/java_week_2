import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Challenge5 {
    public static void main(String[] args) throws Exception{

        try(BufferedReader reader = new BufferedReader(new FileReader("week2\\src\\covid_and_trade.csv"))){

            reader.readLine();
            String line;
            List<CsvRows> data = new ArrayList<>();

            while((line = reader.readLine()) != null){
                List<String> row = QuotedFieldParser.parseQuotedLine(line);
                data.add(new CsvRows(row.get(0), row.get(1), row.get(4), row.get(5), row.get(6), row.get(8)));
            }

            data.stream()
                    .filter(d -> d.getDirection().equals("Imports")
                        && d.getYear().equals("2018")
                        && d.getCountry().equals("All")
                        && d.getCommodity().equals("All")
                        && d.getTransportMode().equals("All"))
                    .sorted(Comparator.comparingLong(d -> Long.parseLong(d.getValue())))
                    .forEach(printableResult ->System.out.println(printableResult));
        }
        catch(FileNotFoundException e){
            System.out.println("Sorry, we cannot locate file location");
        }
        catch(IOException e){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
}