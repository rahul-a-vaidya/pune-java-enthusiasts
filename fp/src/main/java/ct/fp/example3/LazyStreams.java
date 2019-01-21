package ct.fp.example3;

import java.util.Arrays;
import java.util.List;

public class LazyStreams {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Rahul", "Nikhil", "Vijay", "Amit", "Ashwini", "Ishan", "Chinmay",
                                            "Tejas", "Kavita", "Rajeshwari", "Ziyad", "Priya", "Madhura");

        // return the first name smaller than 5 letters in upercase

        final String name = names.stream()
                                 .filter(s -> StringUtil.length(s) < 5)
                                 .map(s -> StringUtil.toUpper(s))
                                 .findFirst()
                                 .get();

        System.out.println("name = " + name);
    }
}
