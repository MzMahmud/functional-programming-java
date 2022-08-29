package com.moazmahmud.pagination;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PaginationTest {
    @Test
    void testGetPageList() {
        List<Integer> integerList =
                Stream.iterate(1, n -> n + 1)
                      .limit(15)
                      .collect(Collectors.toList());
        Pagination.getPageList(integerList, 2)
                  .forEach(System.out::println);
    }

    @Test
    void testGetPageStream() {
        List<Integer> integerList =
                Stream.iterate(1, n -> n + 1)
                      .limit(15)
                      .collect(Collectors.toList());
        Pagination.getPageStream(integerList, 2)
                  .forEach(System.out::println);
    }
}