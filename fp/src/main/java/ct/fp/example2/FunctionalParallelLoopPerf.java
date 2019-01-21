package ct.fp.example2;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class FunctionalParallelLoopPerf {

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 5)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Measurement(iterations = 5)
    public int testSerial() {

        Random random = new Random();

        IntSupplier supplier = ()-> random.nextInt(1_000_000);

        int[] randomArray = IntStream.generate(supplier).limit(50000).toArray();

        IntPredicate isEven = x -> (x & 1) == 0;

        return filterMapReduce(randomArray, isEven);
    }

    private static int filterMapReduce(int[] arr, IntPredicate p) {
        return Arrays.stream(arr)
                .filter(p)
                .map(x -> x + 5)
                .reduce(0, (a,b) -> a + b);
    }

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 5)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Measurement(iterations = 5)
    public int testParallel() {

        Random random = new Random();

        IntSupplier supplier = ()-> random.nextInt(1_000_000);

        int[] randomArray = IntStream.generate(supplier).limit(50000).toArray();

        IntPredicate isEven = x -> (x & 1) == 0;

        return filterMapReduceParallel(randomArray, isEven);
    }

    private static int filterMapReduceParallel(int[] arr, IntPredicate p) {
        return Arrays.stream(arr)
                .parallel()
                .filter(p)
                .map(x -> x * 5)
                .reduce(0, (a,b) -> a + b);
    }
}
