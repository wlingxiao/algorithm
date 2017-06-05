package me.demo.algorithm.graph;

import java.util.Stack;

public class DepthFirstPaths implements Paths {

    private boolean[] marked;

    private int[] edgeTo;

    private final int s;

    /**
     * 在 graph 中找出所有起点为 s 的路径
     *
     * @param graph
     * @param s
     */
    public DepthFirstPaths(Graph graph, int s) {
        marked = new boolean[graph.v()];
        this.s = s;
        edgeTo = new int[graph.v()];
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, v);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
