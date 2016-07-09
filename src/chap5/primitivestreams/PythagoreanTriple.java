package chap5.primitivestreams;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PythagoreanTriple {

    private static boolean isInteger(double d) {
        return d % 1.0 == 0;
    }

    public static void main(String[] args) {
        BiPredicate<Integer, Integer> canFormTriple =
                (Integer a, Integer b) -> ((Math.sqrt(a*a + b*b) % 1.0) == 0);

        int a = 5;
        IntPredicate isTriple =
                (b -> (Math.sqrt(a*a + b*b)) % 1.0 == 0);

        IntStream.rangeClosed(0, 100)
                 .filter(isTriple)
                 .boxed()
                 .map(b -> new int[]{a, b, 4});

    }
}
