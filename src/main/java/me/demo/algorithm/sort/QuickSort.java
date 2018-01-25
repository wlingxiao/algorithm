package me.demo.algorithm.sort;

import static me.demo.algorithm.sort.Util.exch;
import static me.demo.algorithm.sort.Util.less;

/**
 * 快速排序
 * 1. 从数组中挑选一个元素，作为基准（pivot）
 * 2-1. （wiki描述）重新排序数组，所有比基准小的元素摆在基准前面，比基准大的放在后面。在分区结束后，这个基准就位于数组的中间位置。这个操作称为分区（partition）
 * <p>
 * 3. 递归地把小于基准的**子数组**和的**子数组**排序
 */
public class QuickSort {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi < lo) {
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
            while (less(a[++i], pivot) && i <= hi) {
            }
            while (less(pivot, a[--j]) && j >= lo) {
            }
            if (i >= j) {
                break;
            }
        }
        exch(a, lo, j); // lo 为基准索引，j 为中间位置索引
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

}
