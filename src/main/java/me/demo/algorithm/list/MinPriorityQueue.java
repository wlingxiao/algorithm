package me.demo.algorithm.list;

/**
 * 最小值优先队列
 */
public abstract class MinPriorityQueue<E extends Comparable<E>> {

    private E[] priorityQueue;

    private int N;

    public abstract void insert(E element);

    public abstract E min();

    public abstract E delMin();

    public abstract boolean isEmpty();

    public abstract int size();

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
