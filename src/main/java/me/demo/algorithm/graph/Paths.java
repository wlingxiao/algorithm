package me.demo.algorithm.graph;

/**
 * 路径寻找
 */
public interface Paths {

    /**
     * 是否存在 s 到 v 的路径
     *
     * @param v
     * @return
     */
    boolean hasPathTo(int v);

    /**
     * s 到 v 的路径，如果不存在则返回 null
     *
     * @param v
     * @return
     */
    Iterable<Integer> pathTo(int v);

}
