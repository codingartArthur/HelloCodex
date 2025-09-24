package com.example.sorting;

import org.springframework.stereotype.Component;

/**
 * Merge sort implementation.
 */
@Component
public class MergeSortAlgorithm implements SortingAlgorithm {

    @Override
    public String getName() {
        return "merge";
    }

    @Override
    public int[] sort(int[] input) {
        int[] data = input.clone();
        mergeSort(data, 0, data.length - 1, new int[data.length]);
        return data;
    }

    private void mergeSort(int[] data, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(data, left, mid, temp);
        mergeSort(data, mid + 1, right, temp);
        merge(data, left, mid, right, temp);
    }

    private void merge(int[] data, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (data[i] <= data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = data[i++];
        }

        while (j <= right) {
            temp[k++] = data[j++];
        }

        for (int index = left; index <= right; index++) {
            data[index] = temp[index];
        }
    }
}
