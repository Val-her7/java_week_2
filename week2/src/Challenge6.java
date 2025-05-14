import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Challenge6 {
    public static void main(String[] args) throws Exception{

        try(BufferedReader reader = new BufferedReader(new FileReader("week2\\src\\covid_and_trade.csv"))){

            reader.readLine();
            String line;
            List<CsvRows> data = new ArrayList<>();

            while((line = reader.readLine()) != null){
                List<String> row = QuotedFieldParser.parseQuotedLine(line);
                data.add(new CsvRows(row.get(0), row.get(1), row.get(4), row.get(5), row.get(6), row.get(8)));
            }

            //using method max() of the streaming api
            data.stream()
                    .filter(d -> d.getDirection().equals("Exports")
                        && d.getYear().equals("2019")
                        && d.getCountry().equals("China")
                        && d.getCommodity().equals("All")
                        && d.getTransportMode().equals("All"))
                    .max(Comparator.comparingLong(d -> Long.parseLong(d.getValue())))
                    .ifPresent(maxValue -> System.out.println(maxValue));

            //by sorting and finding the highest value
            data.stream()
                    .filter(d -> d.getDirection().equals("Exports")
                        && d.getYear().equals("2019")
                        && d.getCountry().equals("China")
                        && d.getCommodity().equals("All")
                        && d.getTransportMode().equals("All"))
                    .sorted(Comparator.comparingLong(d -> Long.parseLong(d.getValue())))
                    .reduce((first, second) -> second)
                    .ifPresent(maxValue -> System.out.println(maxValue));

            //extra: output the sum instead of the hihghest value
            long totalExports = data.stream()
                    .filter(d -> d.getDirection().equals("Exports")
                        && d.getYear().equals("2019")
                        && d.getCountry().equals("China")
                        && d.getCommodity().equals("All")
                        && d.getTransportMode().equals("All"))
                    .mapToLong(d -> Long.parseLong(d.getValue()))
                    .sum();
            System.out.println("Total exports for China in 2019: " + totalExports);
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