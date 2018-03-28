package me.demo.algorithm.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AvlTreeTest {

    private AvlTree avlTree;


    @Before
    public void setUp() {
        avlTree = new AvlTree();
    }

    @Test
    public void testInsertThenFind() {
        avlTree.insert(5, 50);
        avlTree.insert(2, 20);
        avlTree.insert(1, 10);
        avlTree.insert(3, 30);

        avlTree.insert(7, 70);
        avlTree.insert(6, 60);
        avlTree.insert(8, 80);

        assertEquals(50, avlTree.find(5));
        assertEquals(20, avlTree.find(2));
        assertEquals(10, avlTree.find(1));
        assertEquals(30, avlTree.find(3));

        assertEquals(70, avlTree.find(7));
        assertEquals(60, avlTree.find(6));
        assertEquals(80, avlTree.find(8));

        assertEquals(-1, avlTree.find(9));

        List<Integer> treeNodes = avlTree.inOrderTraversal();
        assertArrayEquals(treeNodes.toArray(), new Integer[]{1, 2, 3, 5, 6, 7, 8});
    }

    @Test
    public void testDelete() {
        avlTree.insert(5, 50);
        avlTree.insert(2, 20);
        avlTree.insert(1, 10);
        avlTree.insert(3, 30);

        avlTree.insert(7, 70);
        avlTree.insert(6, 60);
        avlTree.insert(8, 80);

        avlTree.delete(5);
        avlTree.delete(2);
        avlTree.delete(1);
        avlTree.delete(3);

        avlTree.inOrderTraversal();

        avlTree.delete(7);
        avlTree.delete(6);
        avlTree.delete(8);

        avlTree.inOrderTraversal();

        assertEquals(-1, avlTree.find(5));
        assertEquals(-1, avlTree.find(2));
        assertEquals(-1, avlTree.find(1));
        assertEquals(-1, avlTree.find(3));

        assertEquals(-1, avlTree.find(7));
        assertEquals(-1, avlTree.find(6));
        assertEquals(-1, avlTree.find(8));
    }

    @Test
    public void inOrderTraversal_empty_tree_should_not_throw_any_exception() {
        List<Integer> integers = avlTree.inOrderTraversal();
        assertArrayEquals(integers.toArray(), new Integer[]{});
    }

}
