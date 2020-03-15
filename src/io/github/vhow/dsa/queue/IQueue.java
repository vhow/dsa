package io.github.vhow.dsa.queue;

public interface IQueue<E> {
    int size();

    boolean isEmpty();

    E first();

    void enqueue(E value);

    E dequeue();
}
