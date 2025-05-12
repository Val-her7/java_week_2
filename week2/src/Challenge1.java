import java.util.Scanner;

public class Challenge1 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length and the unit (m, cm or mm): ");
        String length = scanner.nextLine();
        String measureLength = length.replaceAll("[^a-zA-Z]", "");
        String valueLength = length.replaceAll("[^0-9]", "");
    
        System.out.print("Enter the witdh and the unit (m, cm or mm): ");
        String width = scanner.nextLine();
        String measureWidth = width.replaceAll("[^a-zA-Z]", "");
        String valueWidth = width.replaceAll("[^0-9]", "");

        try{
            double lengthInMeters = Measurements.valueOf(measureLength.toUpperCase()).convertToMeter(Double.parseDouble(valueLength));
            double widthInMeters = Measurements.valueOf(measureWidth.toUpperCase()).convertToMeter(Double.parseDouble(valueWidth));
            System.out.printf("The surface in square meters is equal to %.2f ", lengthInMeters * widthInMeters);
        }
        catch(IllegalArgumentException e){
            System.out.println("Invalid unit measurement!");
        }
        finally{
            scanner.close();
        }
    }
}
