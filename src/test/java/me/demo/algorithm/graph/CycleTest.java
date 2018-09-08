package me.demo.algorithm.graph;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CycleTest {

    @Test
    public void testHasCycle() {
        Graph graph = GraphTestUtil.createGraph();
        Cycle cycle = new Cycle(graph);
        assertTrue(cycle.hasCycle());
    }

}
