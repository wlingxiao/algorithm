package me.demo.algorithm.tree;

/**
 * 深度：对于任意节点n,n的深度为从根到n的唯一路径长，根的深度为0；
 * 高度：对于任意节点n,n的高度为从n到一片树叶的最长路径长，所有树叶的高度为0；
 */
public class AvlTree {

    static class Node {
        Node left;
        Node right;
        int value;
        int height;

        public Node(int value) {
            this.value = value;
        }
    }

    int height(Node node) {
        return node == null ? -1 : node.height;
    }

    /**
     * LL
     */
    Node leftLeftRotate(Node node) {

    }

    /**
     * RR
     */
    Node rightRightRotate(Node node) {
    }

    public void insert(int value) {

    }

}
