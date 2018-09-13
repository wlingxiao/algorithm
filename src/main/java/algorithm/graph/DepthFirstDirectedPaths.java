package algorithm.graph;

import algorithm.list.Stack;

/**
 * 单点有效路径：给定一副有向图和一个起点 s，判断从 s 到目标顶点 v 是否存在一条有向路径？如果有，找出这条路径
 */
public class DepthFirstDirectedPaths {

    private boolean[] marked;

    private int[] edgeTo;

    /**
     * 起点
     */
    private final int s;

    public DepthFirstDirectedPaths(Digraph digraph, int s) {
        this.s = s;
        marked = new boolean[digraph.v()];
        edgeTo = new int[digraph.e()];

        dfs(digraph, s);
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        for (int i : digraph.adj(v)) {
            if (!marked[i]) {
                edgeTo[i] = v; // 套路
                dfs(digraph, i);

            }
        }
    }

    public boolean hasPath(int v) {
        return marked[v];
    }

    public Iterable<Integer> path(int v) {
        if (!hasPath(v)) {
            return null;
        }

        Stack<Integer> paths = new Stack<>();
        for (int w = v; w != s; w = edgeTo[w]) { // 又是套路
            paths.push(w);
        }
        paths.push(s);
        return paths;
    }

}
