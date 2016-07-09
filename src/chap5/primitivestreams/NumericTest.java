package chap5.primitivestreams;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import chap4.Dish;

public class NumericTest {

    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        int sumCals = menu.stream()
                          .mapToInt(Dish::getCalories)
                          .sum();
        System.out.println(sumCals);

        OptionalInt maxCal = menu.stream().mapToInt(Dish::getCalories).max();

        List<Integer> evens = IntStream.rangeClosed(0, 100)
                                       .filter(d -> d%2 == 0)
                                       .boxed()
                                       .collect(Collectors.toList());
    }
}
