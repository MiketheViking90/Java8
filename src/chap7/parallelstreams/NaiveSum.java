package chap7.parallelstreams;

import java.util.function.Function;
import java.util.stream.LongStream;

public class NaiveSum {

    void sumStream(int n) {
        long startTime = System.currentTimeMillis();
        long sum = LongStream.iterate(0L, i -> i+1)
                         .limit(n)
                         .reduce(0L, Long::sum);
        long runTime = System.currentTimeMillis() - startTime;
        System.out.println(sum + ", " + runTime);
    }

    void parallelSumStream(int n) {
        long startTime = System.currentTimeMillis();
        long sum = LongStream.iterate(0L, i -> i+1)
                         .limit(n)
                         .parallel()
                         .reduce(0L, Long::sum);
        long runTime = System.currentTimeMillis() - startTime;
        System.out.println(sum + ", " + runTime);
    }

    long measurePerformance(Function<Long, Long> function, long n) {
        long startTime = System.nanoTime();
        long val = function.apply(n);
        return System.nanoTime() - startTime;
    }
    public static void main(String[] args) {
        NaiveSum ns = new NaiveSum();
        int n = 40;

        ns.sumStream(n);
        ns.parallelSumStream(n);
    }
}
