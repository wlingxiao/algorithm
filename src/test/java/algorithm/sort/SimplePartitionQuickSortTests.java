package algorithm.sort;

public class SimplePartitionQuickSortTests extends BaseSortTests {

    @Override
    Sort sort() {
        return new QuickSort(new SimplePartition());
    }
}
