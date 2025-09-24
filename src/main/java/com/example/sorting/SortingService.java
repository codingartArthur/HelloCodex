package com.example.sorting;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Spring managed service that delegates sorting to specific algorithms.
 */
@Service
public class SortingService {

    private final Map<String, SortingAlgorithm> algorithms;

    public SortingService(List<SortingAlgorithm> algorithms) {
        this.algorithms = algorithms.stream()
                .collect(Collectors.toUnmodifiableMap(SortingAlgorithm::getName, Function.identity()));
    }

    /**
     * Sorts the provided input using the requested algorithm.
     *
     * @param algorithmName the identifier of the algorithm (e.g. "bubble" or "merge")
     * @param input         the numbers to sort
     * @return the sorted data
     */
    public int[] sort(String algorithmName, int[] input) {
        SortingAlgorithm algorithm = algorithms.get(algorithmName);
        if (algorithm == null) {
            throw new IllegalArgumentException("Unknown algorithm: " + algorithmName);
        }
        return algorithm.sort(input);
    }

    /**
     * @return the list of available algorithms.
     */
    public List<String> getAvailableAlgorithms() {
        return algorithms.keySet().stream().sorted().collect(Collectors.toUnmodifiableList());
    }
}
