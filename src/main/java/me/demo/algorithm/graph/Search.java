package me.demo.algorithm.graph;


public interface Search {

    /**
     * v 和 s 是否连通
     *
     * @param v
     * @return
     */
    boolean marked(int v);

    /**
     * 与 s 连通的所有顶点数
     *
     * @return
     */
    int count();
}
