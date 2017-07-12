package me.demo.algorithm.list;

/**
 * 最大值优先队列，父节点索引为 ⌊k/2⌋（向下取整），两个子节点索引分别为 2k 和 2k + 1
 */
public class MaxPriorityQueue<E extends Comparable<E>> {

    private E[] pq; // pq[0] 未使用

    private int size;

    /**
     * 创建一个容量为 size 的优先队列
     */
    public MaxPriorityQueue(int size) {
        pq = (E[]) new Comparable[size + 1];
    }

    /**
     * 插入元素
     */
    public void insert(E e) {
        pq[++size] = e;
        swin(size);
    }

    /**
     * 返回最大元素
     */
    public E max() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty MaxPriorityQueue");
        }
        return pq[1];
    }

    /**
     * 删除并返回最大元素
     */
    public E delMax() {
        E max = pq[1];
        exch(1, size--);
        pq[size + 1] = null;
        sink(1);
        return max;
    }

    /**
     * 队列是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 队列元素个数
     */
    public int size() {
        return size;
    }

    /**
     * 上浮
     */
    private void swin(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    /**
     * 下沉
     */
    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(j, j + 1)) { // 总是与值更大的节点交换
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    /**
     * i < j
     */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /**
     * 交换 pq 中的 i 和 j
     */
    private void exch(int i, int j) {
        ArrayUtils.swap(pq, i, j);
    }
}
