package me.demo.algorithm.list;

import java.util.Iterator;

/**
 * Queue
 */
public class Queue<E> implements Iterable<E> {

    private static class Node<T> {
        T item;
        Node<T> next;
    }

    private Node<E> head;

    private Node<E> tail;

    private int size;

    public void enqueue(E item) {
        Node<E> node = new Node<>();
        node.item = item;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }

    public E dequeue() {
        if (head == null) {
            throw new RuntimeException("empty queue");
        }
        Node<E> oldHead = head;
        head = head.next;
        oldHead.next = null; // help gc
        size--;
        return oldHead.item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E> {

        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println("queue size is : " + queue.size());

        for (int i : queue) {
            System.out.println(i);
        }

        for (int i = 0; i < 5; i++) {
            queue.dequeue();
        }
        System.out.println("queue size is : " + queue.size());
        System.out.println("queue is empty : " + queue.isEmpty());
    }

}
