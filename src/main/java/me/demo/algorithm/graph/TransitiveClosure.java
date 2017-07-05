package me.demo.algorithm.graph;

/**
 * 顶点对可达性 API
 */
public class TransitiveClosure {

    private DirectedDFS[] all;

    public TransitiveClosure(Digraph digraph) {
        all = new DirectedDFS[digraph.v()];
        for (int v = 0; v < digraph.v(); v++) {
            all[v] = new DirectedDFS(digraph, v);
        }
    }

    /**
     * w 和 v 是可达的吗？
     */
    public boolean reachable(int v, int w) {
        return all[v].marked(w);
    }

}
