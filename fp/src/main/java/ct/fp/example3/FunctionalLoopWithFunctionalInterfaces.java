package ct.fp.example3;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalLoopWithFunctionalInterfaces {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("rahul", "nikhil", "vijay", "ashwini", "tanuja", "ishan", "chinmay",
                "tejas", "kavita", "rajeshwari", "ziyad", "priya", "madhura", "rahul");

        Function<String, String> capitalize = String::toUpperCase; //method reference
        Function<String, String> trimToThree = x -> x.substring(0, 3);

        // composite function
        Function<String, String> createCode = capitalize.andThen(trimToThree);

        Set<String> codes = names.stream()
                                  .map(createCode)
                                  .collect(Collectors.toSet());

        System.out.println("codes = " + String.join(",", codes)); 
    }
}
