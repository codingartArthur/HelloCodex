package com.example.sorting;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Entry point for showcasing the sorting service.
 */
public class SortingApplication {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(SortingConfig.class)) {

            SortingService sortingService = context.getBean(SortingService.class);
            int[] numbers = {5, 2, 8, 3, 9, 1};

            for (String algorithm : sortingService.getAvailableAlgorithms()) {
                int[] sorted = sortingService.sort(algorithm, numbers);
                System.out.printf("%s sort result: %s%n", algorithm, Arrays.toString(sorted));
            }
        }
    }
}
