package algorithm.sort;

/**
 * 快速排序
 * 1. 从数组中挑选一个元素，作为基准（pivot）
 * 2-1. （wiki描述）重新排序数组，所有比基准小的元素摆在基准前面，比基准大的放在后面。在分区结束后，这个基准就位于数组的中间位置。这个操作称为分区（partition）
 * <p>
 * 3. 递归地把小于基准的**子数组**和的**子数组**排序
 * <p>
 * 算法第四版
 * 参考：https://algs4.cs.princeton.edu/23quicksort/Quick.java.html
 */
public class QuickSort implements Sort {

    private Partition partition;

    public QuickSort() {
        partition = new WikiPartition();
    }

    public QuickSort(Partition partition) {
        this.partition = partition;
    }

    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) { // 当 a 为空数组时，lo = 0，hi = -1. 当 a 为 1 个元素数组时，lo = 0，hi = 0,分区操作不能处理 0 个或 1 个元素的情况，应该提前终止
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(Comparable[] arr, int lo, int hi) {
        return partition.partition(arr, lo, hi);
    }

}
