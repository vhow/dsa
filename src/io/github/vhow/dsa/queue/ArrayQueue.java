package io.github.vhow.dsa.queue;

import io.github.vhow.dsa.util.Watch;

public class ArrayQueue<E> implements IQueue<E> {

    private final Object[] arr;
    private int first;
    private int last;

    public ArrayQueue(int capacity) {
        this.arr = new Object[capacity];
    }

    public static void main(String[] args) {
        final Watch watch = new Watch();
        final int size = 10000;
        final IQueue<Integer> q = new ArrayQueue<>(size);
        for (int i = 0; i < size; i++) {
            q.enqueue(i);
        }
        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
        watch.stop();
    }

    @Override
    public int size() {
        return this.last - this.first;
    }

    @Override
    public boolean isEmpty() {
        return this.last == this.first;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue can not first().");
        }
        return (E) this.arr[this.first];
    }

    @Override
    public void enqueue(E value) {
        if (last == this.arr.length) {
            throw new RuntimeException("Full queue can not enqueue().");
        }
        this.arr[this.last++] = value;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue can not dequeue()");
        }
        final E firstValue = (E) this.arr[this.first];
        this.arr[this.first++] = null;
        return firstValue;
    }
}
