package ct.fp.example1;

import java.util.stream.IntStream;

public class FunctionalLoop {

    public static void main(String[] args) {

        int[] arr = { 1,2,3,4,5,6,7,8,9,1,3,4,5,6,7,8,3,4,7,8,9};

        System.out.println("sum = " + IntStream.of(arr)
                                        .filter(x -> x >= 5)
                                        .distinct()
                                        .sum());
    }
}
