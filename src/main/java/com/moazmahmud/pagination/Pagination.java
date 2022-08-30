package com.moazmahmud.pagination;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Pagination {
    public static <T> List<Page<T>> getPageList(List<T> listOfT, int pageSize) {
        List<Page<T>> pages = new ArrayList<>();
        int index = 0, size = listOfT.size();
        while (index < size) {
            var page = new Page<T>();
            page.pageIndex = pages.size();
            page.data = new ArrayList<>();
            page.pageSize = pageSize;
            page.isFirstPage = index == 0;
            while (index < size && page.data.size() < pageSize) {
                page.isLastPage = index == (size - 1);
                page.data.add(listOfT.get(index));
                ++index;
            }
            pages.add(page);
        }
        pages.forEach(page -> page.totalPages = pages.size());
        return pages;
    }

    public static <T> Stream<Page<T>> getPageStream(List<T> listOfT, int pageSize) {
        int totalPages = getTotalPages(listOfT.size(), pageSize);
        return Stream.iterate(getSeedPage(pageSize, totalPages), (Page<T> page) -> page.getNextPage(listOfT))
                     .skip(1)
                     .limit(totalPages);
    }

    private static <T> Page<T> getSeedPage(int pageSize, int totalPages) {
        var page = new Page<T>();
        page.pageIndex = -1;
        page.pageSize = pageSize;
        page.totalPages = totalPages;
        return page;
    }

    private static int getTotalPages(int listSize, int pageSize) {
        int q = listSize / pageSize;
        int r = listSize % pageSize;
        return q + (r == 0 ? 0 : 1);
    }
}