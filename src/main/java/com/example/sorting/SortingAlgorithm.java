package com.example.sorting;

/**
 * Common contract for sorting algorithms.
 */
public interface SortingAlgorithm {

    /**
     * @return the human friendly name of the algorithm.
     */
    String getName();

    /**
     * Sorts the provided data in ascending order.
     *
     * @param input the numbers to sort
     * @return a new array containing the sorted numbers
     */
    int[] sort(int[] input);
}
