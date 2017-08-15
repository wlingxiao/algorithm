package me.demo.algorithm.sort;

import static me.demo.algorithm.sort.Util.exch;
import static me.demo.algorithm.sort.Util.less;

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

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v) && i <= hi) {
            }
            while (less(v, a[--j]) && j >= lo) {
            }
            if (i >= j) {
                break;
            }
        }
        exch(a, lo, j);
        return j;
    }

}
