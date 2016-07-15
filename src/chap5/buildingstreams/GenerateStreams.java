package chap5.buildingstreams;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class GenerateStreams {

    public static void main(String[] args) {
        IntStream ones = IntStream.generate(() -> 1);
        IntStream twos = IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        });
        IntStream fibs = IntStream.generate(new IntSupplier() {
            private int previous = 0;
            private int cur = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = previous;
                int oldCur = cur;
                int nextValue = previous + cur;
                previous = oldCur;
                cur = nextValue;
                return cur;
            }
        });

        ones.limit(20)
            .forEach(System.out::println);

        int sum = fibs.limit(30)
                      .reduce((a, b) -> a + b)
                      .getAsInt();
        System.out.println(sum);
    }
}
