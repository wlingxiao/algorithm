package algorithm.graph;

import algorithm.list.Queue;

/**
 * 广度优先搜索
 */
public class BreadthFirstSearch implements Search {

    private boolean[] marked;

    private int count;

    public BreadthFirstSearch(Graph graph, int s) {
        marked = new boolean[graph.v()];
        bfs(graph, s);
    }

    private void bfs(Graph graph, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        count++;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    @Override
    public boolean marked(int v) {
        return marked[v];
    }

    @Override
    public int count() {
        return count;
    }
}
