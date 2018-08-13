package me.demo.algorithm.sort;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static me.demo.algorithm.sort.Util.integerArray;

public class SortBenchmark {

    @State(Scope.Thread)
    public static class Data {
        public Integer[] integers;

        @Setup(Level.Iteration)
        public void setUp() {
            integers = integerArray(10000);
        }
    }


    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void testBubbleSort(Data data) {
        BubbleSort.sort(data.integers);
    }

    @Benchmark
    @Warmup(iterations = 1)
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Measurement(iterations = 5, time = 5)
    public void testQuickSort(Data data) {
        QuickSort.sort(data.integers);
    }

    @Benchmark
    @Warmup(iterations = 1)
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Measurement(iterations = 5, time = 5)
    public void testMergeSort(Data data) {
        Merge.sort(data.integers);
    }

}
