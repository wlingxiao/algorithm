package algorithm.sort;

import org.junit.Test;

import static algorithm.sort.Util.sorted;

public class BubbleSortTest extends BaseSortTests {

    @Override
    Sort sort() {
        return new BubbleSort();
    }
}
