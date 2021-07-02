import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IterateWithIntStream {
    public static void main(String[] args) {
        int[] fistTenIntegers = IntStream.range(0, 11).toArray(); // range(startInclusive, endExclusive)
        System.out.println("fistTenIntegers " + Arrays.toString(fistTenIntegers));
        fistTenIntegers = IntStream.rangeClosed(0, 10).toArray(); // rangeClosed(startInclusive,endInclusive)
        System.out.println("fistTenIntegers " + Arrays.toString(fistTenIntegers));

        int N = 10;
        List<Integer> firstNPrimes = IntStream.iterate(2, n -> n + 1)
                .filter(Util::isPrime)
                .limit(N)
                .boxed() // boxed is important because IntStream is a stream of int primitive
                .collect(Collectors.toList());
        System.out.println("firstNPrimes " + firstNPrimes);
    }
}
