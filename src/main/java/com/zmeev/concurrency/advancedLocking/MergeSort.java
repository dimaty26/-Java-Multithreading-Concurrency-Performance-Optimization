package com.zmeev.concurrency.advancedLocking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        int[] ints = {1, 6, 4, 2, 3, 15, 12};
        System.out.println(Arrays.toString(slice(ints, 1, 4)));

    }

    public int[] mergeSort(int[] array) {
        if (array.length < 2) return array;

        int midIndex = (int) Math.floor(array.length / 2);
        int[] leftArr = slice(array, 0, midIndex);
        int[] rightArr = slice(array, midIndex, array.length);

        return merge(mergeSort(leftArr), mergeSort(rightArr));
    }

    private int[] merge(int[] leftArr, int[] rightArr) {
        List<Integer> resultList = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                resultList.add(leftArr[leftIndex]);
                leftIndex++;
            } else {
                resultList.add(rightArr[rightIndex]);
                rightIndex++;
            }
        }

        if (rightIndex == rightArr.length) {
            resultList.add(leftArr[leftIndex]);
        } else {
            resultList.add(rightArr[rightIndex]);
        }

        int[] resultArr = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }
        return resultArr;
    }

    private static int[] slice(int[] array, int start, int end) {
        int length = end - start;
        int[] result = new int[length];

        for (int i = start, j = 0; i < end; j++, i++) {
            result[j] = array[i];
        }
        return result;
    }
}
