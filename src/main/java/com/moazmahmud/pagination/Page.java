package com.moazmahmud.pagination;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
public class Page<T> {
    List<T> data = new ArrayList<>();
    int pageIndex;
    int pageSize;
    int totalPages;
    boolean isFirstPage;
    boolean isLastPage;

    public Page<T> moveToNextPage(List<T> listOfT) {
        var nextPage = new Page<T>();
        nextPage.pageIndex = pageIndex + 1;
        nextPage.pageSize = pageSize;
        nextPage.totalPages = totalPages;
        nextPage.isFirstPage = nextPage.pageIndex == 0;
        nextPage.isLastPage = nextPage.pageIndex == (nextPage.totalPages - 1);
        nextPage.data = listOfT.stream()
                               .skip((long) nextPage.pageIndex * nextPage.pageSize)
                               .limit(nextPage.pageSize)
                               .collect(Collectors.toList());
        return nextPage;
    }
}