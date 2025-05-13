import java.util.Scanner;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        //In Java, public static final is used to create constants. 
        //When you create an enum, Java automatically makes each value a public static final instance. 
        //So, enums are actually just predefined constants of a specific type.
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("What day is it? ");
        String input = scanner.nextLine().toUpperCase();
        Days day = Days.valueOf(input);
        switch(day){
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("It's a weekday");
            case SATURDAY, SUNDAY -> System.out.println("It's the weekend");
        }
        scanner.close();

        //Final
        //to create constants (uppercase and _ to separate words)
        // with class -> cannot extend the class
        //with method -> cannot override method in child class
        //with variable -> can only assign one time
        final Dog myDog = new Dog();
        //myDog = new Dog();  cannot reassign


        //Stream -> The Stream API is used to process collections of objects (List, Set, ...)
        //          Enable us to perform operations like filtering, mapping, reducing, and sorting.
        //          Streams don’t change the original data structure, they only provide the result as per the pipelined methods.
        //          Each intermediate operation is lazily executed and returns a stream as a result, hence, various intermediate operations can be pipelined. Terminal operations mark the end of the stream and return the result.
        List<Integer> nums = Arrays.asList(1,9,3,5,2,7);
        Stream<Integer> data = nums.stream();
        Stream<Integer> squaredData = data.map(n -> n *n);
        squaredData.forEach(n -> System.out.println(n));

        List<String> names = Arrays.asList("Valentin", "Christophe", "Nicolas", "Anthony");
        names.stream()
                    .sorted()
                    .map(String::toUpperCase)
                    .forEach(name -> System.out.println(name));
        }
}