package chap5.filteringandslicing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import chap4.Dish;
import chap4.Dish.Type;

public class FilterPredicate {

    private static void printVeggieMenu(List<Dish> menu) {
        List<Dish> veggieMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());

        veggieMenu.stream()
                  .map(Dish::getName)
                  .map(s -> s + " is veggie")
                  .forEach(System.out::println);
    }

    private static void steamInts(List<Integer> vals) {
        vals.stream()
            .filter(i -> i % 2 == 0)
            .forEach(System.out::println);
    }

    private static void findUnique(List<Integer> vals) {
        List<Integer> uniqueVals = vals.stream()
                                       .distinct()
                                       .collect(Collectors.toList());
        System.out.println(uniqueVals);
    }

    private static void printMeatDishes(List<Dish> menu) {
        menu.stream()
                   .limit(2)
                   .filter(d -> d.getType().equals(Type.MEAT))
                   .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        printVeggieMenu(menu);
        printMeatDishes(menu);

        List<Integer> vals = Arrays.asList(1,2,1,3,3,2,4);
        steamInts(vals);
        findUnique(vals);
    }
}
