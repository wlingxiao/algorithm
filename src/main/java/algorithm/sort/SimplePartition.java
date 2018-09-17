package algorithm.sort;

import static algorithm.sort.Util.exch;
import static algorithm.sort.Util.less;

public class SimplePartition implements Partition {

    /**
     * （wiki描述）重新排序数组，所有比基准小的元素摆在基准前面，比基准大的放在后面。在分区结束后，这个基准就位于数组的中间位置。这个操作称为分区（partitionable）
     */
    @Override
    public int partition(Comparable[] arr, int lo, int hi) {
        int i = lo;
        int lt = lo;
        int gt = hi;
        Comparable v = arr[lo];
        while (i <= gt) {
            if (less(arr[i], v)) {
                exch(arr, i++, lt++);
            } else if (less(v, arr[i])) {
                exch(arr, i, gt--);
            } else {
                i++;
            }
        }
        return lt;
    }
}
