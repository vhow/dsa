package io.github.vhow.dsa.sort;

public class MergeSort extends AbstractSort {
    @Override
    <T extends Comparable<T>> void sort(T[] a) {
        final Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private void sort(Comparable[] a, Comparable[] aux, int start, int end) {
        if (start < end) {
            final int mid = start + ((end - start) >> 1);
            sort(a, aux, start, mid);
            sort(a, aux, mid + 1, end);
            merge(a, aux, start, mid, end);
        }
    }

    private void merge(Comparable[] a, Comparable[] aux, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            aux[i] = a[i];
        }
        int i = start;
        int j = mid + 1;
        for (int k = start; k <= end; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > end) {
                a[k] = aux[i++];
            } else if (less(aux, i, j)) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        new MergeSort().test();
    }
}
