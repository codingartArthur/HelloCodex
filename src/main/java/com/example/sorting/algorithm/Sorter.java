package com.example.sorting.algorithm;

import java.util.List;

/**
 * Common contract for sorting algorithms operating on integer lists.
 */
public interface Sorter {

    /**
     * Sorts the provided list and returns a new {@link List} with the values in ascending order.
     *
     * @param numbers values to sort
     * @return sorted values
     */
    List<Integer> sort(List<Integer> numbers);

    /**
     * @return algorithm name to expose via Spring's dependency lookup
     */
    String getName();
}
