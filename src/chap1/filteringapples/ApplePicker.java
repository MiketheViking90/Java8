package chap1.filteringapples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ApplePicker {

    private List<Apple> inventory;

    public List<Apple> filterGreenApples() {
        List<Apple> greenApples = new ArrayList<>();
        for (Apple apple : inventory) {
            boolean isGreenApple = "green".equals(apple.getColor());
            if (isGreenApple) {
                greenApples.add(apple);
            }
        }
        return greenApples;
    }

    public List<Apple> filterHeavyApples() {
        List<Apple> heavyApples = new ArrayList<>();
        for (Apple apple : inventory) {
            boolean isHeavyApple = 150 <= apple.getWeight();
            if (isHeavyApple) {
                heavyApples.add(apple);
            }
        }
        return heavyApples;
    }

    public List<Apple> filterGreenApplesFunction() {
        return filterApples(inventory, ApplePicker::isGreenApple);
    }

    public List<Apple> filterHeavyApplesFunction() {
        return filterApples(inventory, ApplePicker::isHeavyApple);
    }

    public List<Apple> filterHeavyAppleStream() {
        List<Apple> heavyApples =
                inventory.stream()
                         .filter((Apple a) -> a.getWeight() > 150)
                         .collect(Collectors.toList());

        List<Apple> parallelHeavyApples =
                inventory.parallelStream()
                         .filter((Apple a) -> a.getWeight() > 150)
                         .collect(Collectors.toList());
        return heavyApples;
    }

    /* Begin Predicate Filter methods */
    private static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    private static boolean isHeavyApple(Apple apple) {
        return 150 <= apple.getWeight();
    }

    private List<Apple> filterApples(List<Apple> inventory,
                                    Predicate<Apple> predicate) {
        List<Apple> filteredApples = new ArrayList<>();
        return filteredApples;
    }

}
