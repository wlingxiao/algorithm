package algorithm.list;

import java.util.Iterator;

public class Stack<E> implements Iterable<E> {

    private static class Node<T> {
        T item;
        Node<T> next;
    }

    private Node<E> top;

    private int size;

    public Stack() {

    }

    public void push(E item) {
        Node<E> oldTop = top;
        top = new Node<>();
        top.item = item;
        top.next = oldTop;
        size++;
    }

    public E pop() {
        if (top == null) {
            throw new RuntimeException("Empty stack");
        }
        Node<E> oldTop = top;
        top = top.next;
        oldTop.next = null; // help gc
        size--;
        return oldTop.item;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E> {
        private Node<E> current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E t = current.item;
            current = current.next;
            return t;
        }
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println("stack size is : " + stack.size());

        for (int i : stack) {
            System.out.println(i);
        }

        for (int i = 0; i < 5; i++) {
            stack.pop();
        }
        System.out.println("stack size is : " + stack.size());
        System.out.println("stack is empty : " + stack.isEmpty());
    }

}
