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
        IntPredicate isTriple = (b -> (isInteger(Math.sqrt(a*a + b*b))));

        IntStream.rangeClosed(0, 100)
                 .filter(isTriple)
                 .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a*a + b*b)});

//        Stream<int[]> pythTriples =
//                IntStream.rangeClosed(1, 100).boxed()
//                         .flatMap(a ->
//                                 IntStream.rangeClosed(a, 100)
//                                          .filter((b -> (isInteger(Math.sqrt(a*a + b*b)))))
//                                          .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a*a + b*b)}));
    }
}
