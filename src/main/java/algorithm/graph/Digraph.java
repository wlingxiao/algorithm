package algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 有向图
 * 由一组顶点和一组有方向的边组成，每条有方向的边都连接着有序的一对顶点
 */
public class Digraph {

    private int v;

    private int e;

    private List<List<Integer>> adj;

    /**
     * 创建一副含有 v 个顶点但没有边的有向图
     *
     * @param v 顶点总数
     */
    public Digraph(int v) {
        this.v = v;

        this.e = 0;

        adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    /**
     * 顶点总数
     */
    public int v() {
        return v;
    }

    /**
     * 边的总数
     */
    public int e() {
        return e;
    }

    /**
     * 向有向图中添加一条边 v->w
     */
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        e++;
    }


    /**
     * 由 v 指出的边所连接的所有顶点
     */
    Iterable<Integer> adj(int v) {
        return adj.get(v);
    }

    /**
     * 该图的反向图
     */
    public Digraph reverse() {
        Digraph temp = new Digraph(v);
        for (int i = 0; i < v; i++) {
            for (int w : adj(v)) {
                temp.addEdge(w, v);
            }
        }
        return temp;
    }

}
