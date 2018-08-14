package me.demo.algorithm.sort;

import org.apache.commons.lang3.RandomUtils;

public final class Util {
    private Util() {
    }

    public static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static Integer[] integerArray(int size) {
        Integer[] integers = new Integer[size];
        for (int i = 0; i < size; i++) {
            integers[i] = RandomUtils.nextInt();
        }
        return integers;
    }

    public static Integer[] integerArray() {
        int size = 20;
        Integer[] integers = new Integer[size];
        for (int i = 0; i < size; i++) {
            integers[i] = RandomUtils.nextInt(0, 1000);
        }
        return integers;
    }

    public static void sorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (less(a[i + 1], a[i])) {
                throw new UnsortedException();
            }
        }
    }

}
