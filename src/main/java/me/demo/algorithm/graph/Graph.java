package me.demo.algorithm.graph;


import java.util.ArrayList;
import java.util.List;

/**
 * 邻接表表示的无向图
 */
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
    private final List<List<Integer>> adj;

    /**
     * 创建一个含有 v 个顶点但是不含边的图
     */
    public Graph(int v) {
        this.v = v;
        e = 0;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    /**
     * 顶点数
     */
    int v() {
        return v;
    }

    /**
     * 边数
     */
    int e() {
        return e;
    }

    /**
     * 添加一条无向边 v-w
     */
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
        e++;
    }

    /**
     * 与 v 相邻的所有点
     */
    public Iterable<Integer> adj(int v) {
        return adj.get(v);
    }
}
