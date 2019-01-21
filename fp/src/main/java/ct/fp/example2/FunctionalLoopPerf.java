package ct.fp.example2;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FunctionalLoopPerf {

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 5)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Measurement(iterations = 5)
    public int testWithPredicate() {

        int[] arr = { 1,2,3,4,5,6,7,8,9,1,3,4,5,6,7,8,3,4,7,8,9};

        IntPredicate greaterThanFour = x -> x > 4;
        return filterWithPredicateAndSum(arr, greaterThanFour);
    }

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 5)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Measurement(iterations = 5)
    public int testWithDistinctBeforeFilter() {

        int[] arr = { 1,2,3,4,5,6,7,8,9,1,3,4,5,6,7,8,3,4,7,8,9};

        return filterWithConditionsAndSum(arr);
    }

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 5)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Measurement(iterations = 5)
    public int testWithFilterBeforeDistinct() {

        int[] arr = { 1,2,3,4,5,6,7,8,9,1,3,4,5,6,7,8,3,4,7,8,9};

        return filterFirstWithConditionsAndSum(arr);
    }



    private static int filterWithConditionsAndSum(int[] arr) {
        return IntStream.of(arr)
              .distinct()
              .filter(x -> x >= 5)
                .sum();
    }

    private static int filterFirstWithConditionsAndSum(int[] arr) {
        return IntStream.of(arr)
                .filter(x -> x >= 5)
                .distinct()
                .sum();
    }

    private static int filterSecondWithConditionsAndSum(int[] arr) {
        return Arrays.stream(arr)
                .filter(x -> x >= 5)
                .distinct()
                .sum();
    }

    private static int filterWithPredicateAndSum(int[] arr, IntPredicate p) {
        return IntStream.of(arr).filter(p).distinct().sum();
    }

}
