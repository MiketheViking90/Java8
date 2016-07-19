package chap7.parallelstreamscorrectly;

import java.util.stream.LongStream;

import lombok.Getter;

public class Accumulator {

    @Getter
    private long total = 0;

    public void add(long n) {
        total += n;
    }

    public static long showSideEffect(long n) {
        Accumulator accum = new Accumulator();
        LongStream.rangeClosed(0, n).parallel().forEach(accum::add);
        return accum.getTotal();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            long sum = Accumulator.showSideEffect(10_000L);
            System.out.println(sum);
        }
    }
}
