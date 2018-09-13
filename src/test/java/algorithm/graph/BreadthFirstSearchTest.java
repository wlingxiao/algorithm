package algorithm.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BreadthFirstSearchTest {

    @Test
    public void testDepthFirstSearch() {
        Graph graph = GraphTestUtil.createGraph();

        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);

        assertEquals(6, dfs.count());
        assertTrue(dfs.marked(1));
        assertTrue(dfs.marked(2));
        assertTrue(dfs.marked(3));
        assertTrue(dfs.marked(4));
        assertTrue(dfs.marked(5));
    }

}
