import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
public class Challenge2 {
    public static void main(String[] args) throws Exception {

        try(BufferedReader reader = new BufferedReader(new FileReader("week2\\src\\covid_and_trade.csv"))){
            System.out.println("That file exists!");
            String firstLine = reader.readLine();
            String[] headers = firstLine.split(",");
            
            String line;
            List<List<String>> data = new ArrayList<>();
            
            while((line = reader.readLine())!= null){
                List<String>fields = QuotedFieldParser.parseQuotedLine(line);
                if (data.isEmpty()) {
                    for (int i = 0; i < fields.size(); i++) {
                        data.add(new ArrayList<>());
                    }
                }
                for (int i = 0; i < fields.size(); i++) {
                    data.get(i).add(fields.get(i));
                }
            }

            for(int i = 0; i < data.size(); i++){
                System.out.println("The unique values for the column " + headers[i] + " are: ");
                data.get(i).stream()
                            .distinct()
                            .forEach(n -> System.out.print(n + " "));
                System.out.println();
            }
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