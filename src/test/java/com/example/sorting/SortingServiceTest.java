package com.example.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SortingConfig.class)
class SortingServiceTest {

    private final SortingService sortingService;

    SortingServiceTest(SortingService sortingService) {
        this.sortingService = sortingService;
    }

    @Test
    @DisplayName("bubble sort correctly orders the numbers")
    void bubbleSort() {
        int[] result = sortingService.sort("bubble", new int[]{4, 2, 7, 1});
        assertThat(result).containsExactly(1, 2, 4, 7);
    }

    @Test
    @DisplayName("merge sort correctly orders the numbers")
    void mergeSort() {
        int[] result = sortingService.sort("merge", new int[]{9, 3, 5, 1, 8});
        assertThat(result).containsExactly(1, 3, 5, 8, 9);
    }

    @Test
    @DisplayName("requesting an unknown algorithm fails fast")
    void unknownAlgorithm() {
        assertThrows(IllegalArgumentException.class, () -> sortingService.sort("unknown", new int[]{1, 2, 3}));
    }
}
