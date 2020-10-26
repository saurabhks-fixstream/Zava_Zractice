package com.leetcode.javapractice;

interface ArrayReader {

    public int get(int index);
}

class ArrayReaderImpl implements ArrayReader {

    int[] array;

    public ArrayReaderImpl(int[] array) {
        this.array = array;
    }

    @Override
    public int get(int index) {
        if (index >= this.array.length) {
            return Integer.MAX_VALUE;
        }
        return this.array[index];
    }
}

public class SearchinaSortedArrayofUnknownSize {

    public static int search(ArrayReader reader, int target) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int num = reader.get(mid);
            if (num == target) {
                return mid;
            }
            if (num == Integer.MAX_VALUE || num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] array = {-1, 0, 3, 5, 9, 12};
        ArrayReader reader = new ArrayReaderImpl(array);
        System.out.println(search(reader, 9));
    }
}
