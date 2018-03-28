package me.demo.algorithm.tree;

import lombok.val;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

        val treeNodes = avlTree.inOrderTraversal();
        Assert.assertArrayEquals(treeNodes.toArray(), new Integer[]{1, 2, 3, 5, 6, 7, 8});
    }

}
