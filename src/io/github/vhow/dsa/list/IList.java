package io.github.vhow.dsa.list;

public interface IList<E> {
    int size();

    boolean isEmpty();

    E get(int index);

    void add(E value);

    void add(int index, E value);

    void clear();

    void set(int index, E value);

    E remove(E value);

    E remove(int index);

    int indexOf(E value);

    boolean contains(E value);

}
