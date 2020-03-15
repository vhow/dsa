package io.github.vhow.dsa.stack;

import io.github.vhow.dsa.util.Watch;

public class LinkStack<E> implements IStack<E> {
    private Node<E> top;
    private int size;

    public static void main(String[] args) {
        final Watch watch = new Watch();
        final int size = 10000;
        final IStack<Integer> stack = new LinkStack<>();
        for (int i = 0; i < size; i++) {
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        watch.stop();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            throw new RuntimeException("Empty stack can not top().");
        }
        return this.top.value;
    }

    @Override
    public void push(E value) {
        this.top = new Node<>(value, top);
        this.size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Empty stack can not pop().");
        }
        final E topValue = this.top.value;
        this.top = this.top.next;
        this.size--;
        return topValue;
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
