package me.demo.algorithm.sort;

import static me.demo.algorithm.sort.Util.exch;
import static me.demo.algorithm.sort.Util.less;

public class Insertion {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

}
