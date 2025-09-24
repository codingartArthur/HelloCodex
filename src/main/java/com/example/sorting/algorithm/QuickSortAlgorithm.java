package com.example.sorting.algorithm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Quick sort implementation using divide and conquer.
 */
@Component
public class QuickSortAlgorithm implements Sorter {

    @Override
    public List<Integer> sort(List<Integer> numbers) {
        List<Integer> copy = new ArrayList<>(numbers);
        quickSort(copy, 0, copy.size() - 1);
        return copy;
    }

    private void quickSort(List<Integer> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private int partition(List<Integer> list, int low, int high) {
        int pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    @Override
    public String getName() {
        return "quick";
    }
}
