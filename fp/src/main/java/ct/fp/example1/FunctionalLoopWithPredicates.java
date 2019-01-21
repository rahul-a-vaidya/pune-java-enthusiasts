package ct.fp.example1;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FunctionalLoopWithPredicates {

    public static void main(String[] args) {

        int[] arr = { 1,2,3,4,5,6,7,8,9,1,3,4,5,6,7,8,3,4,7,8,9};

        IntPredicate greaterThanFour = x -> x < 5;
        System.out.println("sum = " + filterWithPredicateAndSum(arr, greaterThanFour));

        IntPredicate lessThanSeven = x -> x < 7;
        System.out.println("sum = " + filterWithPredicateAndSum(arr, lessThanSeven));
    }

    private static int filterWithPredicateAndSum(int[] arr, IntPredicate p) {
        return IntStream.of(arr).filter(p).distinct().sum();
    }


}
