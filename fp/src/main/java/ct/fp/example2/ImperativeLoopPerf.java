package ct.fp.example2;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/*
 This program takes an array of integers, weeds out numbers lesser than 5,
 eliminates duplicates and returns the sum of the numbers that remain
 */
public class ImperativeLoopPerf {

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 5)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Measurement(iterations = 5)
    public int test() {

        int[] arr = { 1,2,3,4,5,6,7,8,9,1,3,4,5,6,7,8,3,4,7,8,9};

        // need sum of sorted array of numbers greater than45 (with duplicates eliminated)
        return filterWithPredicateAndSum(arr);
    }

    private static int filterWithPredicateAndSum(int[] arr) {
        // first sort the array
        Arrays.sort(arr);

        int sum = 0;
        int dup = 0;
        for (int i : arr) {
            if (i < 5 || (i == dup)) {
                continue;
            }
            else {
                sum += i;
                dup = i;
            }
        }

        return sum;
    }
}
