package com.moazmahmud;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RangeGenerate {
    public static void main(String[] args) {
        int nPassword = 10;

        List<String> passwordsWithRange = IntStream.range(0, nPassword)
                                                   .mapToObj(i -> i + " : " + generatePassword(15))
                                                   .collect(Collectors.toList());
        passwordsWithRange.forEach(System.out::println);

        List<String> passwordsWithGenerate = Stream.generate(() -> generatePassword(15))
                                                   .limit(nPassword)
                                                   .collect(Collectors.toList());
        passwordsWithGenerate.forEach(System.out::println);
    }

    public static String generatePassword(int length) {
        return new PasswordGenerator.PasswordGeneratorBuilder().useDigits(true)
                                                               .useLower(true)
                                                               .useUpper(true)
                                                               .build()
                                                               .generate(length);
    }
}
