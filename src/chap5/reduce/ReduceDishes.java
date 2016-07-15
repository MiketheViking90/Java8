package chap5.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

import chap4.Dish;

public class ReduceDishes {

    private static void getMax(List<Integer> numbers) {
        Optional<Integer> max = numbers.stream().reduce((a, b) -> Math.max(a, b));
        System.out.println(max.get());
    }

    private static void findMaxCalories(List<Dish> menu) {
        BinaryOperator<Dish> getDishWithMoreCalories =
                (Dish d1, Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2;
        Dish heaviestDish = menu.stream()
                                .reduce(getDishWithMoreCalories)
                                .get();
        System.out.println(heaviestDish);
    }

    private static void countDishesReduce(List<Dish> menu) {
        long longCount = menu.stream().count();
        System.out.println(longCount);

        int count = menu.stream().map(d -> 1).reduce(Integer::sum).get();
        System.out.println(count);
    }

    private static void concatStrings() {
        List<String> strings = Arrays.asList("a", "b", "c", "d");
        String concat = strings.stream().reduce((a, b) -> a+b).get();
        System.out.println(concat);
    }
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        List<Integer> ints = Arrays.asList(1,2,3,4,5,6);
        findMaxCalories(menu);
        countDishesReduce(menu);
        getMax(ints);
        concatStrings();
    }
}
