package me.demo.algorithm.tree;

import lombok.val;

/**
 * 二叉查找树
 */
public class BinarySearchTree {

    private static class Node {
        int key;
        int value;

        Node left;
        Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public void insert(int key, int value) {
        val node = new Node(key, value);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        while (current != null) {
            if (node.key > current.key) {
                if (current.right == null) {
                    current.right = node;
                    break;
                } else {
                    current = current.right;
                }
            } else if (node.key < current.key) {
                if (current.left == null) {
                    current.left = node;
                    break;
                } else {
                    current = current.left;
                }
            } else {
                current.value = value;
                break;
            }
        }
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

    public void delete(int key) {
    }
}
