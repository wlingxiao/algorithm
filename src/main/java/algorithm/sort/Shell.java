package algorithm.sort;

import static algorithm.sort.Util.exch;
import static algorithm.sort.Util.less;

public class Shell {

    public static void sort(Comparable[] c) {
        int N = c.length;
        int h = 1;
        while (h < N / 3) {
            h = h * 3;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(c[j], c[j - h]); j -= h) {
                    exch(c, j, j - h);
                }
            }
            h /= 3;
        }
    }

}
