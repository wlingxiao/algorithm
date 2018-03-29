package me.demo.algorithm.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class BinarySearchTreeTest {

    private BinarySearchTree searchTree;


    @Before
    public void setUp() {
        searchTree = new BinarySearchTree();
    }

    @Test
    public void testInsertThenFind() {
        searchTree.insert(5, 50);
        searchTree.insert(2, 20);
        searchTree.insert(1, 10);
        searchTree.insert(3, 30);

        searchTree.insert(7, 70);
        searchTree.insert(6, 60);
        searchTree.insert(8, 80);

        Assert.assertEquals(50, searchTree.find(5));
        Assert.assertEquals(20, searchTree.find(2));
        Assert.assertEquals(10, searchTree.find(1));
        Assert.assertEquals(30, searchTree.find(3));

        Assert.assertEquals(70, searchTree.find(7));
        Assert.assertEquals(60, searchTree.find(6));
        Assert.assertEquals(80, searchTree.find(8));

        Assert.assertEquals(-1, searchTree.find(9));
    }

    @Test
    public void testDelete() {
        searchTree.insert(5, 50);
        searchTree.insert(2, 20);
        searchTree.insert(1, 10);
        searchTree.insert(3, 30);

        searchTree.insert(7, 70);
        searchTree.insert(6, 60);
        searchTree.insert(8, 80);

        searchTree.delete(5);
        searchTree.delete(2);
        searchTree.delete(1);
        searchTree.delete(3);

        searchTree.inOrderTraversal();

        searchTree.delete(7);
        searchTree.delete(6);
        searchTree.delete(8);

        searchTree.inOrderTraversal();

        Assert.assertEquals(-1, searchTree.find(5));
        Assert.assertEquals(-1, searchTree.find(2));
        Assert.assertEquals(-1, searchTree.find(1));
        Assert.assertEquals(-1, searchTree.find(3));

        Assert.assertEquals(-1, searchTree.find(7));
        Assert.assertEquals(-1, searchTree.find(6));
        Assert.assertEquals(-1, searchTree.find(8));
    }

    @Test
    public void testIterator() {
        searchTree.insert(5, 50);
        searchTree.insert(2, 20);
        searchTree.insert(1, 10);
        searchTree.insert(3, 30);

        Iterator<Integer> it = searchTree.iterator();
        Assert.assertTrue(it.hasNext());

        Assert.assertEquals(new Integer("1"), it.next());
        Assert.assertEquals(new Integer("2"), it.next());
        Assert.assertEquals(new Integer("3"), it.next());
        Assert.assertEquals(new Integer("5"), it.next());
        Assert.assertFalse(it.hasNext());

    }

}
