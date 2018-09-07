package me.demo.algorithm.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SinglyLinkedListTests {

    @Test
    public void testSinglyLinkedListOperation() {
        SinglyLinkedList<Integer> integers = new SinglyLinkedList<>();
        integers.insertFirst(4);
        integers.insertFirst(3);
        integers.insertFirst(2);
        integers.insertFirst(1);

        List<Integer> integerList = new ArrayList<>(integers.size());
        integers.forEach(integerList::add);
        Integer[] array = {1, 2, 3, 4};
        assertArrayEquals(integerList.toArray(), array);

        List<Integer> reverseIntegerList = new ArrayList<>(integers.size());
        integers.reverse().forEach(reverseIntegerList::add);
        Integer[] reverseArray = {4, 3, 2, 1};
        assertArrayEquals(reverseIntegerList.toArray(), reverseArray);

        assertEquals(1, (int) integers.first());
        assertEquals(4, (int) integers.last());
        assertEquals(integers.size(), 4);

        integers.removeAll(4);
        integers.removeAll(1);

        assertEquals(2, (int) integers.first());
        assertEquals(3, (int) integers.last());
        assertEquals(integers.size(), 2);

        SinglyLinkedList<Integer> insertLastList = new SinglyLinkedList<>();
        insertLastList.insertLast(5);
        insertLastList.insertLast(6);
        insertLastList.insertLast(7);
        insertLastList.insertLast(8);

        List<Integer> lasts = new ArrayList<>(integers.size());
        insertLastList.forEach(lasts::add);
        Integer[] insertLast = {5, 6, 7, 8};
        assertArrayEquals(lasts.toArray(), insertLast);
    }
}
