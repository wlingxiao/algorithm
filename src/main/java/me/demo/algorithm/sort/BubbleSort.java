package me.demo.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 算法描述：
 * 1. 比较相邻两个元素，如果第一个比第二个大，则交换两个元素
 * 2. 对每一对相邻元素做同样的工作，从开始的一对到最后一对。这步做完后，最后一个元素为最大元素
 * 3. 针对所有元素重复以上操作，除了最后一个
 * 4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
 */
public class BubbleSort {

    public static void sort(Integer[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) { // i 用来指示最后一个元素的位置
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    Util.exch(array, j, j + 1);
                }

            }

        }
    }

    public static void main(String[] args) {

        Integer[] i = new Integer[]{1, 3, 5, 6, 7, 8, 4, 76,};
        sort(i);
        System.out.println(Arrays.toString(i));
    }

}
