package chap7.parallelstreams;

import java.util.stream.Stream;

public class NaiveSum {

    void sumStream() {
        int n = 20;

        long sum = Stream.iterate(0L, i -> i+1)
                         .limit(n)
                         .reduce(0L, Long::sum);
        System.out.println(sum);
    }

    public static void main(String[] args) {
        NaiveSum ns = new NaiveSum();
        ns.sumStream();
    }
}
