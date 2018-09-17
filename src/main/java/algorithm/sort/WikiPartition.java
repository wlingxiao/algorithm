package algorithm.sort;

import static algorithm.sort.Util.exch;
import static algorithm.sort.Util.less;

public class WikiPartition implements Partition {

    /**
     * 分区操作
     * （当前算法描述）从前往后比较基准与元素，直到元素大于基准或 i > hi 从后往前比较基准与元素，直到元素小于基准或 j > lo
     *
     * @param arr 待排序数组
     * @param lo  数组开始索引
     * @param hi  数组结束索引
     * @return 分区操作后，中间元素索引
     */
    @Override
    public int partition(Comparable[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable pivot = arr[lo]; // 取基准为数组或子数组第一个元素
        while (true) {
            while (less(arr[++i], pivot)) { // 如果左边的元素都比基准小，则递增 i 并检查 i 是否达到 hi（位置2）
                if (i == hi) {
                    break;
                }
            }
            while (less(pivot, arr[--j])) { // 如果右边的元素都比基准大，则递减 j 并检查 j 是否达到 lo （位置1）
                if (j == lo) { // 这个检查是多余的，因为 j 最多达到 0 且 pivot 的索引为 0 不会比自己小
                    break;
                }
            }

            if (i > j) {
                // System.out.println(i + " | " + j);
            }
            if (i == j) {
                //System.out.println("equal " + i + " | " + j);
            }
            if (i >= j) { // 什么时候 i 会大于 j？在顺序排列数组 [1, 2, 3] 中，i 的初始值为 0 在位置2 处会增加 1 ，而 j 会在位置1 处减小到 0，此时 i > j
                // 什么时候 i == j？在逆序排列数组 [3， 2， 1] 中，i 的初始值为 0 在位置2 处会增加 1 ，而 j 会在位置1 处减小到 0，此时 i > j
                break;
            }
            exch(arr, i, j); // 当 i 在较大的位置停止时，j在较小的位置停止时，交换 i 和 j 上的值
        }
        exch(arr, lo, j);
        return j;
    }
}
