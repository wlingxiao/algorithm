package me.demo.algorithm.graph;


import java.util.LinkedList;

public class Graph {

    /**
     * 顶点数
     */
    private final int v;

    /**
     * 边的数目
     */
    private int e;

    /**
     * 邻接表
     */
    private LinkedList<Integer>[] adj;

    /**
     * 创建一个含有 v 个顶点但是不含边的图
     *
     * @param v
     */
    public Graph(int v) {
        this.v = v;
        e = 0;
        adj = (LinkedList<Integer>[]) new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    /**
     * 边数
     *
     * @return
     */
    int v() {
        return v;
    }

    /**
     * 顶点数
     *
     * @return
     */
    int e() {
        return e;
    }

    /**
     * 添加一条边 v-w
     *
     * @param v
     * @param w
     */
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        e++;
    }

    /**
     * 与 v 相邻的所有边
     *
     * @param v
     * @return
     */
    Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
