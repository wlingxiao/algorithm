package algorithm.graph;

import java.util.Stack;

public class DirectedCycle {

    private boolean[] marked;

    private int[] edgeTo;

    private Stack<Integer> cycle;

    private boolean[] onStack;

    public DirectedCycle(Digraph digraph) {
        onStack = new boolean[digraph.v()];
        edgeTo = new int[digraph.v()];
        marked = new boolean[digraph.v()];

        for (int i = 0; i < digraph.v(); i++) {
            if (!marked[i]) {
                dfs(digraph, i);
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int i : digraph.adj(v)) {
            if (hasCycle()) {
                return;
            } else if (!marked[v]) {
                edgeTo[i] = v;
                dfs(digraph, i);
            } else if (onStack[i]) {
                cycle = new Stack<>();
                for (int x = v; x != i; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(i);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
