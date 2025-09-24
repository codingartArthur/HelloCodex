package com.example.sorting;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.sorting.config.SortingConfig;
import com.example.sorting.service.SortingService;

/**
 * Entry point that bootstraps the Spring context and demonstrates the algorithms.
 */
public class SortingApplication {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SortingConfig.class)) {
            SortingService sortingService = context.getBean(SortingService.class);

            List<Integer> numbers = Arrays.asList(5, 3, 9, 1, 4, 8);
            sortingService.getAvailableSorters().keySet().forEach(algorithm -> {
                List<Integer> sorted = sortingService.sort(algorithm, numbers);
                System.out.printf("%s sort: %s -> %s%n", algorithm, numbers, sorted);
            });
        }
    }
}
