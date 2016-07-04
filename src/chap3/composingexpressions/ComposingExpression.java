package chap3.composingexpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import chap3.practice.Apple;

public class ComposingExpression {

    public static void main(String[] args) {
        Apple apple1 = new Apple(5, "red");
        Apple apple2 = new Apple(4, "green");
        Apple apple3 = new Apple(3, "blue");
        Apple apple4 = new Apple(2, "blue");

        List<Apple> inventory = Arrays.asList(apple1, apple2, apple3, apple4);

        Predicate<Apple> redApples = (Apple a) -> a.getColor().equals("red");
        Predicate<Apple> notRedApples = redApples.negate();
        Predicate<Apple> redAndHeavyApples =
                redApples.and((a -> a.getWeight() > 150));

        Function<Integer, Integer> add1 = (x) -> x + 1;
        Function<Integer, Integer> multiply2 = (x) -> 2 * x;
        Function<Integer, Integer> square = (x) -> x * x;
        Function<Integer, Integer> h = add1.andThen(multiply2);
        int val = h.apply(12);
        System.out.println(val);

        Function<Integer, Integer> gamma = square.compose(add1);
        System.out.println(gamma.apply(12));
    }

}
