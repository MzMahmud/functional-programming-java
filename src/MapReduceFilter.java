import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MapReduceFilter {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 8, 11, 13, 7, 9, 7, 4, 23, 1, -1, null, 23, 45, null, -8, 0);
        System.out.println("numbers " + numbers);

        List<Integer> nonNullNumbers = numbers.stream()
                                              .filter(Objects::nonNull)
                                              .collect(Collectors.toList());
        System.out.println("nonNullNumbers " + nonNullNumbers);

        List<Integer> distinctPositiveNumbers = nonNullNumbers.stream()
                                                              .distinct()
                                                              .filter(n -> n > 0)
                                                              .collect(Collectors.toList());
        System.out.println("distinctPositiveNumbers " + distinctPositiveNumbers);

        List<Integer> sortedPrimes = distinctPositiveNumbers.stream()
                                                            .filter(Util::isPrime)
                                                            // .sorted() // ascending
                                                            .sorted((a, b) -> b - a) // descending
                                                            .collect(Collectors.toList());
        System.out.println("sortedPrimes " + sortedPrimes);

        long sumSortedPrimes = sortedPrimes.stream()
                                           .mapToInt(Integer::new)
                                           .sum();
        System.out.println("Sum sortedPrimes " + sumSortedPrimes);

        long productWithReduce = numbers.stream()
                                        .filter(Objects::nonNull)
                                        .filter(n -> n > 0)
                                        .mapToLong(Integer::longValue)
                                        .reduce(1L, (a, b) -> a * b);
        System.out.println("productWithReduce " + productWithReduce);
    }
}
