package com.moazmahmud;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Util {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int d = 3; d * d <= n; d += 2)
            if (n % d == 0)
                return false;
        return true;
    }

    public static boolean isPrimeFunctional(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        return IntStream.iterate(3, d -> d * d <= n, d -> d + 2)
                        .noneMatch(d -> n % d == 0);
    }

    public static List<User> users = Arrays.asList(
            new User("Alice", LocalDate.of(1996, 10, 4), "Stanford"),
            new User("Bob", LocalDate.of(2000, 10, 15), "Harvard"),
            new User("John", LocalDate.of(1999, 8, 1), "MIT"),
            new User("Jane", LocalDate.of(1999, 4, 1), "Harvard"),
            new User("Henry", LocalDate.of(1996, 11, 1), "MIT"),
            new User("Michael", LocalDate.of(1997, 1, 1), "Stanford"),
            new User("Rachael", LocalDate.of(1994, 2, 1), "UCLA"),
            new User("Watsonn", LocalDate.of(1994, 2, 1), "UCLA"),
            new User("Natan", LocalDate.of(1998, 1, 1), "MIT")
    );
}
