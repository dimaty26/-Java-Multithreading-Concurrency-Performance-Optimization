package com.zmeev.concurrency.advancedLocking;

public class BinarySearchApp {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int end = array.length - 1;
        int target = 9;
        boolean result = binarySearch(array, 0, end, target);
        System.out.println(result);
    }

    public static boolean binarySearch(int[] array, int start, int end, int target) {
        if (start > end) return false;
        int midIndex = (int) Math.floor((start + end) / 2);
        if (array[midIndex] == target) return true;

        if (array[midIndex] > target) return binarySearch(array, start, midIndex - 1, target);
        else return binarySearch(array, midIndex + 1, end, target);
    }
}
