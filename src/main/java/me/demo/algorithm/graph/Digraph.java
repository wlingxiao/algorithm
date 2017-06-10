package me.demo.algorithm.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 有向图
 */
public class Digraph {

    private int v;

    private int e;

    private List<Integer>[] adj;

    /**
     * 创建一副含有 v 个顶点但没有边的有向图
     *
     * @param v
     */
    public Digraph(int v) {
        this.v = v;

        this.e = 0;

        adj = (List<Integer>[]) new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 顶点总数
     *
     * @return
     */
    int v() {
        return v;
    }

    /**
     * 边的总数
     *
     * @return
     */
    int e() {
        return e;
    }

    /**
     * 向有向图中添加一条边 v->w
     *
     * @param v
     * @param w
     */
    void addEdge(int v, int w) {
        adj[v].add(w);
        e++;
    }


    /**
     * 由 v 指出的边所连接的所有顶点
     *
     * @param v
     */
    Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * 该图的反向图
     *
     * @return
     */
    Digraph reverse() {
        Digraph temp = new Digraph(v);
        for (int i = 0; i < v; i++) {
            for (int w : adj(v)) {
                temp.addEdge(w, v);
            }
        }
        return temp;
    }

}
