package com.example.sorting.algorithm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Merge sort implementation that recursively divides the list into halves.
 */
@Component
public class MergeSortAlgorithm implements Sorter {

    @Override
    public List<Integer> sort(List<Integer> numbers) {
        if (numbers.size() <= 1) {
            return new ArrayList<>(numbers);
        }
        int mid = numbers.size() / 2;
        List<Integer> left = sort(numbers.subList(0, mid));
        List<Integer> right = sort(numbers.subList(mid, numbers.size()));
        return merge(left, right);
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>(left.size() + right.size());
        int i = 0;
        int j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }
        while (i < left.size()) {
            merged.add(left.get(i++));
        }
        while (j < right.size()) {
            merged.add(right.get(j++));
        }
        return merged;
    }

    @Override
    public String getName() {
        return "merge";
    }
}
