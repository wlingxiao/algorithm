package me.demo.algorithm.graph;


import java.util.LinkedList;

public class GraphUtil {

    /**
     * 计算 v 的度数
     *
     * @param graph
     * @param v
     * @return
     */
    public static int degree(Graph graph, int v) {
        int i = 0;
        for (Integer integer : graph.adj(v)) {
            i++;
        }
        return i;
    }

    /**
     * 计算所有顶点的最大度数
     *
     * @param graph
     * @return
     */
    public static int maxDegree(Graph graph) {
        int max = 0;

        for (int v = 0; v < graph.v(); v++) {
            if (degree(graph, v) > max) {
                max = degree(graph, v);
            }
        }
        return max;
    }

    /**
     * 平均度数
     *
     * @param graph
     * @return
     */
    public static double avgDegree(Graph graph) {
        return 0;
    }

    /**
     * 计算自环个数
     *
     * @param graph
     * @return
     */
    public static int numberOfSelfLoops(Graph graph) {
        return 0;
    }

}
