import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // In Java, public static final is used to create constants.
        // When you create an enum, Java automatically makes each value a public static
        // final instance.
        // So, enums are actually just predefined constants of a specific type.

        Scanner scanner = new Scanner(System.in);
        System.out.println("What day is it? ");
        String input = scanner.nextLine().toUpperCase();
        Days day = Days.valueOf(input);
        switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("It's a weekday");
            case SATURDAY, SUNDAY -> System.out.println("It's the weekend");
        }
        scanner.close();

        // Final
        // to create constants (uppercase and _ to separate words)
        // with class -> cannot extend the class
        // with method -> cannot override method in child class
        // with variable -> can only assign one time
        final Dog myDog = new Dog();
        // myDog = new Dog(); cannot reassign

        // Stream -> The Stream API is used to process collections of objects (List,
        // Set, ...)
        // Enable us to perform operations like filtering, mapping, reducing, and
        // sorting.
        // Streams don’t change the original data structure, they only provide the
        // result as per the pipelined methods.
        // Each intermediate operation is lazily executed and returns a stream as a
        // result, hence, various intermediate operations can be pipelined. Terminal
        // operations mark the end of the stream and return the result.
        List<Integer> nums = Arrays.asList(1, 9, 3, 5, 2, 7, 6, 4);
        Stream<Integer> data = nums.stream();
        Stream<Integer> squaredData = data.map(n -> n * n);
        squaredData.forEach(n -> System.out.println(n));

        List<String> names = Arrays.asList("Valentin", "Christophe", "Nicolas", "Anthony");
        names.stream()
                .sorted()
                .map(String::toUpperCase)
                .forEach(name -> System.out.println(name));

        // max() returns an Optional, which can be empty if no element matches the
        // criteria.
        // ifPresent(): Performs an action if a value is present.
        // orElse(): Returns a default value if the Optional is empty.
        // orElseThrow(): Throws an exception if the Optional is empty.
        // In summary, you handle the Optional in different ways depending on whether
        // you simply want to check if a value is present, provide a default value, or
        // throw an exception if the value is absent.

        // Functionnal interface -> only one abstract method
        // Java 8 has many built-in functional interface classes in the java.util.function
        //          Consumer<T>: A functional interface that accepts an object and returns nothing.
    //              Producer<T>: A functional interface that accepts nothing and returns an object.
        //          Predicate<T>: A functional interface that accepts an object and returns a boolean.
        //          Function<T, R>: A functional interface that accepts an object and returns another object.
        Predicate<String> predicate = new Predicate<String>() {

            @Override
            public boolean test(String t) {
                if (t.length() > 5) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        System.out.println(predicate.test("Valentin"));

        Function<Integer, Integer> func = new Function<Integer,Integer>() {
            
            @Override
            public Integer apply(Integer i) {
                return i * i;
            }
        };
        System.out.println(func.apply(7));

        // with lambda expression
        Predicate<String> predicateWithLambda = t -> t.length() > 5;
        System.out.println(predicateWithLambda.test("Val"));
        Function<Integer, Integer> functionWithLambda = t -> t * t;
        System.out.println(functionWithLambda.apply(8));

        /*
         * Without a functional interface, you must write all the logic inside the
         * method, so it's not reusable or flexible.
         * 
         * With a functional interface like Predicate, you can pass logic as a
         * parameter, using a lambda expression or method reference. This makes your
         * code more generic and reusable.
         * 
         * It allows you to change the behavior of a method without rewriting it, just
         * by passing different conditions.
         */
        System.out.println(customFilter(nums, t -> t%2==0));
        System.out.println(customFilter(names, t ->t.length() > 7));
        System.out.println(customMap(nums, t -> t * t));
        System.out.println(customMap(names, t -> t.toUpperCase()));
        System.out.println(customMap(names, t -> t.length()));
    }
    //Create simple stream with functionnal interface
    //own filter with Predicate
    public static <T> List<T> customFilter(List<T> list, Predicate<T> pred){
    List<T> filteredList = new ArrayList<>();
    for(T element: list){
        if(pred.test(element)){
            filteredList.add(element);
        }
    }
    return filteredList;
    }

    //own map with Function
    public static <T, R> List<R> customMap(List<T> list, Function<T, R> func){
        List<R> customList = new ArrayList<>();
        for(T element: list){
            customList.add(func.apply(element));
        }
        return customList;
    } 
}