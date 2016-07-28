package chap9.defaultmethods;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodExamples {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6);
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
    }
}
