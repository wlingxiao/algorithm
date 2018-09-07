package me.demo.algorithm.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BreadthFirstSearchTest {

    @Test
    public void testDepthFirstSearch() {
        /**
         * 算法第四版 340 页，图 4.1.13 表示的无向图
         */
        Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);

        graph.addEdge(2, 1);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);

        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);

        assertEquals(6, dfs.count());
        assertTrue(dfs.marked(1));
        assertTrue(dfs.marked(2));
        assertTrue(dfs.marked(3));
        assertTrue(dfs.marked(4));
        assertTrue(dfs.marked(5));
    }

}
