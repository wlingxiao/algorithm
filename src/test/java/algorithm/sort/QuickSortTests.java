package algorithm.sort;

import org.junit.Test;

import static algorithm.sort.Util.sorted;

public class QuickSortTests {

    @Test
    public void testSortEmpty() {
        Integer[] empty = {};
        QuickSort.sort(empty);
    }

    @Test
    public void testSortOneElement() {
        Integer[] integers = {1};
        QuickSort.sort(integers);
        sorted(integers);
    }

    @Test
    public void testRepeatElement() {
        Integer[] integers = {1, 3, 1, 43, 3, 5, 6, 1, 2, 3,};
        QuickSort.sort(integers);
        sorted(integers);
    }

}
