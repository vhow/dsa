package io.github.vhow.dsa.search;

public class BinarySearch {

    public static <T extends Comparable<T>> int indexOf(T[] a, T key) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            final int mid = start + (end - start) / 2;
            final int compare = a[mid].compareTo(key);
            if (compare > 0) {
                end = mid - 1;
            } else if (compare < 0) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
