package algorithm.graph;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths {

    /**
     * 到达该顶点的最短路径已知吗？
     */
    private boolean[] marked;

    /**
     * 到达该顶点的已知路径上的最后一个顶点
     */
    private int edgeTo[];

    /**
     * 起点
     */
    private final int s;

    public BreadthFirstPaths(Graph graph, int s) {
        marked = new boolean[graph.v()];
        edgeTo = new int[graph.v()];
        this.s = s;
    }

    private void bfs(Graph graph, int s) {
        Queue<Integer> queue = new PriorityQueue<>();
        marked[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

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
