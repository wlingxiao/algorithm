package me.demo.algorithm.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepthFirstSearchTest {

    @Test
    public void testDepthFirstSearch() {
        /**
         * 算法第四版 340 页，图 4.1.13 表示的无向图
         */
        Graph graph = GraphTestUtil.createGraph();
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);

        assertEquals(6, dfs.count());
        assertTrue(dfs.marked(1));
        assertTrue(dfs.marked(2));
        assertTrue(dfs.marked(3));
        assertTrue(dfs.marked(4));
        assertTrue(dfs.marked(5));

        assertFalse(dfs.marked(6));
        assertFalse(dfs.marked(7));
    }

}
