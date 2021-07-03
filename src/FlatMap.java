import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// flat map is used for one to many map conversion
public class FlatMap {
    public static List<Integer> getDivisors(int n) {
        return IntStream.iterate(1, d -> d * d <= n, d -> d + 1)
                        .filter(d -> n % d == 0)
                        .flatMap(d -> d != (n / d) ? IntStream.of(d, n / d) : IntStream.of(d))
                        .boxed()
                        .collect(Collectors.toList());
        /*
        Note: the above code is valid from Java 9. takeWhile(Predicate<? extends T>), dropWhile(Predicate<? extends T>)
              iterate(int seed, IntPredicate hasNext, IntUnaryOperator next) is available only from Java 9.
        Stream API is introduced from Java 8. This code is for Java 8.

        int limit = (int) Math.floor(Math.sqrt(n));
        return IntStream.rangeClosed(1, limit)
                        .filter(d -> n % d == 0)
                        .flatMap(d -> d != (n / d) ? IntStream.of(d, n / d) : IntStream.of(d))
                        .boxed()
                        .collect(Collectors.toList());
        */
    }

    public static void main(String[] args) {
        System.out.println(getDivisors(36));
    }
}
