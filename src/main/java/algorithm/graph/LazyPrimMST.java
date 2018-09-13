package algorithm.graph;

import algorithm.list.Queue;

import java.util.PriorityQueue;

/**
 * 最小生成树的 Prim 算法的延时实现
 */
public class LazyPrimMST {

    /**
     * 最小生成树的顶点
     */
    private boolean marked[];

    /**
     * 最小生成树的顶点
     */
    private Queue<Edge> mst;

    /**
     * 横切边（包括失效的边）
     */
    private PriorityQueue<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph graph) {
        pq = new PriorityQueue<>();
        marked = new boolean[graph.v()];
        mst = new Queue<>();

        visit(graph, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.peek();

            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) {
                continue;
            }
            if (!marked[v]) {
                visit(graph, v);
            }
            if (!marked[w]) {
                visit(graph, w);
            }
        }

    }

    private void visit(EdgeWeightedGraph graph, int v) {
        marked[v] = true;
        for (Edge e : graph.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.add(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    // TODO
    public double weight() {
        throw new UnsupportedOperationException();
    }

}
