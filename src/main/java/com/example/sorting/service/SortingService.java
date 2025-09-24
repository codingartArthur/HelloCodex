package com.example.sorting.service;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.sorting.algorithm.Sorter;

/**
 * Delegates sorting requests to the algorithm beans registered in the Spring context.
 */
@Service
public class SortingService {

    private final Map<String, Sorter> sortersByName;

    public SortingService(List<Sorter> sorters) {
        this.sortersByName = sorters.stream()
                .collect(Collectors.toUnmodifiableMap(
                        sorter -> sorter.getName().toLowerCase(Locale.ROOT),
                        sorter -> sorter));
    }

    public List<Integer> sort(String algorithm, List<Integer> numbers) {
        return Optional.ofNullable(sortersByName.get(normalize(algorithm)))
                .orElseThrow(() -> new IllegalArgumentException(
                        "Unknown algorithm: " + algorithm + ". Available: " + sortersByName.keySet()))
                .sort(numbers);
    }

    public Map<String, Sorter> getAvailableSorters() {
        return sortersByName;
    }

    private String normalize(String algorithm) {
        return algorithm.toLowerCase(Locale.ROOT);
    }
}
