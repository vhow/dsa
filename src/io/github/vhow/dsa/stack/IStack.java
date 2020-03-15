package io.github.vhow.dsa.stack;

public interface IStack<E> {
    int size();

    boolean isEmpty();

    E top();

    void push(E item);

    E pop();
}
