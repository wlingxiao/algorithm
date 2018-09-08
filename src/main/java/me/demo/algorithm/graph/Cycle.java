package me.demo.algorithm.graph;

/**
 * Graph 是无环图吗？假设不存在自环或平行边
 */
public class Cycle {

    private boolean[] marked;

    private boolean hasCycle;

    public Cycle(Graph graph) {
        marked = new boolean[graph.v()];
        for (int s = 0; s < graph.v(); s++) {
            if (!marked[s]) {
                dfs(graph, s, s);
            }
        }
    }

    private void dfs(Graph graph, int v, int u) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w, v);
            } else if (w != u) { // 如果某个顶点与 v 连通，而且已被访问，还不是 v 的“父顶点”，则存在环
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
