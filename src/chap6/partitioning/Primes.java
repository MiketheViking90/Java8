package chap6.partitioning;

import static java.util.stream.Collectors.partitioningBy;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Primes {

    boolean isPrime(int val) {
        int valRoot = (int) Math.sqrt(val);
        IntPredicate isRoot = (d) -> val%d == 0;
        return IntStream.rangeClosed(2, valRoot).noneMatch(isRoot);
    }

    public static void main(String[] args) {
        Primes p = new Primes();

        int n = 100;
        List<Integer> primes = IntStream.rangeClosed(2, n).boxed()
                                        .collect(partitioningBy(d -> p.isPrime(d))).get(true);
        System.out.println(primes);

        List<Integer> filterPrimes =
                IntStream.rangeClosed(2, n)
                         .filter(d -> p.isPrime(d)).boxed()
                         .collect(Collectors.toList());
        System.out.println(filterPrimes);
    }
}
