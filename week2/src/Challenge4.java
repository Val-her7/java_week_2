import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Challenge4 {
    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(System.in);
        System.out.print("What is the exchange rate? ");
        while(!scanner.hasNextDouble()){
            System.out.print("Please enter a valid exchange rate! ");
            scanner.next();
        }
        Double exchangeRate = scanner.nextDouble();    
        
        try(BufferedReader reader = new BufferedReader(new FileReader("week2\\src\\covid_and_trade.csv"))){

            System.out.println("That file exists!");
            reader.readLine();
            
            String line;
            List<CsvRows> data = new ArrayList<>();

            while((line = reader.readLine()) != null){
                List<String> row = QuotedFieldParser.parseQuotedLine(line);
                data.add(new CsvRows(row.get(0), row.get(1), row.get(4),row.get(7), row.get(8)));
            }

            data.stream()
                    .filter(d -> (d.getDirection().equals("Imports")
                        || d.getDirection().equals(("Exports")))
                        && d.getYear().equals("2016")
                        && d.getMeasure().equals("$"))
                    .map(d -> Double.parseDouble(d.getValue()) * exchangeRate)
                    .forEach(n -> System.out.println(n));

        }
        catch(FileNotFoundException e){
            System.out.println("Sorry, we cannot locate file location");
        }
        catch(IOException e){
            System.out.println("Somethong went wrong");
            e.printStackTrace();
        }

        scanner.close();
    }
}
