package me.demo.algorithm.tree;

import lombok.val;

import java.util.LinkedList;
import java.util.List;

/**
 * 深度：对于任意节点n,n的深度为从根到n的唯一路径长，根的深度为0；
 * 高度：对于任意节点n,n的高度为从n到一片树叶的最长路径长，所有树叶的高度为0；
 */
public class AvlTree {

    private static class Node {
        Node left;
        Node right;
        int key;
        int value;
        int height;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    private int height(Node node) {
        return node == null ? -1 : node.height;
    }

    /**
     * LL
     */
    private Node leftLeftRotate(Node k2) {
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height);
        return k1;
    }

    /**
     * RR
     */
    private Node rightRightRotate(Node k2) {
        Node k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;

        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(k2.height, height(k1.right));

        return k1;
    }

    private Node leftRightRotate(Node node) {
        node.left = rightRightRotate(node.left);
        return leftLeftRotate(node);
    }

    private Node rightLeftRotate(Node node) {
        node.left = leftLeftRotate(node.left);
        return rightRightRotate(node);
    }

    public void insert(int key, int value) {
        root = insert(key, value, root);
    }

    private Node insert(int key, int value, Node current) {
        if (current == null) {
            return new Node(key, value);
        }
        if (value < current.value) {
            current.left = insert(key, value, current.left);
            if (height(current.left) - height(current.right) == 2) {
                if (key < current.left.key) {
                    current = leftLeftRotate(current);
                } else {
                    current = leftRightRotate(current);
                }
            }
        } else if (value > current.value) {
            current.right = insert(key, value, current.right);
            if (height(current.right) - height(current.left) == 2) {
                if (key > current.right.key) {
                    current = rightRightRotate(current);
                } else {
                    current = rightLeftRotate(current);
                }
            }
        } else {
            return null;
        }

        current.height = Math.max(height(current.left), height(current.right)) + 1;

        return current;
    }

    public int find(int key) {
        if (root == null) {
            return -1;
        }
        Node current = root;
        while (current != null) {
            if (key > current.key) {
                current = current.right;
            } else if (key < current.key) {
                current = current.left;
            } else {
                break;
            }
        }
        if (current != null) {
            return current.value;
        } else {
            return -1;
        }
    }

    public List<Integer> inOrderTraversal() {
        val ret = new LinkedList<Integer>();
        inOrderTraversal(root, ret);
        return ret;
    }

    private void inOrderTraversal(Node current, List<Integer> out) {
        if (current.left != null) {
            inOrderTraversal(current.left, out);
        }
        out.add(current.key);
        if (current.right != null) {
            inOrderTraversal(current.right, out);
        }
    }

}
