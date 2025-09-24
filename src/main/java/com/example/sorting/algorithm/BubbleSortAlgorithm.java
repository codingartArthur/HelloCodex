package com.example.sorting.algorithm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Simple bubble sort implementation.
 */
@Component
public class BubbleSortAlgorithm implements Sorter {

    @Override
    public List<Integer> sort(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>(numbers);
        int n = result.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (result.get(i - 1) > result.get(i)) {
                    int temp = result.get(i);
                    result.set(i, result.get(i - 1));
                    result.set(i - 1, temp);
                    swapped = true;
                }
            }
            n--; // After each pass the largest value is guaranteed to be at the end.
        } while (swapped);
        return result;
    }

    @Override
    public String getName() {
        return "bubble";
    }
}
