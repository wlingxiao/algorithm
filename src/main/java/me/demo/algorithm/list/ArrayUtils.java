package me.demo.algorithm.list;


final class ArrayUtils {

    private ArrayUtils() {
    }

    /**
     * 交换 pq 中的 i 和 j
     */
    static <E> void swap(E[] pq, int i, int j) {
        E t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

}
