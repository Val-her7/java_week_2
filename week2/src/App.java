import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("What day is it? ");
        String input = scanner.nextLine().toUpperCase();
        Days day = Days.valueOf(input);
        switch(day){
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("It's a weekday");
            case SATURDAY, SUNDAY -> System.out.println("It's the weekend");
        }
        scanner.close();
        }
}