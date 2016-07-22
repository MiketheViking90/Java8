package chap7.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinCalculator extends RecursiveTask<Long> {

    private static final long THRESHOLD = 10_000;

    private final long[] numbers;
    private final int start;
    private final int end;

    public ForkJoinCalculator(long[] numbers) {
        this.numbers = numbers;
        start = 0;
        end = numbers.length;
    }

    public ForkJoinCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }

        ForkJoinCalculator leftTask =
                new ForkJoinCalculator(numbers, start, start + length/2);
        ForkJoinCalculator rightTask =
                new ForkJoinCalculator(numbers, start + length/2, end);
        Long leftResult = leftTask.compute();
        Long rightResult = rightTask.compute();
        return leftResult + rightResult;
    }

    private Long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 30_000_000).toArray();
        ForkJoinTask<Long> task = new ForkJoinCalculator(numbers);

        long startTime = System.currentTimeMillis();
        Long val = new ForkJoinPool().invoke(task);
        long runTime = System.currentTimeMillis() - startTime;
        System.out.println(val + ", " + runTime + " ms");
    }
}
