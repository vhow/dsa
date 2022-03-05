package io.github.vhow.dsa.sort;

public class InsertionSort extends AbstractSort {
    @Override
    public <T extends Comparable<T>> void sort(T[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a, j, j - 1)) {
                    swap(a, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        new InsertionSort().test();
    }
}
