package algorithm.graph;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DirectedDFSTests {

    @Test
    public void testMarked() {
        Digraph digraph = new Digraph(13);
        digraph.addEdge(4, 2);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 2);
        digraph.addEdge(6, 0);
        digraph.addEdge(0, 1);
        digraph.addEdge(2, 0);
        digraph.addEdge(11, 12);
        digraph.addEdge(12, 9);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 11);
        digraph.addEdge(8, 9);
        digraph.addEdge(10, 12);
        digraph.addEdge(11, 4);
        digraph.addEdge(4, 3);
        digraph.addEdge(3, 5);
        digraph.addEdge(7, 8);
        digraph.addEdge(8, 7);
        digraph.addEdge(5, 4);
        digraph.addEdge(0, 5);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 9);
        digraph.addEdge(7, 6);

        DirectedDFS directedDFS = new DirectedDFS(digraph, 1);
        assertTrue(directedDFS.marked(1));

        DirectedDFS directedDFS1 = new DirectedDFS(digraph, 2);
        assertTrue(directedDFS1.marked(0));
        assertTrue(directedDFS1.marked(1));
        assertTrue(directedDFS1.marked(2));
        assertTrue(directedDFS1.marked(3));
        assertTrue(directedDFS1.marked(4));
        assertTrue(directedDFS1.marked(5));
    }
}
