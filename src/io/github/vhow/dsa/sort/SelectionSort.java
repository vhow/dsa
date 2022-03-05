package io.github.vhow.dsa.sort;

public class SelectionSort extends AbstractSort {
    @Override
    public <T extends Comparable<T>> void sort(T[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a, j, min)) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

    public static void main(String[] args) {
        new SelectionSort().test();
    }
}
