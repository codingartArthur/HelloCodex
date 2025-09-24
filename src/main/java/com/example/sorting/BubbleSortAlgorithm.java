package com.example.sorting;

import org.springframework.stereotype.Component;

/**
 * Simple bubble sort implementation.
 */
@Component
public class BubbleSortAlgorithm implements SortingAlgorithm {

    @Override
    public String getName() {
        return "bubble";
    }

    @Override
    public int[] sort(int[] input) {
        int[] data = input.clone();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < data.length; i++) {
                if (data[i - 1] > data[i]) {
                    int temp = data[i - 1];
                    data[i - 1] = data[i];
                    data[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        return data;
    }
}
