package me.demo.algorithm.graph;

/**
 * 有向图可达性，深度优先搜索
 */
public class DirectedDFS {

    private boolean marked[];

    /**
     * 在 digraph 中找到从 s 可达的所有顶点
     *
     * @param digraph
     * @param s
     */
    public DirectedDFS(Digraph digraph, int s) {
        marked = new boolean[digraph.v()];
        dfs(digraph, s);
    }

    /**
     * 在 digraph 中找到从 sources 中的所有顶点可达的所有顶点
     *
     * @param digraph
     * @param sources
     */
    public DirectedDFS(Digraph digraph, Iterable<Integer> sources) {
        marked = new boolean[digraph.v()];
        for (int s : sources) {
            if (!marked(s)) {
                dfs(digraph, s);
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (!marked(w)) {
                dfs(digraph, w);
            }
        }
    }

    /**
     * v 是可达的吗？
     *
     * @param v
     * @return
     */
    boolean marked(int v) {
        return marked[v];
    }
}
