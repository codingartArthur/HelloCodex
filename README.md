# Spring Sorting 示例

该项目是一个使用 Maven 构建、基于 Spring Framework 6 的简单 Java 11 示例工程，演示了两种以上的排序算法（冒泡排序与归并排序），并通过 Spring 的依赖注入机制对算法进行统一调度。

## 环境要求

- Java 11 及以上
- Maven 3.9+

> **提示：**Spring Framework 6 官方要求至少 Java 17 运行环境。本示例在 Java 21 上通过测试，如需在本地运行请确保 JDK 版本满足 Spring 的最低要求。

## 构建与运行

```bash
mvn clean package
java -cp target/spring-sorting-1.0.0-SNAPSHOT.jar com.example.sorting.SortingApplication
```

执行 `SortingApplication` 的 `main` 方法后，将输出各个排序算法的排序结果。

## 测试

```bash
mvn test
```

## 项目结构

```
src/
  main/java/com/example/sorting/
    SortingApplication.java    # 入口程序
    SortingConfig.java         # Spring 组件扫描配置
    SortingService.java        # 统一的排序服务
    BubbleSortAlgorithm.java   # 冒泡排序实现
    MergeSortAlgorithm.java    # 归并排序实现
  test/java/com/example/sorting/
    SortingServiceTest.java    # 单元测试
```
