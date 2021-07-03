import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// flat map is used for one to many map conversion
public class FlatMap {
    public static List<Integer> getDivisors(int n) {
        int limit = (int) Math.floor(Math.sqrt(n));
        return IntStream.iterate(1, d -> d + 1)
                        .limit(limit)
                        .filter(d -> n % d == 0)
                        .flatMap(d -> d != (n / d) ? IntStream.of(d, n / d) : IntStream.of(d))
                        .boxed()
                        .collect(Collectors.toList());
        /*
        Note: from Java 9 no need to calculate  limit with sqrt.
              takeWhile(Predicate<? extends T>), dropWhile(Predicate<? extends T>) is available
        return IntStream.iterate(1, d -> d + 1)
                        .takeWhile(d -> d * d <= n)
                        .filter(d -> n % d == 0)
                        .flatMap(d -> d != (n / d) ? IntStream.of(d, n / d) : IntStream.of(d))
                        .boxed()
                        .collect(Collectors.toList());*/
    }

    public static void main(String[] args) {
        System.out.println(getDivisors(36));
    }
}
