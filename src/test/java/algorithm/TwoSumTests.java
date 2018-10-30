package algorithm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoSumTests {

    @Test
    public void testTowSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        TwoSum towSum = new TwoSum();
        int[] ret = towSum.twoSum(nums, target);
        assertEquals(ret[0], 0);
        assertEquals(ret[1], 1);
    }

    @Test
    public void testTowSumSameElement() {
        int[] nums = {2, 4, 4, 15};
        int target = 8;

        TwoSum towSum = new TwoSum();
        int[] ret = towSum.twoSum(nums, target);
        assertEquals(ret[0], 1);
        assertEquals(ret[1], 2);
    }

    @Test
    public void testTowSumSameElement2() {
        int[] nums = {2, 4, 4, 5, 15};
        int target = 9;

        TwoSum towSum = new TwoSum();
        int[] ret = towSum.twoSum(nums, target);
        assertEquals(ret[0], 2);
        assertEquals(ret[1], 3);
    }

}
