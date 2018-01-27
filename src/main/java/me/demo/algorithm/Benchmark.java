package me.demo.algorithm;

import lombok.val;
import org.apache.commons.lang3.time.StopWatch;

import java.util.function.Consumer;

import static me.demo.algorithm.sort.Util.integerArray;
import static me.demo.algorithm.sort.Util.sorted;

public class Benchmark {

    public static void start(Consumer<Comparable[]> task, int size) {
        val integers = integerArray(size);
        val watch = StopWatch.createStarted();
        task.accept(integers);
        watch.stop();
        System.out.println(watch.getTime());
        sorted(integers);
    }

    public static void start(Consumer<Comparable[]> task) {
        start(task, 100000);
    }
}
