package com.moazmahmud.pagination;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Pagination {
    public static <T> List<Page<T>> getPageList(List<T> listOfT, int pageSize) {
        List<Page<T>> pages = new ArrayList<>();
        int index = 0, size = listOfT.size();
        while (index < size) {
            Page<T> page = new Page<>();
            page.pageIndex = pages.size();
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
        return Stream.<Page<T>>iterate(getSeedPage(pageSize, totalPages), page -> page.moveToNextPage(listOfT))
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