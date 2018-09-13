package algorithm.graph;

/**
 * 拓扑排序
 */
public class Topological {

    private Iterable<Integer> order;

    public Topological(Digraph digraph) {
        DirectedCycle cycleFinder = new DirectedCycle(digraph);
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(digraph);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }
}
