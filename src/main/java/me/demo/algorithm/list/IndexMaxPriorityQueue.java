package me.demo.algorithm.list;

public class IndexMaxPriorityQueue<E extends Comparable<E>> {
    private int n;

    private int[] pq;

    private int[] qp;

    private E[] keys;

    public IndexMaxPriorityQueue(int maxN) {
        keys = (E[]) new Comparable[maxN];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++) {
            qp[i] = -1;
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(int i) {
        return qp[i] == -1;
    }

    public int size() {
        return n;
    }

    public void insert(int i, E key) {
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;

    }

    public int maxIndex() {
        return pq[1];
    }

    public E maxKey() {
        return keys[pq[1]];
    }

    public int delMax() {
        int min = pq[1];
        ArrayUtils.swap(keys, 1, n--);
        sink(1);

        qp[min] = -1;
        keys[min] = null;
        pq[n + 1] = -1;
        return min;
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(k / 2, k)) {
                ArrayUtils.swap(keys, k, k / 2);
                k /= 2;
            }
        }
    }

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }
}
