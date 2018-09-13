package algorithm.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 加权无向图
 */
public class EdgeWeightedGraph {

    private final int v;
    private int e;
    // TODO replace to bag
    private LinkedList<Edge>[] adj;

    public EdgeWeightedGraph(int v) {
        this.v = v;
        this.e = 0;
        adj = (LinkedList<Edge>[]) new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public int v() {
        return v;
    }

    public int e() {
        return e;
    }

    public void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        e++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        LinkedList<Edge> b = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            for (Edge e : adj[i]) {
                if (e.other(i) > v) {
                    b.add(e);
                }
            }
        }
        return b;
    }
}
