package me.demo.algorithm.sort;

import me.demo.algorithm.Benchmark;

import static me.demo.algorithm.sort.Util.*;

/**
 * 快速排序
 * 1. 从数组中挑选一个元素，作为基准（pivot）
 * 2-1. （wiki描述）重新排序数组，所有比基准小的元素摆在基准前面，比基准大的放在后面。在分区结束后，这个基准就位于数组的中间位置。这个操作称为分区（partition）
 * <p>
 * 3. 递归地把小于基准的**子数组**和的**子数组**排序
 * <p>
 * 算法第四版参考：https://algs4.cs.princeton.edu/23quicksort/Quick.java.html
 */
public class QuickSort {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) { // 当 a 为空数组时，lo = 0，hi = -1. 当 a 为 1 个元素数组时，lo = 0，hi = 0,分区操作不能处理 0 个或 1 个元素的情况，应该提前终止
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * 分区操作
     * （当前算法描述）从前往后比较基准与元素，直到元素大于基准或 i > hi 从后往前比较基准与元素，直到元素小于基准或 j > lo
     *
     * @param a  待排序数组
     * @param lo 数组开始索引
     * @param hi 数组结束索引
     * @return 分区操作后，中间元素索引
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable pivot = a[lo]; // 取基准为数组或子数组第一个元素
        while (true) {
            while (less(a[++i], pivot)) { // 如果左边的元素都比基准小，则递增 i 并检查 i 是否达到 hi（位置2）
                if (i == hi) {
                    break;
                }
            }
            while (less(pivot, a[--j])) { // 如果右边的元素都比基准大，则递减 j 并检查 j 是否达到 lo （位置1）
                if (j == lo) { // 这个检查是多余的，因为 j 最多达到 0 且 pivot 的索引为 0 不会比自己小
                    break;
                }
            }

            if (i > j) {
                // System.out.println(i + " | " + j);
            }
            if (i == j) {
                //System.out.println("equal " + i + " | " + j);
            }
            if (i >= j) { // 什么时候 i 会大于 j？在顺序排列数组 [1, 2, 3] 中，i 的初始值为 0 在位置2 处会增加 1 ，而 j 会在位置1 处减小到 0，此时 i > j
                // 什么时候 i == j？在逆序排列数组 [3， 2， 1] 中，i 的初始值为 0 在位置2 处会增加 1 ，而 j 会在位置1 处减小到 0，此时 i > j
                break;
            }
            exch(a, i, j); // 当 i 在较大的位置停止时，j在较小的位置停止时，交换 i 和 j 上的值
        }
        exch(a, lo, j);
        return j;
    }

    /**
     * （wiki描述）重新排序数组，所有比基准小的元素摆在基准前面，比基准大的放在后面。在分区结束后，这个基准就位于数组的中间位置。这个操作称为分区（partition）
     */
    private static int partition2(Comparable[] a, int lo, int hi) {
        int i = lo;
        int lt = lo;
        int gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            if (less(a[i], v)) {
                exch(a, i++, lt++);
            } else if (less(v, a[i])) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }
        return lt;
    }

    public static void main(String[] args) {
        Benchmark.start(QuickSort::sort);
    }

}
