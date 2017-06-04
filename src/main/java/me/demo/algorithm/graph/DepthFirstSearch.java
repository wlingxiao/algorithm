package me.demo.algorithm.graph;

public class DepthFirstSearch implements Search {

    private boolean[] marked;

    private int count;

    /**
     * 找到和起点 s 连通的所有顶点
     *
     * @param graph
     * @param s
     */
    public DepthFirstSearch(Graph graph, int s) {
        marked = new boolean[graph.v()];
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        count++;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }
}
