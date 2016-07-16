package chap6.grouping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import chap4.Dish;
import chap4.Dish.Type;

public class Subgroups {

    List<Dish> menu = Dish.menu;

    void groupThenCount() {
        Map<Type, Long> typeCount = menu.stream().collect(Collectors.groupingBy(
                Dish::getType, Collectors.counting()));
        System.out.println(typeCount);
    }

    void typeCalCount() {
        Map<Type, Integer> typeCals = menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.summingInt(Dish::getCalories)));
        System.out.println(typeCals);
    }

    void typeMaxCal() {
        Map<Type, Optional<Dish>> typeMaxCal = menu.stream().collect(
                Collectors.groupingBy(Dish::getType,
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(typeMaxCal);
    }

    void mostCaloricByType() {
        Map<Type, Dish> mostCals = menu.stream()
            .collect(Collectors.groupingBy(Dish::getType,
                     Collectors.collectingAndThen(
                             Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                             Optional::get)));
        System.out.println(mostCals);
    }

    void caloriesByType() {
        Map<Type, List<String>> calsByType = menu.stream().collect(
                Collectors.groupingBy(Dish::getType, Collectors.mapping(
                        getCaloricLevel(),
                        Collectors.toList())));
        System.out.println(calsByType);
    }

    void namesByType() {
        Map<Type, List<String>> namesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.mapping(Dish::getName, Collectors.toCollection(ArrayList::new))));
        System.out.println(namesByType);

    }

    Function<Dish, String> getCaloricLevel() {
        return (Dish d) -> {
            if (d.getCalories() <= 400) return "LOW";
            else if (d.getCalories() <= 700) return "MED";
            else return "HIGH";
        };
    }

    public static void main(String[] args) {
        Subgroups sg = new Subgroups();
        sg.groupThenCount();
        sg.typeCalCount();
        sg.typeMaxCal();
        sg.mostCaloricByType();
        sg.caloriesByType();
        sg.namesByType();
    }
}
