package io.github.vhow.dsa.sort;

public class QuickSort extends AbstractSort {
    @Override
    public <T extends Comparable<T>> void sort(T[] a) {
        sort(a, 0, a.length - 1);
    }

    <T extends Comparable<T>> void sort(T[] a, int start, int end) {
        if (start < end) {
            final int pivot = partition(a, start, end);
            sort(a, start, pivot - 1);
            sort(a, pivot + 1, end);
        }
    }

    private <T extends Comparable<T>> int partition(T[] a, int start, int end) {
        int i = start;
        for (int j = start; j < end; j++) {
            if (less(a, j, end)) {
                swap(a, j, i++);
            }
        }
        swap(a, i, end);
        return i;
    }

    public static void main(String[] args) {
        new QuickSort().test();
    }
}
