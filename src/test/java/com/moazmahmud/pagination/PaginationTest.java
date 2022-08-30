package com.moazmahmud.pagination;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

class PaginationTest {
    @Test
    void testGetPageList() {
        List<Integer> integerList =
                IntStream.rangeClosed(1, 15)
                         .boxed()
                         .toList();
        Pagination.getPageList(integerList, 2)
                  .forEach(System.out::println);
    }

    @Test
    void testGetPageStream() {
        List<Integer> integerList =
                IntStream.rangeClosed(1, 15)
                         .boxed()
                         .toList();
        Pagination.getPageStream(integerList, 2)
                  .forEach(System.out::println);
    }
}