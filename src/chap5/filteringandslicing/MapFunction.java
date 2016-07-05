package chap5.filteringandslicing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import chap4.Dish;

public class MapFunction {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java8", "Lambdas", "Streams", "Concurrency");
        List<Integer> lengths = words.stream()
                                     .map(String::length)
                                     .collect(Collectors.toList());
        System.out.println(lengths);

        List<String> dishNames = Dish.menu.stream()
                                          .map(Dish::getName)
                                          .collect(Collectors.toList());
        System.out.println(dishNames);

        System.out.println(
            words.stream()
                 .map(word -> word.split(""))
                 .distinct()
                 .collect(Collectors.toList()));

        System.out.println(
            words.stream()
                 .map(word -> word.split(""))
                 .flatMap(Arrays::stream)
                 .distinct()
                 .collect(Collectors.toList())
                 );

        List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> squares = ints.stream()
                                    .map(x -> x*x)
                                    .collect(Collectors.toList());
        System.out.println(squares);

        List<Integer> intSlice = ints.stream()
                                     .skip(2)
                                     .limit(4)
                                     .collect(Collectors.toList());
        System.out.println(intSlice);

    }
}
