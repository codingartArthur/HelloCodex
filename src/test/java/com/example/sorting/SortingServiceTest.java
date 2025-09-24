package com.example.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.sorting.config.SortingConfig;
import com.example.sorting.service.SortingService;

class SortingServiceTest {

    @Test
    void bubbleSortOrdersNumbers() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SortingConfig.class)) {
            SortingService sortingService = context.getBean(SortingService.class);
            List<Integer> result = sortingService.sort("bubble", Arrays.asList(3, 1, 2));
            assertEquals(Arrays.asList(1, 2, 3), result);
        }
    }

    @Test
    void quickSortOrdersNumbers() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SortingConfig.class)) {
            SortingService sortingService = context.getBean(SortingService.class);
            List<Integer> result = sortingService.sort("quick", Arrays.asList(9, 4, 7, 1));
            assertEquals(Arrays.asList(1, 4, 7, 9), result);
        }
    }

    @Test
    void mergeSortOrdersNumbers() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SortingConfig.class)) {
            SortingService sortingService = context.getBean(SortingService.class);
            List<Integer> result = sortingService.sort("merge", Arrays.asList(5, 2, 8, 6, 3));
            assertEquals(Arrays.asList(2, 3, 5, 6, 8), result);
        }
    }

    @Test
    void unknownAlgorithmThrowsException() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SortingConfig.class)) {
            SortingService sortingService = context.getBean(SortingService.class);
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> sortingService.sort("unknown", Arrays.asList(1, 2, 3)));
            assertEquals("Unknown algorithm: unknown. Available: " + availableAlgorithms(sortingService), exception.getMessage());
        }
    }

    private String availableAlgorithms(SortingService sortingService) {
        return sortingService.getAvailableSorters().keySet().toString();
    }
}
