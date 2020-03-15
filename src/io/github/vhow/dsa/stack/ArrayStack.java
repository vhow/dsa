package io.github.vhow.dsa.stack;

import io.github.vhow.dsa.util.Watch;

public class ArrayStack<E> implements IStack<E> {

    private final Object[] arr;

    private int top = -1;

    public ArrayStack(final int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Stack's capacity must > 0.");
        }
        this.arr = new Object[capacity];
    }

    public static void main(String[] args) {
        final Watch watch = new Watch();
        final int size = 10000;
        final IStack<Integer> stack = new ArrayStack<>(size);
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
        return this.top + 1;
    }

    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            throw new RuntimeException("Empty stack can not top().");
        }
        return (E) this.arr[this.top];
    }

    @Override
    public void push(Object value) {
        if (this.top == this.arr.length) {
            throw new RuntimeException("Full stack can not push() any more.");
        }
        this.arr[++this.top] = value;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Empty stack can not pop().");
        }
        final E tmp = (E) this.arr[this.top];
        this.arr[this.top--] = null;
        return tmp;
    }
}
