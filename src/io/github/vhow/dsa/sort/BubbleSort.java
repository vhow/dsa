package io.github.vhow.dsa.sort;

public class BubbleSort extends AbstractSort {
    @Override
    public <T extends Comparable<T>> void sort(T[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (less(a, j + 1, j)) {
                    swap(a, j + 1, j);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        new BubbleSort().test();
    }
}
