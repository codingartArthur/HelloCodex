# Sorting Application

This project is a simple Maven-based Java application built with the Spring Framework 6 that showcases multiple sorting algorithms. It targets Java 11 source compatibility while running on any JDK that satisfies Spring's runtime requirements.

## Features

- Spring-managed sorting algorithms with a shared `Sorter` interface
- Bubble sort, merge sort and quick sort implementations
- A `SortingService` bean that delegates to available algorithms
- Command-line application entry point and unit tests powered by JUnit 5

> **Note:** Spring Framework 6 requires Java 17 or higher at runtime. The project is compiled for Java 11 source compatibility, so run it with a Java 17+ runtime.

## Build and test

Ensure Maven is installed and run:

```bash
mvn clean test
```

To run the demonstration application:

```bash
mvn -q exec:java -Dexec.mainClass=com.example.sorting.SortingApplication
```

The application will load the Spring context and print the results of the available sorting algorithms.
