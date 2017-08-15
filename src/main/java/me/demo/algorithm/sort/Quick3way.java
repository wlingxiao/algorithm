package me.demo.algorithm.sort;

import static me.demo.algorithm.sort.Util.exch;

public class Quick3way {

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) { // less
                exch(a, lt++, i++);
            } else if (cmp > 0) { // greater
                exch(a, i, gt--);
            } else { // equal
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

}
