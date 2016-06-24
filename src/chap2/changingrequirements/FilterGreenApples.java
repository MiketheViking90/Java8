package chap2.changingrequirements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterGreenApples {

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> greenApples = new ArrayList<>();

        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                greenApples.add(apple);
            }
        }
        return greenApples;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory,
                                                    String color) {
        List<Apple> coloredApples = new ArrayList<>();

        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                coloredApples.add(apple);
            }
        }
        return coloredApples;
    }

    public static List<Apple> filter(List<Apple> inventory,
                                     ApplePredicate predicate) {
        List<Apple> filteredApples = new ArrayList<>();

        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                filteredApples.add(apple);
            }
        }
        return filteredApples;
    }

    public static void main(String[] args) {
        Apple apple1 = new Apple("green", 170);
        Apple apple2 = new Apple("red", 100);
        Apple apple3 = new Apple("green", 100);
        Apple apple4 = new Apple("red", 180);
        List<Apple> inventory = Arrays.asList(apple1, apple2, apple3, apple4);

        List<Apple> greenApples = filter(inventory, new GreenApplePredicate());
        List<Apple> heavyApples = filter(inventory, new HeavyApplePredicate());
        System.out.println(greenApples);
        System.out.println(heavyApples);
    }

}
