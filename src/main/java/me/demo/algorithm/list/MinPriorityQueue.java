package me.demo.algorithm.list;

/**
 * 最小值优先队列
 */
public class MinPriorityQueue<E extends Comparable<E>> {

    private E[] priorityQueue;

    private int N;

    public MinPriorityQueue(int size) {
        priorityQueue = (E[]) new Comparable[N + 1];
    }

    public void insert(E element) {
        priorityQueue[++N] = element;
        swim(N);
    }

    public E min() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty MaxPriorityQueue");
        }
        return priorityQueue[1];
    }

    public E delMin() {
        E min = priorityQueue[1];
        ArrayUtils.swap(priorityQueue, 1, N--);
        priorityQueue[N + 1] = null;
        sink(1);
        return min;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 上浮
     */
    private void swim(int n) {
        while (n > 1 && more(n, n / 2)) {
            ArrayUtils.swap(priorityQueue, n, n / 2);
            n /= 2;
        }
    }

    private void sink(int n) {

        while (2 * n <= N) {
            int j = 2 * n;

            if (j < N && more(j, j + 1)) {
                j++;
            }

            if (!more(n, j)) {
                break;
            }

            ArrayUtils.swap(priorityQueue, n, j);
            n = j;
        }

    }

    /**
     * i > j
     */
    private boolean more(int i, int j) {
        return priorityQueue[i].compareTo(priorityQueue[j]) > 0;
    }


}
