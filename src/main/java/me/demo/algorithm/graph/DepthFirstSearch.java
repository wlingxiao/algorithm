package me.demo.algorithm.graph;

/**
 * 深度优先搜索
 */
public class DepthFirstSearch implements Search {

    private boolean[] marked;

    private int count;

    public DepthFirstSearch(Graph graph, int s) {
        marked = new boolean[graph.v()];
        dfs(graph, s);
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

    /**
     * 检查顶点 v 是否与 s 连通
     */
    public boolean marked(int v) {
        return marked[v];
    }

    /**
     * 获取与 s 连通的顶点总数，包括点 s
     */
    public int count() {
        return count;
    }
}
